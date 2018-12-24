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
	
	
	/**
	 * @author 王梦霞
	 * 用户删除自己的回复
	 * @param hfId
	 * @return
	 */
	@Query(value="DELETE FROM  tb_postreply WHERE postreply_id =:hfId",nativeQuery=true)
	@Modifying
	@Transactional
	int deleteUserPostreplyById(@Param(value="hfId") Integer hfId);
	
	
	/**
	 * 根据回复id查询回复的点赞总数
	 * @author 王梦霞
	 * @param hfId
	 * @return
	 */
	@Query(value="SELECT COUNT(*) AS replyLike FROM tb_postreplylike WHERE postreply_id=:hfId AND postreplylike_stuts=1",nativeQuery=true)
	int queryPostReplyLikeByhfIdDz(@Param("hfId") Integer hfId);
	
	/**
	 * 根据回复id查询回复的踩赞总数
	 * @author 王梦霞
	 * @param hfId
	 * @return
	 */
	@Query(value="SELECT COUNT(*) AS replyLike FROM tb_postreplylike WHERE postreply_id=:hfId AND postreplylike_stuts=2",nativeQuery=true)
	int queryPostReplyLikeByhfIdCz(@Param("hfId") Integer hfId);
}
