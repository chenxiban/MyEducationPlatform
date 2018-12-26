package com.cxb.zbq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.zbq.entity.CourseWare;
import com.cxb.zbq.service.ChapterService;
import com.cxb.zbq.service.CourseWareService;

@RestController
@RequestMapping("/courseWare")
@CrossOrigin
public class CourseWareController {
	@Autowired
	private CourseWareService cWareService;
	@Autowired
	private ChapterService chapterService;
	
	//http://localhost:3050/ZhangBingQian/courseWare/getClassHourByCurrId?currId=1
	@RequestMapping(value="getClassHourByCurrId",name="根据课程id获取课件信息")
	public Object getClassHourByCurrId(Integer currId) {
		return cWareService.findAllClassHourByCurrId(currId);
	}
	
	@RequestMapping(value="getClassHourById",name="根据课时id获取课件信息")
	public Object getClassHourById(Integer clazzId) {
		String c=chapterService.queryChapterIdBychapterName(clazzId);
		List<CourseWare> list=cWareService.findByClassHourId(clazzId);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setChapterName(c);
		}
		return list;
	}
	@RequestMapping(value="update",name="根据课件id,修改课件信息")
	public Object updateCourseWareId(String courseWareId,String coursewareDescription) {
		//System.out.println(courseWareId+coursewareDescription);
		return cWareService.updateCourseWare(courseWareId, coursewareDescription);
	}

}
