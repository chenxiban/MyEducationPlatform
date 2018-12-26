package com.cxb.lhc.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="mizhongliang")
public interface StuCourseCommentClient {
	
	

	/**
	 * 调用小米组的方法 
	 * 根据老师id查询出该门课的老师信息
	 * @param teacherId
	 * @return
	 * Object queryTeacherByTeacherId(Integer teacherId);
	 */
	@RequestMapping("/usersdetails/queryTeacherByTeacherId")
	Object queryTeacherByTeacherId(@RequestParam Integer teacherId);

}
