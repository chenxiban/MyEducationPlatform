package com.cxb.wmx.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.wmx.entity.Bar;


public interface BarRpository extends JpaRepository<Bar, Integer>, JpaSpecificationExecutor<Bar>{

	/**
	 * 查询贴吧分类的名称
	 * 王梦霞
	 * @param barName
	 * @return
	 */
	Bar findByBarCategory(String barName);
	
	/**
	 * 可删除多个
	 * @param barId
	 * @return
	 */
	@Query(value="DELETE  FROM tb_bar WHERE bar_id In(:barId)",nativeQuery=true)
	@Modifying
	@Transactional
	int deleteBarByIds(@Param(value="barId") List<String> barId);
}
