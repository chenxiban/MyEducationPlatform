package com.cxb.wmx.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cxb.wmx.entity.Discomreport;

public interface DiscomreportRepository extends JpaRepository<Discomreport, Integer> ,JpaSpecificationExecutor<Discomreport>{
	/**
	 * @author SUN
	 * 修改评论举报状态为举报(1)
	 * @param discommentId
	 * @return
	 */
	@Query(value="UPDATE tb_discommit SET discommit_report = 1 WHERE discommit_id =?1",nativeQuery=true)
	@Modifying
	@Transactional
	public Integer updateDiscomreport(Integer discommentId);
}
