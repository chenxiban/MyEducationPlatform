package com.cxb.lhc.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.lhc.service.HomePageClickCourseService;

@RestController
@RequestMapping("/HomePageClickCourse")
public class HomePageClickCourseController {
	@Autowired
	private HomePageClickCourseService homepageclickcourseservice;
	/**
	 **  获取首页点击课程服务
	 * @param courseId
	 * @return 
	 */
	//http://localhost:3011/LiHaiChao/stuSelectionCourse/getCourseByCourseId
		@RequestMapping(value="/getHomePageClickCourseId",method=RequestMethod.GET)
		Object getHomePageClickCourseId() {
			return homepageclickcourseservice.getHomePageClickCourseId();
		}
		
		
		/**
		 * 调用小米组的方法 
		 * 根据老师id查询出该门课的老师信息
		 * @param courseId
		 * @return
		 */
		// http://localhost:3011/lihaichao/LiHaiChao/stuCourseComment/queryTeacherByCourseId
		@RequestMapping("/queryTeacherByCourseId")
		Object queryTeacherByCourseId(Integer teacherId) {
			return homepageclickcourseservice.queryTeacherByCourseId(teacherId);
		}
	

}
