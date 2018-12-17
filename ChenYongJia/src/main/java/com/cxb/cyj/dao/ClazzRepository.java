package com.cxb.cyj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.cyj.entity.Clazz;

public interface ClazzRepository extends JpaRepository<Clazz, Integer>, JpaSpecificationExecutor<Clazz> {

	/**
	 * 根据班级名查询
	 * 
	 * @param clazzName
	 * @return
	 * @author GuoShiCai
	 */
	Clazz findByClassName(String className);
	
	/**
	 * 根据classId查询
	 * 
	 * @param classId
	 * @return
	 * @author GuoShiCai
	 */
	Clazz findByClassId(Integer classId);
	
	/**
	 * 批量删除班级信息
	 * 
	 * @param stuList
	 * @return
	 * @author GuoShiCai
	 */
	@Query(value = "DELETE FROM tb_clazz WHERE class_id IN (:stuList)", nativeQuery = true)
	@Modifying
	@Transactional
	Integer deleteBatch(@Param(value = "stuList") List<String> stuList);
}
