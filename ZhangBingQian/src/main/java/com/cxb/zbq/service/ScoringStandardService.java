package com.cxb.zbq.service;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.zbq.entity.ScoringStandard;

public interface ScoringStandardService {
	
	@Modifying@Transactional
	ScoringStandard insertScStan(ScoringStandard scoringStandard);//添加评分标准
	
	int updateScStan(ScoringStandard scoringStandard);//修改评分标准
	
	int deleteScStan(Integer currId);//删除评分标准
	
	ScoringStandard findByScoringStandardId(Integer scstanId);//根据评分id获取对应评分标准对象
	
	ScoringStandard findByCurriculumId(Integer currId);//根据课程id获取对应评分标准对象
	
List<ScoringStandard> queryScoringStandardBycurriculumId(@Param("curriculumId")List<Integer> curriculumId);//查询出一个老师下所有课程的评分信息
    
	int updateScStan(Integer scoringStandardId,Integer proportion);    //根据id修改一条信息
	
	ScoringStandard insertScoringStandard(ScoringStandard s);

}
