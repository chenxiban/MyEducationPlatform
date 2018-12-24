package com.cxb.zbq.dao;

import java.util.Date;
import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.zbq.entity.Chapter;
import com.cxb.zbq.entity.Curriculum;
import com.cxb.zbq.entityquery.CurriculumQuery;

/**
 * 
 * @author zhangbignqian 课程方法接口
 */
public interface CurriculumRepository extends JpaRepository<Curriculum, Integer>,JpaSpecificationExecutor<Curriculum> {
	
	// 修改课程信息
	@Query(value = "UPDATE curriculum_tb cu SET cu.course_introduction=:#{#c.courseIntroduction},cu.curriculum_category_id=:#{#c.curriculumCategoryId},cu.curriculum_name=:#{#c.curriculumName},cu.start_time=:#{#c.startTime},cu.end_time=:#{#c.endTime},cu.whether_to_issue=:#{#c.whetherToIssue}  WHERE cu.curriculum_id=:#{#c.curriculumId}", nativeQuery = true)
	@Modifying
	@Transactional
	int updateCurriculum(@Param("c") Curriculum curriculum);

	// 删除课程信息
	@Query(value = "DELETE FROM curriculum_tb WHERE curriculum_id=?1", nativeQuery = true)
	@Modifying
	@Transactional
	int deleteCurriculum(Integer curriculumId);

	Curriculum findByCurriculumName(String curriculumName);// 根据课程名称查询该课程

	Curriculum findBycurriculumId(Integer curriculumId);// 根据课程id获取对应课程
	
	@Query(value="UPDATE curriculum_tb c SET c.subscription_num=c.subscription_num+1 WHERE c.curriculum_id=?1",nativeQuery=true)
	@Transactional@Modifying
	int updateSubscriptionNum(Integer currId);//添加订阅人数
	
	@Query(value="UPDATE curriculum_tb c SET c.subscription_num=c.subscription_num-1 WHERE c.curriculum_id=?1",nativeQuery=true)
	@Transactional@Modifying
	int delSubscriptionNum(Integer currId);//课程订阅人数-1
	
	@Query(value="UPDATE curriculum_tb c SET c.whether_to_issue=1,c.start_time=?2,c.end_time=?3 WHERE c.curriculum_id=?1",nativeQuery=true)
	@Transactional@Modifying
	int updateIsReleaseToTrue(Integer currId,Date startTime,Date endTime);//发布课程
	
	@Query(value="UPDATE curriculum_tb c SET c.whether_to_issue=0,c.start_time=null,c.end_time=null WHERE c.curriculum_id=?1",nativeQuery=true)
	@Transactional@Modifying
	int updateIsReleaseToFalse(Integer currId);//取消发布课程

	@Query(value="SELECT curriculum_id FROM curriculum_tb ORDER BY subscription_num DESC LIMIT 12",nativeQuery=true)
    List<Integer> getCurrIdBySubscriptionNum();//根据订阅人数获取前12条课程id
}
