package com.cxb.lhc.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.lhc.entity.StudentRecord;

/**
 * 
 * @Description: 学生进行选课操作的Service接口
 * @ClassName: StuSelectionCourseService
 * @author liu
 * @Date 2018年12月14日 下午16:58
 * @Email 1273822019@qq.com
 */
public interface StuSelectionCourseService {

	/**
	 * 点击立即参加
	 * 往学生选课表中添加一条数据
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	 @Transactional
     Integer saveStucourse(Integer courseId, Integer studentId);
	
	/**
	 * 学生在个人中心进行退课操作
	 * 
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	@Transactional
	Integer delStuCourseByStuCourseId(Integer courseId, Integer studentId);

	
	
	/**1111111111111111111111111111111111111111111111111111111111*/
	
	/**
     * 	向学生学习表中添加一条数据
     * @param unitCourseId
     * @param studentId
     * @return
     */
	Integer savestudentrecord(Integer studentId,Integer unitCourseId);
	

	/**
	 * 查询改学生是否有学习记录
	 * 
	 * @param unitCourseId
	 * @return
	 */
	Integer  SelStucourse(Integer unitCourseId,Integer studentId);
	
	/**
     * 查询改学生是否有学习记录,返回一条学习记录
     * @param courseId
     * @param unitCourseId
     * @return
     */
	double SelStucourseByID(Integer unitCourseId,Integer studentId);

	/**
	 * 学生学习过后，修改学生学习记录表
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	Integer UpStucourse(Integer studentState,Double videoExitTime,Long videoStudentingTime,Integer studentId,Integer unitCourseId);
	
}
