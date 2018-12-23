package com.cxb.yyc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.yyc.entity.TfngAnswer;
/**
 * 教师设置答案
 * @author dell
 *
 */
public interface TeacherSetTfngAnswerRepository extends JpaRepository<TfngAnswer, Integer>{

	/**
	 * 根据答案主键删除答案
	 * @param tfngAnswerId
	 * @return
	 */
	@Query(value="DELETE FROM tfnganswertb WHERE tfnganswer_id=?1",nativeQuery=true)
	@Modifying
	int deleteTfngAnswer(Integer tfngAnswerId);
	
	@Query(value="UPDATE tfnganswertb SET tfnganswer_answer=:#{#tfngAnswer.tfnganswerAnswer} WHERE tfnganswer_id=:#{#tfngAnswer.tfnganswerId}",nativeQuery=true)
	@Modifying
	int updateTfngAnswer(@Param("tfngAnswer")TfngAnswer tfngAnswer);
	/**
	 * 根据判断问题查找正确答案
	 * @param question
	 * @return
	 */
	@Query(value="select tfnganswer_answer from tfnganswertb where tfnganswer_tfng_id in(\r\n" + 
			"select tfng_id from tfngtb where tfng_question=:question)",nativeQuery=true)
	String queryTfngAnswer(@Param("question")String question);
}
