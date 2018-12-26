package com.cxb.zbq.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.zbq.entity.ScoringStandard;

public interface ScoringStandardRepository extends JpaRepository<ScoringStandard, Integer> {

	@Query(value = "UPDATE scoring_standard_tb ss SET ss.proportion=:#{#s.proportion},ss.update_count=ss.update_count+1 WHERE ss.curriculum_id=:#{#s.curriculumId} AND ss.update_count=0", nativeQuery = true)
	@Transactional
	@Modifying
	int updateScStan(@Param("s")ScoringStandard scoringStandard);// 修改评分标准
	
	@Query(value = "DELETE FROM scoring_standard_tb WHERE curriculum_id=?1", nativeQuery = true)
	@Transactional
	@Modifying
	int deleteScStan(Integer currId);// 根据课程id删除评分标准
	
	ScoringStandard findByScoringStandardId(Integer scstanId);//根据评分id获取对应评分标准对象
	
	ScoringStandard findByCurriculumId(Integer currId);//根据课程id获取对应评分标准对象
	
	//-------------刘宇超写的------------------------------------
		//查询出一个老师下所有课程的评分信息
		@Query(value="select s from ScoringStandard s where s.curriculumId in(:curriculumId)")
		List<ScoringStandard> queryScoringStandardBycurriculumId(@Param("curriculumId")List<Integer> curriculumId);
	    //根据id修改一条信息
		@Query(value = "UPDATE ScoringStandard s set s.proportion=?2,s.updateCount=1 where s.scoringStandardId=?1")
		@Transactional
		@Modifying
		int updateScStan(Integer scoringStandardId,Integer proportion);

}
