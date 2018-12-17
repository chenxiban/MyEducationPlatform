package com.cxb.lhc.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cxb.lhc.entity.StuSelectionCourse;
import com.cxb.lhc.repository.StuSelectionCourseReository;
import com.cxb.lhc.service.StuSelectionCourseService;


/**
 * 
 * @Description:   学生进行选课操作的service实现类
 * @ClassName:     StuSelectionCourseServiceImpl
 * @author         liu
 * @Date           2018年12月14日 下午17:15
 * @Email          1273822019@qq.com
 */
@Service
public class StuSelectionCourseServiceImpl implements StuSelectionCourseService{

	@Autowired
	private StuSelectionCourseReository stuRepository;
	/**
	 * 点击立即参加
	 * 往学生选课表中添加一条数据
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	@Override
	public Integer saveStucourse(Integer courseId, Integer studentId) {		
		return stuRepository.saveStucourse(courseId, studentId);
	}
	/**
	 * 
	 * 获取首页点击课程服务
	 * 根据课程ID获取课程信息
	 * @param courseId
	 * @return
	 */	
	@Override
	public Object getCourseByCourseId(Integer courseId) {		
		return stuRepository.getCourseByCourseId(courseId);
	}
	
	/**
	 * 学生在个人中心进行退课操作
	 * @param courseId
	 * @param studentId
	 * @return
	 */

	public Integer delStuCourseByStuCourseId(Integer courseId,Integer studentId){
		 return stuRepository.delStuCourseByStuCourseId(courseId, studentId);
	 };

}
