package com.cxb.yyc.service;
/**
 * 学生考试记录
 * @author dell
 *
 */

import java.util.List;

import com.cxb.yyc.entity.StudentTestRecord;

public interface StudentSetTestRecordService {
	
	/**
	 * 向学生记录表中添加数据
	 * @param studentTestRecord
	 * @return
	 */
	StudentTestRecord insertStudentTestRecord(StudentTestRecord studentTestRecord);
	/**
	 * 根据测试记录的外键（测试的主键）查询
	 * @param studentTestId
	 * @return
	 */
	List<StudentTestRecord> queryStudentTestRecord(Integer studentTestId);

}
