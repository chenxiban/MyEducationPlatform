package com.cxb.yyc.srviceImpl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.yyc.entity.StudentTest;
import com.cxb.yyc.repository.StudentTestRepository;
import com.cxb.yyc.service.StudentTestService;
/**
 * 记录学生测试的次数
 * @author dell
 *
 */
@Service
public class StudentTestServiceImpl implements StudentTestService{

	@Autowired
	private StudentTestRepository studentTestRepository;

	/**
	 * 学生每测试一次就往学生测试表中存该学生已测试的次数
	 * @param studentTest
	 * @return
	 */
	@Override
	@Transactional
	public StudentTest insertStudentTestRecord(StudentTest studentTest) {
		return studentTestRepository.save(studentTest);
	}

	/**
	 * 向学生测试记录表中添加数据
	 * @param courseId
	 * @param chapterId
	 * @param endTime
	 * @param testScore
	 * @param createTime
	 * @return
	 */
	@Override
	@Transactional
	public int insertStudentTest(Integer courseId, Integer chapterId, String endTime, Integer testScore,Integer num) {
		return studentTestRepository.insertStudentTest(courseId, chapterId, endTime, testScore,num);
	}
	/**
	 * 根据课程Id和章节Id查询该学生已经测试的次数
	 * @param courseId
	 * @param chapterId
	 * @return
	 */
	@Override
	public int queryStudentTestNum(Integer courseId, Integer chapterId, Integer studentId) {
		return studentTestRepository.queryStudentTestNum(courseId, chapterId, studentId);
	}
	
	
}
