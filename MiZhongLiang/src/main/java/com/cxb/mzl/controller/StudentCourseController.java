package com.cxb.mzl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.mzl.service.StudentCourseService;

/**
*@author 作者 E-mail 谢立博 13837051752@163.com
*@version 创建时间:2018年12月21日下午2:18:06
*类说明    个人中心课程展示控制器
*/

@RestController
@RequestMapping(value = "/studentcourse", name = "个人中心课程展示")
public class StudentCourseController {
	@Autowired
	private StudentCourseService studentCourseService;
	/**
	 * http://locahost:3011/mizhongliang/MiZhongLiang/studentcourse/getStuCourse
	 * */
	@RequestMapping(value="/getStuCourse",method=RequestMethod. GET)
	public List <Integer> getStuCourse(Integer studentId){
		return getStuCourse(studentId);
	}
}
