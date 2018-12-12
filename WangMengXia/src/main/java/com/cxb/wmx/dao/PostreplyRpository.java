package com.cxb.wmx.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.wmx.entity.Postreply;

public interface PostreplyRpository extends JpaRepository<Postreply, Integer>, JpaSpecificationExecutor<Postreply>{
	
	/**
	 * 根据评论id查询当前评论下是否存在回复
	 * @param postcommitId
	 * @return
	 */
	@Query(value="SELECT postreply_id,postcommit_id FROM tb_postreply WHERE postcommit_id=:postcommitId",nativeQuery=true)
	Postreply selectByPostcommitId(@Param(value="postcommitId")Integer postcommitId);
	
	/**
	 * 根据评论id查询当前评论下是否存在回复
	 * @param postcommitId
	 * @return
	 */
	@Query(value="SELECT postreply_id,postcommit_id FROM tb_postreply WHERE postcommit_id IN (:postcommitId)",nativeQuery=true)
	List<Postreply> selectByListId(@Param(value="postcommitId")List<Integer> postcommitId);
	
	/**
	 * 通过管理员的审查后的删除
	 * @param barId
	 * @return
	 */
	@Query(value="DELETE FROM  tb_postreply WHERE postreply_report =1 AND postreply_id =:hfId",nativeQuery=true)
	@Modifying
	@Transactional
	int deletePostreplyById(@Param(value="hfId") Integer hfId);
	
}
