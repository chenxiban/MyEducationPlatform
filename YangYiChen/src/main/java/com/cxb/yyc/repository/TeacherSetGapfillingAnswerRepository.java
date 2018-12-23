package com.cxb.yyc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.yyc.entity.GapfillingAnswer;
/**
 * 教师设置填空题答案
 * @author dell
 *
 */
public interface TeacherSetGapfillingAnswerRepository extends JpaRepository<GapfillingAnswer, Integer>{

	/**
	 * 根据填空题答案主键删除答案
	 * @param gapfillingId
	 * @return
	 */
	@Query(value="DELETE FROM gapfillinganswertb WHERE gapfillinganswer_id=?1",nativeQuery=true)
	@Modifying
	int deleteGapfillingAnswer(Integer gapfillingAnswerId);
	/**
	 * 根据填空题主键修改填空题答案
	 * @param gapfillingAnswer
	 * @return
	 */
	@Query(value="update gapfillinganswertb set gapfillinganswer_answer=:#{#gapfillingAnswer.gapfillinganswerAnswer} where gapfillinganswer_gapfilling_id=:#{#gapfillingAnswer.gapfillinganswerId}",nativeQuery=true)
	@Modifying
	int updateGapfillingAnswer(@Param("gapfillingAnswer")GapfillingAnswer gapfillingAnswer);
	
	/**
	 * 根据填空题问题查找正确答案
	 * @param question
	 * @return
	 */
	@Query(value="select gapfillinganswer_answer from gapfillinganswertb where gapfillinganswer_gapfilling_id in(\r\n" + 
			"select gapfilling_id from gapfillingtb where gapfilling_question=:question)",nativeQuery=true)
	String queryGapfillingAnswer(@Param("question") String question);
}
