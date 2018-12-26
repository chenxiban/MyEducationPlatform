package com.cxb.cyj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.cyj.entity.CourseTui;

/**
 * 
 * @Description: 推荐课程Dao接口
 * @ClassName: CourseTuiRepository.java
 * @author Chenyongjia
 * @Date 2018年11月12日 下午22:01
 * @Email 867647213@qq.com
 */
public interface CourseTuiRepository extends JpaRepository<CourseTui, Integer>, JpaSpecificationExecutor<CourseTui>  {
	
	
	/**
	 * 删除推荐课程信息
	 * 
	 * @param courseId
	 * @author Chenyongjia
	 * @return
	 */
	@Query(value = "DELETE FROM tb_coursetui WHERE course_id=:courseId", nativeQuery = true)
	@Modifying
	@Transactional
	Integer deleteBatch(@Param(value = "courseId") Integer courseId);
	
}
