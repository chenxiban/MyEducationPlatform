package com.cxb.lhc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.lhc.repository.StuSelectionCourseReository;
import com.cxb.lhc.service.HomePageClickCourseService;

@Service
public class HomePageClickCourseServiceImpl implements HomePageClickCourseService{
	@Autowired
	private HomePageClickCourseService homepageclickcourseservice;
	/**
	 **  获取首页点击课程服务
	 * @param courseId
	 * @return 
	 */
	@Override
	public Object getHomePageClickCourseId() {
		return homepageclickcourseservice.getHomePageClickCourseId();
	}
	
	/**调用小米组的方法
	 * 根据课程id查询出该门课的老师信息
	* @param courseId
	* @return
	*/
	public Object queryTeacherByCourseId(Integer teacherId) {
		return homepageclickcourseservice.queryTeacherByCourseId(teacherId);
	};
	
}
