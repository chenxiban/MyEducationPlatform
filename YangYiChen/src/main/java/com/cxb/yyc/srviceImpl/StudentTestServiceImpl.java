package com.cxb.yyc.srviceImpl;

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
	public StudentTest insertStudentTestRecord(StudentTest studentTest) {
		return studentTestRepository.save(studentTest);
	}
	
	
}
