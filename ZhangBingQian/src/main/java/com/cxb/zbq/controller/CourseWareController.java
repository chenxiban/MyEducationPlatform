package com.cxb.zbq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.zbq.service.CourseWareService;

@RestController
@RequestMapping("/courseWare")
public class CourseWareController {
	@Autowired
	private CourseWareService cWareService;
	
	//http://localhost:3050/ZhangBingQian/courseWare/getClassHourByCurrId?currId=1
	@RequestMapping(value="getClassHourByCurrId",name="根据课程id获取课件信息")
	public Object getClassHourByCurrId(Integer currId) {
		return cWareService.findAllClassHourByCurrId(currId);
	}
	
	@RequestMapping(value="getClassHourById",name="根据课时id获取课件信息")
	public Object getClassHourById(Integer clazzId) {
		return cWareService.findByClassHourId(clazzId);
	}

}
