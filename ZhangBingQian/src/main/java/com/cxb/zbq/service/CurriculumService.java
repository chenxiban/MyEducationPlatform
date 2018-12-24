package com.cxb.zbq.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.zbq.entity.Curriculum;
import com.cxb.zbq.entityquery.CurriculumQuery;

public interface CurriculumService {
	//Page<Curriculum> queryCurriculumByPage(CurriculumQuery currQuery,Pageable pageable);//带条件的分页检索
	
	List<Curriculum> getCurriculumByPage(CurriculumQuery currQuery);//多条件检索
	
	int updateCurriculum(Curriculum curriculum);// 修改课程信息
	
	@Transactional@Modifying
	Curriculum insertCurriculum(Curriculum curriculum);// 添加课程信息

	int deleteCurriculum(Integer curriculumId);// 删除课程信息

	Curriculum findByCurriculumName(String curriculumName);// 根据课程名称查询该课程

	Curriculum findBycurriculumId(Integer curriculumId);// 根据课程id获取对应课程
	
	int updateSubscriptionNum(Integer currId);//添加订阅人数+1
	
	int delSubscriptionNum(Integer currId);//课程订阅人数-1
	
	int updateIsReleaseToTrue(Integer currId,Date startTime,Date endTime);//发布课程
	
	int updateIsReleaseToFalse(Integer currId);//取消发布课程
	
	List<Curriculum> getAllCurr();//获取所有课程信息
	
	 List<Integer> getCurrIdBySubscriptionNum();//根据订阅人数获取前12条课程id
	 
	 String getCurrNameByCurrId(Integer currId);//根据课程id获取课程名称

}
