package com.cxb.mzl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.mzl.entity.Clazz;
import com.cxb.mzl.entity.College;
import com.cxb.mzl.service.ClazzService;

/**
*@author 作者 E-mail 谢立博 13837051752@163.com
*@version 创建时间:2018年12月20日下午9:27:11
*类说明  班级院系控制器
*/
@RestController
@RequestMapping(value = "/class", name = "院系班级模块")
public class ClazzController {
	@Autowired
	private ClazzService clazzService;
	
	/**
	 * http://locahost:3011/mizhongliang/MiZhongLiang/class/getClassInfo
	 * */
	@RequestMapping("/getClassInfo") 
	public List<Clazz> getClassInfo(@RequestParam(value="userId") Integer userId){
		return clazzService.getClassInfo(userId);
	}
	/**
	 * http://locahost:3011/mizhongliang/MiZhongLiang/class/getCollegeInfo
	 * */
	@RequestMapping("/getCollegeInfo") 
	public List<College> getCollegeInfo(@RequestParam(value="userId") Integer userId){
		return clazzService.getCollegeInfo(userId);
	}
	/**
	 * http://locahost:3011/mizhongliang/MiZhongLiang/class/getCourseId
	 * */
	@RequestMapping("/getCourseId") 
	public List <Integer> getCourseId(){
		return clazzService.getCourseId();
	}
	/**
	 * http://locahost:3011/mizhongliang/MiZhongLiang/class/getPostId
	 * */
	@RequestMapping("/getPostId")
	public List <Integer> getPostId(){
		return clazzService.getPostId();
	}
	@RequestMapping("/getCollegeInfos")
	public List<College> getCollegeInfos(){
		return clazzService.getCollegeInfos();
	}
	


}
