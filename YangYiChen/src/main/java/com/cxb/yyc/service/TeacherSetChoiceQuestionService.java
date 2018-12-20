package com.cxb.yyc.service;


import java.util.List;

import com.cxb.yyc.entity.ChoiceQuestion;
import com.cxb.yyc.entity.QuestionOption;
/**
 * 教师录入测试题==》选择题
 * @author dell
 *
 */
public interface TeacherSetChoiceQuestionService {
	
	/**
	 * 教师添加一道选择题
	 * @param choiceQuestion
	 * @return
	 */
	ChoiceQuestion insertChoiceQuestion(ChoiceQuestion choiceQuestion);

	/**
	 * 根据问题主键删除问题
	 * @param questionId
	 */
	int deleteChoiceQuestion(Integer questionId);
	/**
	 * 根据问题主键修改问题
	 * @param choicequestion_id
	 * @param choicequestion_imgurl 问题图片
	 * @param choicequestion_question 问题
	 * @param choicequestion_score每道题分数
	 * @param choicequestiontb_issingleselection 问题类型
	 * @return
	 */
	int updateChoiceQuestion(Integer choicequestion_id,String choicequestion_imgurl,String choicequestion_question,Integer choicequestion_score,Integer choicequestiontb_issingleselection);
	/**
	 * 查询问题和选项，需要根据章节id和课程id
	 * @param chapterId
	 * @param courseId
	 * @return
	 */
	public List<QuestionOption> queryChoiceQuestion(Integer chapterId,Integer courseId);
	/**
	 * 根据章节Id和课程Id查询选择题问题
	 * @param chapterId
	 * @param courseId
	 * @return
	 */
	List<ChoiceQuestion> queryChoiceQuestions(Integer chapterId,Integer courseId);
	

}
