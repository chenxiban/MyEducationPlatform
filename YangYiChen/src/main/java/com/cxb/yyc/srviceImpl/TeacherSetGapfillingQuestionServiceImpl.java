package com.cxb.yyc.srviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.yyc.entity.Gapfilling;
import com.cxb.yyc.repository.TeacherSetGapfillingQuestionRepository;
import com.cxb.yyc.service.TeacherSetGapfillingQuestionService;
/**
 * 教师设置填空题实现接口
 * @author dell
 *
 */
@Service
public class TeacherSetGapfillingQuestionServiceImpl implements TeacherSetGapfillingQuestionService{

	@Autowired
	private TeacherSetGapfillingQuestionRepository gapfillingQuestionRepository;
	/**
	 * 添加填空题
	 */
	@Override
	public Gapfilling insertGapfilling(Gapfilling gapfilling) {
		return gapfillingQuestionRepository.save(gapfilling);
	}
	/**
	 * 删除填空题
	 */
	@Override
	public int deleteGapfilling(Integer gapfillingId) {
		return gapfillingQuestionRepository.deleteGapfilling(gapfillingId);
	}
	/**
	 * 根据主键修改填空题
	 */
	@Override
	@Transactional
	public int updateGapfillingQuestion(Gapfilling gapfilling) {
		return gapfillingQuestionRepository.updateGapfillingQuestion(gapfilling);
	}
	/**
	 * 通过章节Id和课程Id查询填空题问题
	 */
	@Override
	public List<Gapfilling> queryGapfilling(Integer chapterId, Integer courseId) {
		return gapfillingQuestionRepository.queryGapfilling(chapterId, courseId);
	}

}
