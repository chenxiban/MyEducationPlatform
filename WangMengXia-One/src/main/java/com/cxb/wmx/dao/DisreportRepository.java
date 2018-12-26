package com.cxb.wmx.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cxb.wmx.entity.Disreport;

public interface DisreportRepository extends JpaRepository<Disreport, Integer>,JpaSpecificationExecutor<Disreport> {

	/**
	 * @author SUN
	 * 修改帖子举报状态为举报(1)
	 * @param dispostId
	 * @return
	 */
	@Query(value="UPDATE tb_dispost SET dispost_report = 1 WHERE dispost_id = ?1",nativeQuery=true)
	@Modifying
	@Transactional
	public Integer updateDispostreport(Integer dispostId);
	
}
