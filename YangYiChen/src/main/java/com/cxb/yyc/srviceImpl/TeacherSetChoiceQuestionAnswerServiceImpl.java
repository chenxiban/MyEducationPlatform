package com.cxb.yyc.srviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.yyc.entity.ChoiceQuestionAnswer;
import com.cxb.yyc.repository.TeacherSetChoiceQuestionAnswerRepository;
import com.cxb.yyc.service.TeacherSetChoiceQuestionAnswerService;
/**
 * 教师录入测试题答案==》选择题正确答案
 * @author dell
 *
 */
@Service
public class TeacherSetChoiceQuestionAnswerServiceImpl implements TeacherSetChoiceQuestionAnswerService{

	@Autowired
	private TeacherSetChoiceQuestionAnswerRepository questionAnswerRepository;
	/**
	 * 教师设置问题的正确答案实现类
	 * @param choiceQuestionAnswer
	 * @return
	 */
	@Override
	public ChoiceQuestionAnswer insertChoiceQuestionAnswer(ChoiceQuestionAnswer choiceQuestionAnswer) {
		return questionAnswerRepository.save(choiceQuestionAnswer);
	}
	/**
	 * 根据外键删除
	 */
	@Override
	@Transactional
	public int deleteChoiceQuestionAnswer(Integer questionId) {
		return questionAnswerRepository.deleteChoiceQuestionAnswer(questionId);
	}
	/**
	 * 根据答案主键修改问题的正确答案
	 */
	@Override
	@Transactional
	public int updateChoiceQuestionAnswer(Integer answerId, String choicequestionanswer_answer) {
		return questionAnswerRepository.updateChoiceQuestionAnswer(answerId, choicequestionanswer_answer);
	}
	@Override
	public List<String> queryChoiceQuestionAnswer(String question) {
		return queryChoiceQuestionAnswer(question);
	}

}
