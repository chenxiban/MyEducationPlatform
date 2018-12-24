package com.cxb.zbq.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cxb.zbq.config.MultipartSupportConfig;



@FeignClient(value="chenyongjia-file",configuration = MultipartSupportConfig.class)
public interface UploadFeign {

	@RequestMapping("/file/uploadFile")
	public Object uploadFile(@RequestParam("fileName") MultipartFile file);//上传封面图

	@RequestMapping("/file/deleteFile")
	public Integer deleteFile(@RequestParam("fileIds")List<String> fileId);//根据id删除课程封面图信息
}
