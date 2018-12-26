package com.cxb.wmx.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.wmx.entity.Commitreport;
import com.cxb.wmx.entity.Postcommit;

/**
 * 评论举报dao层
 * 
 * @author 王梦霞
 *
 */
public interface ComReportRpository
		extends JpaRepository<Commitreport, Integer>, JpaSpecificationExecutor<Commitreport> {

	List<Commitreport> findByPostcommit(Postcommit postcommit);
	
	/**
	 * 根据id查询Commitreport
	 * 
	 * @param commitreportId
	 * @author 王梦霞
	 * @return
	 */
	Commitreport findByCommitreportId(Integer commitreportId);

	/**
	 * 根据状态查询评论举报总数
	 * 
	 * @param commitreportStuts
	 * @return
	 */
	@Query(value = "SELECT COUNT(commitreport_id) FROM tb_commitreport WHERE commitreport_stuts =:commitreportStuts ", nativeQuery = true)
	Integer queryByComStuts(@Param(value = "commitreportStuts") Integer commitreportStuts);

	/**
	 * 根据状态查询举报信息
	 * 
	 * @param commitreportStuts
	 * @return
	 */
	List<Commitreport> findByCommitreportStuts(Integer commitreportstuts);
	
	/**
	 * 删除评论举报信息
	 * 
	 * @param postcommitId
	 * @author 王梦霞
	 * @return
	 */
	@Query(value = "DELETE FROM tb_commitreport WHERE postcommit_id=:postcommitId", nativeQuery = true)
	@Modifying
	@Transactional
	int deleteByPostcommitId(@Param(value = "postcommitId") Integer postcommitId);
	
}
