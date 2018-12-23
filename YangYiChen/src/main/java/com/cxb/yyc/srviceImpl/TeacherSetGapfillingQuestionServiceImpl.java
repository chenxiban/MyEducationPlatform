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
	public List<Gapfilling> queryGapfilling(Integer chapterId) {
		return gapfillingQuestionRepository.queryGapfilling(chapterId);
	}
	/**
	 * 根据章节Id和课程Id查询填空题的数量
	 */
	@Override
	public int queryGapfillingNumber(Integer chapterId, Integer courseId) {
		return gapfillingQuestionRepository.queryGapfillingNumber(chapterId, courseId);
	}
	/**
	 * @Description: 根据章节Id查询对应章节的判断题数目
	 * @ClassName: selectCountByGapfillingChapterId.method
	 * @author yyc
	 * @Date 2018年12月22日 下午18:07
	 * @Email yangyichenshuai@163.com
	 * @param chapterId 章节Id
	 * @return
	 */
	@Override
	public int selectCountByGapfillingChapterId(Integer chapterId) {
		return gapfillingQuestionRepository.selectCountByGapfillingChapterId(chapterId);
	}

}
