package com.cxb.yyc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cxb.yyc.entity.ChoiceQuestionAnswer;
/**
 * 教师录入测试题答案==》选择题正确答案
 * @author dell
 *
 */
public interface TeacherSetChoiceQuestionAnswerRepository extends JpaRepository<ChoiceQuestionAnswer, Integer>{
	
	/**
	 * 根据选择题答案主键删除答案
	 * @param answerId
	 * @return
	 */
	@Query(value="DELETE FROM choicequestionanswertb WHERE choicequestionanswer_choicequestion_id=?1",nativeQuery=true)
	@Modifying
	int deleteChoiceQuestionAnswer(Integer questionId);
	
	/**
	 * 根据问题正确答案Id修改问题的正确答案
	 * @param answerId
	 * @param choicequestionanswer_answer
	 * @return
	 */
	@Query(value="UPDATE choicequestionanswertb SET choicequestionanswer_answer=?2 WHERE choicequestionanswer_id=?1",nativeQuery=true)
	@Modifying
	int updateChoiceQuestionAnswer(Integer answerId,String choicequestionanswer_answer);
	
	
}
