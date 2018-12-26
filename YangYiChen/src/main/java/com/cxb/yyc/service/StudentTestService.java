package com.cxb.yyc.service;

import java.util.Date;

import com.cxb.yyc.entity.StudentTest;

/**
 * 记录学生测试的次数
 * @author dell
 *
 */
public interface StudentTestService {
	
	/**
	 * 学生每测试一次就往学生测试表中存该学生已测试的次数
	 * @param studentTest
	 * @return
	 */
	StudentTest insertStudentTestRecord(StudentTest studentTest);
	/**
	 * 向学生测试记录表中添加数据
	 * @param courseId
	 * @param chapterId
	 * @param endTime
	 * @param testScore
	 * @param createTime
	 * @return
	 */
	int insertStudentTest(Integer courseId,Integer chapterId,String endTime,Integer testScore,Integer num);

	/**
	 * 根据课程Id和章节Id查询该学生已经测试的次数
	 * @param courseId
	 * @param chapterId
	 * @return
	 */
	int queryStudentTestNum(Integer courseId,Integer chapterId,Integer studentId);

	

}
