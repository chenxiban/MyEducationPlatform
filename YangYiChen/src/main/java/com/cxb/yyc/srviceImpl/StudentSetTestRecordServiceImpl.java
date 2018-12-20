package com.cxb.yyc.srviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.yyc.entity.StudentTestRecord;
import com.cxb.yyc.repository.StudentSetTestRecordRepostoty;
import com.cxb.yyc.service.StudentSetTestRecordService;
/**
 * 记录学生测试记录
 * @author dell
 *
 */
@Service
public class StudentSetTestRecordServiceImpl implements StudentSetTestRecordService{

	@Autowired 
	private StudentSetTestRecordRepostoty studentTestRecordRepostory;
	/**
	 * 向学生记录表中添加学生做的测试题
	 */
	@Override
	public StudentTestRecord insertStudentTestRecord(StudentTestRecord studentTestRecord) {
		return studentTestRecordRepostory.save(studentTestRecord);
	}
	/**
	 * 根据测试记录的外键（测试的主键）查询
	 * @param studentTestId
	 * @return
	 */
	@Override
	public List<StudentTestRecord> queryStudentTestRecord(Integer studentTestId) {
		return studentTestRecordRepostory.queryStudentTestRecord(studentTestId);
	}

}
