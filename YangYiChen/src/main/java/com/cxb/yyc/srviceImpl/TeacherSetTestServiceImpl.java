package com.cxb.yyc.srviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.yyc.entity.TeacherCreateTest;
import com.cxb.yyc.repository.TeacherSetTestRepository;
import com.cxb.yyc.service.TeacherSetTestService;
/**
 * 教师发起测试  实现类
 * @author dell
 *
 */
@Service
public class TeacherSetTestServiceImpl implements TeacherSetTestService{

	@Autowired
	private TeacherSetTestRepository testRepository;

	/**
	 * 记录教师发起测试
	 */
	@Override
	public TeacherCreateTest insertTeacherCreateTest(TeacherCreateTest teacherCreateTest) {
		return testRepository.save(teacherCreateTest);
	}

	/**
	 * 根据教师Id查询教师发起的测试
	 */
	@Override
	public List<TeacherCreateTest> queryTeacherCreateTest(Integer tid) {
		return testRepository.queryTeacherCreateTest(tid);
	}

	/**
	 * 根据教师发起测试主键将发布状态未发布修改已发布状态 0-->1
	 */
	@Override
	@Transactional
	public int updateTeacherCreateTestState(Integer testId) {
		return testRepository.updateTeacherCreateTestState(testId);
	}
	
	/**
	 * 根据教师发起测试主键将发布状态未发布修改已发布状态 0-->1
	 */
	@Override
	@Transactional
	public int updateTeacherCreateTestStateForZero(Integer testId) {
		return testRepository.updateTeacherCreateTestStateForZero(testId);
	}


	/**
	 * 在main.html页面当中教师删除创建的测试题
	 * @param testId
	 * @return
	 */
	@Override
	@Transactional 
	public int deleteTest(Integer testId) {
		return testRepository.deleteTest(testId);
	}

}
