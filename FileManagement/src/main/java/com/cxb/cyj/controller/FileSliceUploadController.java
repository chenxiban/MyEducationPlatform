package com.cxb.cyj.controller;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.channels.FileChannel;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cxb.cyj.entity.FileSlice;
import com.cxb.cyj.service.UploadFileService;
import com.cxb.cyj.utils.IsEmptyUtils;
import com.cxb.cyj.utils.PropUtil;
import com.cxb.cyj.utils.SliceUtil;

import it.sauronsoftware.jave.Encoder;

@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileSliceUploadController {
	@Autowired
	private UploadFileService uploadFileService;

	/**
	 * http://localhost:8080/file/beforeUpload 文件上传之前的准备工作
	 * 
	 * @param name
	 * @param totalSize
	 * @param lastModified
	 * @return
	 */
	@RequestMapping(value="/beforeUpload",name="上传支持分片断点传输",method=RequestMethod.POST)
	public Map<String, Object> beforeUpload(@RequestBody FileSlice fileSlice) {
		System.out.println("beforeUpload fileSlice=>" + fileSlice);
		int slice = 0;// 文件是否续传
		String uuid = "";// 文件唯一标志
		Map<String, Object> result = new HashMap<String, Object>();
		// 根据文件信息查询文件是否续传
		uuid = PropUtil.queryUUIDbyFileinfo(fileSlice.getName(), fileSlice.getTotalSize());
		if (IsEmptyUtils.isEmpty(uuid)) {// 新文件上传

			uuid = PropUtil.createUUIDbyFileinfo(fileSlice.getName(), fileSlice.getTotalSize());
			fileSlice.setFid(uuid);// 新文件ID
			fileSlice.setPoint(0L);// 新文件断点从头开始
			System.out.println("新文件上传=>" + fileSlice);
			// 新文件传输开始,把FileSlice传输状态记录在磁盘
			PropUtil.createFileSlice(fileSlice);
			result.put("slice", 0);// 新文件
			result.put("uuid", uuid);// 文件唯一标志
			result.put("fileSlice", fileSlice);// 文件上传状态
			return result;

		} else {
			fileSlice = PropUtil.queryFileSliceByFid(fileSlice.getFid());// 查询出文件上次传输断点位置
			System.out.println("FileSliceUploadController.beforeUpload(FileSlice) 断点续传=>" + fileSlice);
			result.put("slice", 1);// 断点续传
			result.put("uuid", uuid);// 文件唯一标志
			result.put("fileSlice", fileSlice);// 文件上传状态
			return result;
		}
	}

	// http://localhost:8080/file/sliceUpload
	// 大文件分片上传,支持断点续传
	@RequestMapping("/sliceUpload")
	public Object sliceUpload(@RequestParam(value = "myfile", required = false) MultipartFile myfile,
			@RequestParam(value = "fid", required = true) String fid) {
		String name = myfile.getName();// form表单中参数名称
		String originalFilename = myfile.getOriginalFilename();// 得到上传文件的名称
		System.out.println("表单中文件参数名称 name=>" + name);
		System.out.println("上传的文件原始名称 originalfileName=>" + originalFilename);
		System.out.println("文件 fid=>" + fid);
		String msg = "文件大小=>" + myfile.getSize();
		FileSlice fileSlice = PropUtil.queryFileSliceByFid(fid);// 查询出文件上次传输断点位置
		byte[] sliceData = null;// 本次上传的字节数据
		try {
			sliceData = myfile.getBytes();// 本次上传的字节数据
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileSlice resultSlice = SliceUtil.writeSlice(fileSlice, sliceData);
		PropUtil.updateFileSlice(resultSlice);// 更新传输状态
		int slice = 1;// 文件是否续传
		String uuid = fid;// 文件唯一标志
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("slice", 1);// 断点续传
		result.put("uuid", uuid);// 文件唯一标志
		result.put("fileSlice", resultSlice);// 更新后的文件上传状态
		return result;
	}

	// http://localhost:8080/file/sliceUploadOver
	// 文件分片上传,传输完毕.删除所有传输状态记录并且保存数据库
	@RequestMapping("/sliceUploadOver")
	public Object sliceUploadOver(@RequestBody FileSlice fileSlice) {
		System.out.println("sliceUploadOver fileSlice=>" + fileSlice);
		// 根据文件信息,删除文件的UUID;并删除记录在fileslice.properties文件信息
		PropUtil.deleteUUIDbyFileinfo(fileSlice.getName(), fileSlice.getTotalSize());
		// 删除uuid.properties文件
		PropUtil.deleteFileSlice(fileSlice.getFid());
		// 创建文件路径
		String fileName = fileSlice.getName();//原始文件名称
		String fileSuffix  = fileName.substring(fileName.lastIndexOf("."));//获取文件后缀名称
		String path = "D:/fileUpload/" +fileSlice.getFid()+fileSuffix;
		Integer videoTime = null;
		String videoFormat = null;
		String videoCover = null;
		File dest = new File(path);
		Map<String, Object> result = new HashMap<String, Object>();
		if (this.isVedioFile(fileSlice.getName())) {
			Encoder encoder = new Encoder();
			// 获取上传视频截图
			processImg("D:\\fileUpload\\"  +fileSlice.getFid()+fileSuffix,
					"E:\\ffmpeg\\ffmpeg-20181215-011c911-win64-shared\\bin\\ffmpeg.exe");
			try {
				// 获取视频时长
				it.sauronsoftware.jave.MultimediaInfo m = encoder.getInfo(dest);
				long ls = m.getDuration();
				videoTime = (int) ((ls) / 1000);
				// 获取视频格式
				videoFormat = m.getFormat();
				// 视频截取图片
				videoCover = fileSlice.getName().substring(0, fileSlice.getName().indexOf(".")) + ".jpg";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			// 获取文件的大小
			FileInputStream fis = new FileInputStream(dest);
			FileChannel fc = fis.getChannel();
			BigDecimal fileSize = new BigDecimal(fc.size());
			String size = fileSize.divide(new BigDecimal(1048576), 2, RoundingMode.HALF_UP) + "MB";
			// 文件主键
			String files_id = fileSlice.getFid();
			String url = "http://localhost:6666/" + fileSlice.getName();
			if (uploadFileService.getFileByFileName(fileSlice.getName()) > 0) {
				uploadFileService.deleteFileByFileName(fileSlice.getName());
				dest.delete();
			}
			int q = uploadFileService.insertVidoFile(files_id, fileSlice.getName(), url, path, new Date(), size,
					videoTime, videoFormat, videoCover);
			if (q > 0) {
				result.put("result", true);
				result.put("fileName", fileSlice.getName());
				result.put("url", path);
				result.put("videoTime", videoTime);
				result.put("videoFormat", videoFormat);
				result.put("videoSize", size);
				result.put("videoCover", videoCover);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.put("slice", 1);// 断点续传
		result.put("uuid", fileSlice.getFid());// 文件唯一标志
		result.put("fileSlice", fileSlice);// 更新后的文件上传状态
		return result;
	}

	/**
	 * 访问路径为：http://localhost:3011/chenyongjia-file/FileManagement/file/downloadFile
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @author WangAnLing
	 */
	@RequestMapping(value = "/downloadFile", name = "下载文件", method = RequestMethod.POST)
	public String downloadFile(@RequestParam("fileName") String fileName,
			@RequestParam("request") HttpServletRequest request,
			@RequestParam("response") HttpServletResponse response) {
		// 设置文件名，根据业务需要替换成要下载的文件名
		if (fileName != null) {
			// 设置文件路径
			String realPath = "D://fileUpload//";
			File file = new File(realPath, fileName);
			if (file != null) {
				System.out.println(file);
				response.setContentType("application/force-download");// 设置强制下载不打开
				response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
				byte[] buffer = new byte[1024];
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				try {
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					OutputStream os = response.getOutputStream();
					int i = bis.read(buffer);
					while (i != -1) {
						os.write(buffer, 0, i);
						i = bis.read(buffer);
					}
					System.out.println("success");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (bis != null) {
						try {
							bis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (fis != null) {
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * 获取视频某一帧的截图作为视频封面
	 * 
	 * @param veido_path
	 * @param ffmpeg_path
	 * @return
	 */
	public static boolean processImg(String veido_path, String ffmpeg_path) {

		File file = new File(veido_path);

		if (!file.exists()) {

			System.err.println("路径[" + veido_path + "]对应的视频文件不存在!");

			return false;

		}

		List<String> commands = new java.util.ArrayList<String>();

		commands.add(ffmpeg_path);

		commands.add("-i");

		commands.add(veido_path);

		commands.add("-y");

		commands.add("-f");

		commands.add("image2");

		commands.add("-ss");

		commands.add("1");// 这个参数是设置截取视频多少秒时的画面

		commands.add("-t");

		commands.add("0.001");

		commands.add("-s");

		commands.add("1920x1080");// 宽X高

		commands.add(veido_path.substring(0, veido_path.lastIndexOf(".")).replaceFirst("vedio", "file") + ".jpg");

		try {

			ProcessBuilder builder = new ProcessBuilder();

			builder.command(commands);

			builder.start();

			System.out.println("截取成功");

			return true;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	/**
	 * 根据文件后缀名判断 文件是否是视频文件
	 * 
	 * @param fileName 文件名
	 * @return 是否是视频文件
	 */
	public static boolean isVedioFile(String fileName) {
		final String PREFIX_VIDEO = ".mp4";
		if (fileName.contains(PREFIX_VIDEO)) {
			return true;
		}
		return false;
	}

}
