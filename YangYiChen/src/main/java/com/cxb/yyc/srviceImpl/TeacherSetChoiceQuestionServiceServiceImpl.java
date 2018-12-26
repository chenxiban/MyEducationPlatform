package com.cxb.yyc.srviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.yyc.entity.ChoiceQuestion;
import com.cxb.yyc.entity.QuestionOption;
import com.cxb.yyc.repository.TeacherSetChoiceQuestionRepository;
import com.cxb.yyc.service.TeacherSetChoiceQuestionService;
import com.cxb.yyc.utils.JpaObjectsToEntity;
/**
 * 教师录入测试题==》选择题
 * @author dell
 *
 */
@Service
public class TeacherSetChoiceQuestionServiceServiceImpl implements TeacherSetChoiceQuestionService{

	@Autowired
	private TeacherSetChoiceQuestionRepository choiceRepository;
	
	/**
	 * 教师添加一道选择题
	 */
	@Override
	public ChoiceQuestion insertChoiceQuestion(ChoiceQuestion choiceQuestion) {
		return choiceRepository.save(choiceQuestion);
	}

	/**
	 * 根据问题主键删除问题
	 */
	@Override
	@Transactional
	public int deleteChoiceQuestion(Integer questionId) {
		return choiceRepository.deleteChoiceQuestion(questionId);
	}

	/**
	 * 根据问题主键修改问题
	 * @param choicequestion_id
	 * @param choicequestion_imgurl 问题图片
	 * @param choicequestion_question 问题
	 * @param choicequestion_score每道题分数
	 * @param choicequestiontb_issingleselection 问题类型
	 * @return
	 */
	@Override
	@Transactional
	public int updateChoiceQuestion(Integer choicequestion_id, String choicequestion_imgurl,
			String choicequestion_question, Integer choicequestion_score, Integer choicequestiontb_issingleselection) {
		return choiceRepository.updateChoiceQuestion(choicequestion_id, choicequestion_imgurl, choicequestion_question, choicequestion_score, choicequestiontb_issingleselection);
		
	}

	@Override
	public List<QuestionOption> queryChoiceQuestion(Integer chapterId) {
		List<QuestionOption> list=choiceRepository.queryChoiceQuestion(chapterId);
		//List<QuestionOption> list=(List<QuestionOption>) JpaObjectsToEntity.jpaResultToObjectList(objList, QuestionOption.class);
		
		return list;
	}

	/**
	 * 根据章节Id和课程Id查询选择题问题
	 */
	@Override
	public List<ChoiceQuestion> queryChoiceQuestions(Integer chapterId, Integer courseId) {
		return choiceRepository.queryChoiceQuestions(chapterId, courseId);
	}

	/**
	 * 根据章节Id和课程Id查询选择题的数量
	 */
	@Override
	public int queryChoiceQuestionNumber(Integer chapterId, Integer courseId) {
		return choiceRepository.queryChoiceQuestionNumber(chapterId, courseId);
	}

	/**
	 * @Description: 根据章节Id查询对应章节的选择题数目
	 * @ClassName: selectCountByChoiceChapterId.method
	 * @author yyc
	 * @Date 2018年12月22日 下午18:07
	 * @Email yangyichenshuai@163.com
	 * @param chapterId
	 * @return
	 */
	@Override
	public int selectCountByChoiceChapterId(Integer chapterId) {
		return choiceRepository.selectCountByChoiceChapterId(chapterId);
	}

	/**
	 * 根据章节Id和课程Id查询问题及选项
	 * 使用自定义工具类转换时原生SQL结果集与实体类只需要字段顺序一致即可.不需要字段名称一致
	 * @param chapterId
	 * @param courseId
	 * @return
	 */
	public List<QuestionOption> queryChoiceQuestion(Integer chapterId, Integer courseId) {
		return choiceRepository.queryChoiceQuestion(chapterId, courseId);
	}

	

	
	
	
	
	

}
