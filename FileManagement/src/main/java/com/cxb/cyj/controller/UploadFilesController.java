package com.cxb.cyj.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.cxb.cyj.service.UploadFileService;

@RestController
@RequestMapping(value="/file",name="文件管理模块")
public class UploadFilesController {
	
	@Autowired
	private UploadFileService uploadFileService;

	private String url;

	/**
	 * 访问路径为：http://localhost:3011/chenyongjia-file/FileManagement/file/uploadFile
	 * @param file
	 * @return
	 * @author WangAnLing
	 */
	@PreAuthorize(value="hasAuthority('ROLE_Student') AND hasAuthority('ROLE_Teacher') AND hasAuthority('ROLE_ALL') ")
	@RequestMapping(value="/uploadFile",name="上传文件",method=RequestMethod.GET)
	public Object uploadFile(@RequestParam("fileName") MultipartFile file) {
		System.out.print("上传文件===" + "\n");
		// 判断文件是否为空
		if (file.isEmpty()) {
			return "上传文件不可为空";
		}
		// 获取文件名
		String fileName = file.getOriginalFilename();
		// System.out.print("上传的文件名为: "+fileName+"\n");
		fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
		System.out.print("（加个时间戳，尽量避免文件名称重复）保存的文件名为: " + fileName + "\n");
		// 加个时间戳，尽量避免文件名称重复
		String path = "E:/fileUpload/" + fileName;
		// String path = "E:/fileUpload/" + new
		// SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
		// 文件绝对路径
		System.out.print("保存文件绝对路径" + path + "\n");
		// 创建文件路径
		File dest = new File(path);
		// 判断文件是否已经存在
		if (dest.exists()) {
			return "文件已经存在";
		}
		// 判断文件父目录是否存在
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdir();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 上传文件
			file.transferTo(dest); // 保存文件
			System.out.print("保存文件路径" + path + "\n");
			url = "http://localhost:8080/" + fileName;
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			int jieguo = uploadFileService.insertFile(uuid, fileName, path, url, new Date());
			map.put("result", true);
			map.put("fileName", fileName);
			map.put("url", path);
			System.out.print("插入结果" + jieguo + "\n");
			System.out.print("保存的完整url====" + url + "\n");
		} catch (IOException e) {
			map.put("result", false);
		}
		return map;
	}

	/**
	 * 访问路径为：http://localhost:3011/chenyongjia-file/FileManagement/file/downloadFile
	 * @param request
	 * @param response
	 * @return
	 * @author WangAnLing
	 */
	@RequestMapping(value="/downloadFile",name="下载文件",method=RequestMethod.GET)
	public String downloadFile(@RequestParam("fileNames") String fileNames,@RequestParam("request") HttpServletRequest request,@RequestParam("response") HttpServletResponse response) {
		String fileName = request.getParameter(fileNames);
		// 设置文件名，根据业务需要替换成要下载的文件名
		if (fileName != null) {
			// 设置文件路径
			String realPath = "E://fileUpload//";
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
}
