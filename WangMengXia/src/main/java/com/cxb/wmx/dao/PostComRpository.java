package com.cxb.wmx.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.wmx.entity.Postcommit;

public interface PostComRpository extends JpaRepository<Postcommit, Integer>, JpaSpecificationExecutor<Postcommit>{

	
	/**
	 * 根据postcommitid查询Postcommit评论
	 * @param copostcommitidmId
	 * @return
	 * @author 王梦霞
	 */
	Postcommit  findByPostcommitId(Integer postcommitid);
	/**
	 * 删除评论下的回复
	 * @param postcommitId
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="DELETE FROM tb_postcommit WHERE postcommit_id=:postcommitId",nativeQuery=true)
	@Modifying
	@Transactional
	int deletePostCommitById(@Param(value="postcommitId") Integer postcommitId);
	/**
	 * 删除评论
	 * @param postcommitId
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="DELETE FROM tb_postcommit WHERE postcommit_id=:postcommitId AND postcommit_report=1",nativeQuery=true)
	@Modifying
	@Transactional
	int deletePostCommitByIds(@Param(value="postcommitId") Integer postcommitId);
	
	
	/**
	 * 删除评论下的回复
	 * @param postcommitId
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="DELETE FROM tb_postreply WHERE postcommit_id IN (:postcommitId)",nativeQuery=true)
	@Modifying
	@Transactional
	int deleteRetByList(@Param(value="postcommitId") List<Integer> postcommitId);
	
	/**
	 * 删除评论
	 * @param postcommitId
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="DELETE FROM tb_postcommit WHERE postcommit_id IN (:postcommitId)",nativeQuery=true)
	@Modifying
	@Transactional
	int deleteComByList(@Param(value="postcommitId") List<Integer> postcommitId);
	
	/**
	 * 删除帖子
	 * @param postId
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="SELECT * FROM tb_postcommit WHERE post_id=:postId",nativeQuery=true)
	List<Postcommit> selectPostComiByPostId(@Param(value="postId") Integer postId);
	
	/**
	 * 评论最多的帖子desc
	 * @param postId
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="SELECT postcommit_id,postcommit_count,postcommit_createtime,postcommit_name,postcommit_report,postcommit_update_time,user_id,user_touurl,post_id,COUNT(post_id) AS number FROM tb_postcommit GROUP BY post_id ORDER BY number DESC",nativeQuery=true)
	List<Postcommit> selectPostByTop();
	
	
	/**
	 * 用户删除自己发的评论
	 * @author 王梦霞
	 * @param pid
	 * @return
	 */
	@Query(value="DELETE FROM tb_postcommit WHERE postcommit_id =:pid",nativeQuery=true)
	@Modifying
	@Transactional
	int deleteUserPostComByPid(@Param(value="pid") Integer pid);
	
	/**
	 * 根据评论id查询评论的回复总数
	 * @author 王梦霞
	 * @param pid
	 * @return
	 */
	@Query(value="SELECT COUNT(*) AS replyConut FROM tb_postreply WHERE postcommit_id=:pid",nativeQuery=true)
	int queryPostReplyByPid(@Param("pid") Integer pid);
	
	/**
	 * 根据评论id查询评论的点赞总数
	 * @author 王梦霞
	 * @param pid
	 * @return
	 */
	@Query(value="SELECT COUNT(*) AS commitLike FROM tb_commitlike WHERE postcommit_id=:pid AND commitlike_stuts=1",nativeQuery=true)
	int queryPostReplyLikeByPidDz(@Param("pid") Integer pid);
	
	/**
	 * 根据评论id查询评论的踩赞总数
	 * @author 王梦霞
	 * @param pid
	 * @return
	 */
	@Query(value="SELECT COUNT(*) AS commitDisLike FROM tb_commitlike WHERE postcommit_id=:pid AND commitlike_stuts=2",nativeQuery=true)
	int queryPostReplyLikeByPidCz(@Param("pid") Integer pid);
	
	
	/**
	 * 查询发表总评论数
	 * @param postcommitName
	 * @return 刘森川
	 */
	@Query(value = "SELECT COUNT(*) FROM tb_postcommit WHERE user_id=?1", nativeQuery = true) 
	int selectPostCommitCount(Integer userId);
	
	/**
	 * 查询发表评论的时间,内容,帖子id
	 * @param userId
	 * @return 刘森川
	 */
	@Query(value="\r\n" + 
			"SELECT post_id,postcommit_createtime,postcommit_count FROM tb_postcommit WHERE user_id=?1",nativeQuery = true)
	List<Integer> selectPostCommitCtime(Integer userId);
	
	/**
	 * 根据主题id查询主题
	 * @param userId
	 * @return 刘森川
	 */
	@Query(value="SELECT post_title FROM tb_post WHERE post_id=?1",nativeQuery = true)
	List<String> selectPostCommitPost(Integer postId);
	
	/**
	 * 查询所有评论
	 * @author 刘森川
	 * @param pageable 
	 * 
	 */
	@Query(value="SELECT * FROM tb_postcommit WHERE user_id=?1",nativeQuery=true)
	List<Postcommit> selectPostComByUser(Integer userId);
}
