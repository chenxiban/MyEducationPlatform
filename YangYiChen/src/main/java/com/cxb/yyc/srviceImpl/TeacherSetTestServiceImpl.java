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

	/**
	 * @Description: 根据章节Id查询对应章节的判断题数目
	 * @ClassName: updateTfngNumByChapterId.method
	 * @author yyc
	 * @Date 2018年12月22日 下午18:07
	 * @Email yangyichenshuai@163.com
	 * @param num 数量
	 * @param chapterId 章节Id
	 * @return
	 */
	@Override
	@Transactional
	public int updateTfngNumByChapterId(Integer num, Integer chapterId) {
		return testRepository.updateTfngNumByChapterId(num, chapterId);
	}

	/**
	 * @Description: 根据章节Id查询对应章节的判断题数目
	 * @ClassName: updateGapfillingNumByChapterId.method
	 * @author yyc
	 * @Date 2018年12月22日 下午18:07
	 * @Email yangyichenshuai@163.com
	 * @param num 数量
	 * @param chapterId 章节Id
	 * @return
	 */
	@Override
	@Transactional
	public int updateGapfillingNumByChapterId(Integer num, Integer chapterId) {
		return testRepository.updateGapfillingNumByChapterId(num, chapterId);
	}

	/**
	 * @Description: 根据章节Id修改对应章节的判断题数目
	 * @ClassName: updateChoiceNumByChapterId.method
	 * @author yyc
	 * @Date 2018年12月22日 下午18:07
	 * @Email yangyichenshuai@163.com
	 * @param num 数量
	 * @param chapterId 章节Id
	 * @return
	 */
	@Override
	@Transactional
	public int updateChoiceNumByChapterId(Integer num, Integer chapterId) {
		return testRepository.updateChoiceNumByChapterId(num, chapterId);
	}

	/**
	 * @Description: 根据测试Id查询
	 * @ClassName: selectByTestId.method
	 * @author yyc
	 * @Date 2018年12月22日 下午18:07
	 * @Email yangyichenshuai@163.com
	 * @param testId 数量
	 * @return
	 */
	@Override
	public int selectByTestIdForChapterId(Integer testId) {
		return testRepository.selectByTestIdForChapterId(testId);
	}

}
