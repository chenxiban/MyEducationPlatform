package com.cxb.lhc.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thoughtworks.xstream.mapper.Mapper.Null;


@FeignClient(value = "zhangbingqian/ZhangBingQian")
public interface StuSelectionCourseClient {
	/**
	 * 获取首页点击课程服务
	 * 
	 * 根据课程ID获取课程信息
	 * @param courseId
	 * @return
	 */		
	@RequestMapping(value="/Curriculum/getCurriculumById",method=RequestMethod.GET)
	Object getCourseByCourseId(Integer courseId);
	/**在选择课程后
	 * 根据课程id调用张冰倩组方法修改课程订阅人数+1
	 * @param courseId
	 * @return
	 */
	@RequestMapping("/curriculum/addSubscriptionNum")
	Object updCourseStudentNum(Integer courseId);
	/**在取消课程后
	 * 根据课程id调用张冰倩组方法修改课程订阅人数-1
	 * @param courseId
	 * @return
	 */
	@RequestMapping("/curriculum/delSubscriptionNum")
	Object updExitCourseStudentNum(Integer courseId);
	
	/**
	 * liulili上下不一致
	 * 
	 */
	
	/**
	 * 根据课程id获取课程对应信息
	 * 
	 * @param courseId
	 * @return
	 */
	@RequestMapping(value="/curriculum/getCurrAndNoticeByCurrId",method=RequestMethod.GET)
	Object getCurrAndNoticeByCurrId(@RequestParam("curriculumId")Integer curriculumId);

	/**
	 * 根据课程id获取所有章节课时信息
	 * 
	 * @param courseId
	 * @return
	 */
	@RequestMapping("/courseware/getCoursewareByCurrId")
	Object getCoursewareByCurrId(Integer courseId);

	/**
	 * 根据课程id获取所有课件信息
	 * 
	 * @param courseId
	 * @return
	 **/		  
	@RequestMapping("/chapter/queryId")
	Object queryId(@RequestParam("curriculumId")Integer curriculumId,String name);

	/**
	 * 获取所有课程信息及课程封面图(首页)
	 * 
	 * @param courseId
	 * @return
	 */
	@RequestMapping("/curriculum/getCurrAndCoverMap")
	Object getCurrAndCoverMap(Integer courseId);
	
	
	

}
