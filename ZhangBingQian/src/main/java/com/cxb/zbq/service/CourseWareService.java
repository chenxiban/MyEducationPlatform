package com.cxb.zbq.service;

import java.util.List;

import com.cxb.zbq.entity.CourseWare;

public interface CourseWareService {
	List<CourseWare> findAllClassHourByCurrId(Integer currId);//根据课程id获取所有课件信息
	
	List<CourseWare> findByClassHourId(Integer classHourId);//根据课时id获取所有课件信息
	
	 int deleteCourseWare(Integer cId);//根据课件id删除课件信息
	 
	 int deleteCourseWareByCurrId(Integer classHourId);//根据课时id删除课件
}
