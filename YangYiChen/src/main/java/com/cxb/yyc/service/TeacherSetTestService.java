package com.cxb.yyc.service;

import java.util.List;

import com.cxb.yyc.entity.TeacherCreateTest;
/**
 * 记录教师发起的测试题
 * @author dell
 *
 */
public interface TeacherSetTestService {
	
	
	/**
	 * 教师发起测试，向教师发起测试表中添加一条数据
	 * @param teacherCreateTest
	 * @return
	 */
	TeacherCreateTest insertTeacherCreateTest(TeacherCreateTest teacherCreateTest);
	/**
	 * 根据教师Id查询教师发起的测试
	 * @param tid
	 * @return
	 */
	List<TeacherCreateTest> queryTeacherCreateTest(Integer tid);
	/**
	 * 根据教师发起测试主键将发布状态未发布修改已发布状态 0-->1
	 * @param testId
	 * @return
	 */
	int updateTeacherCreateTestState(Integer testId);
	/**
	 * 根据教师发起测试主键将发布状态未发布修改已发布状态 1-->0
	 * @param testId
	 * @return
	 */
	int updateTeacherCreateTestStateForZero(Integer testId);

	/**
	 * 在main.html页面当中教师删除创建的测试题
	 * @param testId
	 * @return
	 */
	int deleteTest(Integer testId);

}
