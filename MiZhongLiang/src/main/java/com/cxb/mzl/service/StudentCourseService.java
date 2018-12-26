package com.cxb.mzl.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
*@author 作者 E-mail 谢立博 13837051752@163.com
*@version 创建时间:2018年12月21日下午2:01:41
*类说明  个人中心课程展示
*/
@FeignClient("lihaichao") 
public interface StudentCourseService {	
	@RequestMapping(value="/LiHaiChao/stuSelectionCourse/getStuCourse",method=RequestMethod. GET)
	public List <Integer> getStuCourse(Integer studentId);

}
