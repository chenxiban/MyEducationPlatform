package com.cxb.yyc.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.cxb.yyc.entity.ChoiceQuestionAnswer;
/**
 * 教师录入测试题答案==》选择题正确答案
 * @author dell
 *
 */
public interface TeacherSetChoiceQuestionAnswerService{

	/**
	 * 教师设置问题的正确答案
	 * @param choiceQuestionAnswer
	 * @return
	 */
	ChoiceQuestionAnswer insertChoiceQuestionAnswer(ChoiceQuestionAnswer choiceQuestionAnswer);
	/**
	 * 根据问题主键，答案表中的外键删除
	 * @param questionId
	 */
	int deleteChoiceQuestionAnswer(Integer questionId);
	/**
	 * 根据答案主键修改问题的正确答案
	 * @param answerId
	 * @param choicequestionanswer_answer
	 * @return
	 */
	int updateChoiceQuestionAnswer(Integer answerId,String choicequestionanswer_answer);
	
	/**
	 * 通过选择题问题查答案
	 * @param question
	 * @return
	 */
	List<String> queryChoiceQuestionAnswer(String question);

}
