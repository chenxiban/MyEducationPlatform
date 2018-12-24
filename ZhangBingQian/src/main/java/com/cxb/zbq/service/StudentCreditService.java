package com.cxb.zbq.service;

import java.util.List;

import com.cxb.zbq.entity.StudentCredit;
import com.cxb.zbq.entityquery.StudentCreditQuery;

public interface StudentCreditService {
	
	List<StudentCredit> getStudentCredits(StudentCreditQuery sQuery);//多条件检索学分信息
	
	int insertStudentCredit(Double credit, Integer currId, Integer stuId);// 添加学生学分信息

	StudentCredit findByCurriculumIdAndStudentId(Integer curriculumId, Integer studentId);// 根据课程id和学生id查询对应学分对象

	double getSumCredit(Integer stuId);// 获取该学生总学分

	int updateStudentCredit(Double credit, Integer currId, Integer stuId);// 修改学生学分信息
	
	List<StudentCredit> findByStudentId(Integer studentId);//根据学生id获取学分对象集合
}
