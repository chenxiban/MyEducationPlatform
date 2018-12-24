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
	@Autowired
	private StuSelectionCourseService stuselectioncourseservice;
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
	public Object getCurrAndNoticeByCurrId(Integer courseId) {		
		return stuselectioncourseservice.getCurrAndNoticeByCurrId(courseId);
	}
	
	/**
	 * 根据课程id获取所有章节课时信息
	 * @param courseId
	 * @return
	 */
	@Override
	public Object getCoursewareByCurrId(Integer courseId) {
		// TODO Auto-generated method stub
		return stuselectioncourseservice.getCoursewareByCurrId(courseId);
	}
	
	/**
	 * 根据课程id获取所有课件信息
	 * @param courseId
	 * @return
	 */
	@Override
	public Object getChapterByCurrId(Integer courseId) {
		// TODO Auto-generated method stub
		return stuselectioncourseservice.getChapterByCurrId(courseId);
	};
	
	/**
	 * 获取所有课程信息及课程封面图(首页)
	 * @param courseId
	 * @return
	 */
	@Override
	public Object getCurrAndCoverMap(Integer courseId) {
		// TODO Auto-generated method stub
		return stuselectioncourseservice.getCurrAndCoverMap(courseId);
	};
	/**
	 * 学生在个人中心进行退课操作
	 * @param courseId
	 * @param studentId
	 * @return
	 */

	public Integer delStuCourseByStuCourseId(Integer courseId,Integer studentId){
		 return stuRepository.delStuCourseByStuCourseId(courseId, studentId);
	 }
	
	/**
	 * 查询改学生是否有学习记录
	 * @param courseId
	 * @return
	 */
	@Override
	public Integer SelStucourse(Integer courseId,Integer studentId) {
		// TODO Auto-generated method stub
		return stuRepository.SelStucourse(courseId, studentId);
	}
	/**
	 * 学生学习过后，修改学生学习记录表
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	@Override
	public Integer UpStucourse(Integer studentState, Double videoExitTime, Integer videoStudentingTime,
			Integer studentId, Integer unitCourseId) {
		// TODO Auto-generated method stub
		return stuRepository.UpStucourse(studentState, videoExitTime, videoStudentingTime, studentId, unitCourseId);
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
		return stuselectioncourseservice.getCourseByCourseId(courseId);
	}

}
