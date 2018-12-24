package com.cxb.lhc.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cxb.lhc.impl.HomePageClickCourseServiceImpl;

@FeignClient(value="mizhongliang",fallback=HomePageClickCourseServiceImpl.class)
public interface HomePageClickCourseService {
	
	/**
	 * 获取首页点击课程服务
	 * @param courseId
	 * @return
	 */
	@RequestMapping("/HomePageClick/getHomePageClickCourseId")
	Object getHomePageClickCourseId();
	
	
	/**调用小米组的方法
  	* 根据课程id查询出该门课的老师信息
  	* @param courseId
  	* @return???
  	*/ 
 @RequestMapping("/")
 Object queryTeacherByCourseId(Integer teacherId);
	
	
	

}
