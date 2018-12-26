package com.cxb.yyc.srviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.yyc.entity.Tfng;
import com.cxb.yyc.repository.TeacherSetTfngQuestionRepository;
import com.cxb.yyc.service.TeacherSetTfngQuestionService;

/**
 * 教师设置判断题实现类
 * 
 * @author dell
 *
 */
@Service
public class TeacherSetTfngQuestionServiceImpl implements TeacherSetTfngQuestionService {

	@Autowired
	private TeacherSetTfngQuestionRepository tfngQuestionRepository;

	/**
	 * 教师添加判断题
	 */
	@Override
	public Tfng insertTfng(Tfng tfng) {
		return tfngQuestionRepository.save(tfng);
	}

	/**
	 * 根据判断题主键删除判断题
	 */
	@Override
	@Transactional
	public int deleteTfng(Integer tfngId) {
		return tfngQuestionRepository.deleteTfng(tfngId);
	}

	/**
	 * 根据问题主键修改问题
	 */
	@Override
	@Transactional
	public int updateTfng(Tfng tfng) {
		return tfngQuestionRepository.updateTfng(tfng);
	}

	/**
	 * 根据章节Id和课程Id查询判断题问题
	 */
	@Override
	public List<Tfng> queryTfng(Integer chapterId) {
		return tfngQuestionRepository.queryTfng(chapterId);
	}

	/**
	 * 根据章节Id和课程Id查询判断题的数量
	 */
	@Override
	public int queryTfngNumber(Integer chapterId, Integer courseId) {
		return tfngQuestionRepository.queryTfngNumber(chapterId, courseId);
	}

	/**
	 * @Description: 根据章节Id查询对应章节的判断题数目
	 * @ClassName: selectCountByTfngChapterId.method
	 * @author yyc
	 * @Date 2018年12月22日 下午18:07
	 * @Email yangyichenshuai@163.com
	 * @param chapterId
	 * @return
	 */
	@Override
	public int selectCountByTfngChapterId(Integer chapterId) {
		return tfngQuestionRepository.selectCountByTfngChapterId(chapterId);
	}

	/**
	 * 根据章节Id和课程Id查询判断题问题
	 * @param chapterId
	 * @param courseId
	 * @return
	 */
	@Override
	public List<Tfng> queryTfng(Integer chapterId, Integer courseId) {
		// TODO Auto-generated method stub
		return null;
	}

}
