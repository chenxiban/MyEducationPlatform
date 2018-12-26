package com.cxb.zbq.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cxb.zbq.entity.CoverMap;
import com.cxb.zbq.feign.UploadFeign;
import com.cxb.zbq.service.CoverMapService;
import com.cxb.zbq.utils.Result;

@RestController
@RequestMapping("/coverMap")
public class CoverMapController {
	@Autowired
	private CoverMapService coverMapService;
	@Autowired
	private UploadFeign uploadFeign;

	@RequestMapping(value = "uploadCoverMap", name = "上传课程封面图")
	public Object uploadCoverMap(@RequestParam("fileName") MultipartFile file, Integer curriculumId) {
		Object object=uploadFeign.uploadFile(file);
		if (object==null) {
			return new Result("系统错误!!", 0);
		}
		Map<String, Object> map = (Map<String, Object>) object;
		String id = (String) map.get("fileId");
		String path = (String) map.get("url");
		CoverMap cMap = new CoverMap(id, path, curriculumId);
		if (coverMapService.insertCoverMap(cMap) != null)
			return new Result("课程封面图上传成功", 1);
		return new Result("课程封面图上传失败", 0);
	}
	

}
