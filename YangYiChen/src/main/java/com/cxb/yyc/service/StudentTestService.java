package com.cxb.yyc.service;

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


}
