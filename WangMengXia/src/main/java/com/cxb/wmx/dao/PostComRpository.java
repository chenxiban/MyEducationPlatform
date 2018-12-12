package com.cxb.wmx.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.wmx.entity.Postcommit;
import com.cxb.wmx.entity.Postreply;

public interface PostComRpository extends JpaRepository<Postcommit, Integer>, JpaSpecificationExecutor<Postcommit>{

	/**
	 * 删除评论下的回复
	 * @param postcommitId
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="DELETE FROM  tb_postreply WHERE postcommit_id=:postcommitId",nativeQuery=true)
	@Modifying
	@Transactional
	int deletePostCommitById(@Param(value="postcommitId") Integer postcommitId);
	/**
	 * 删除评论
	 * @param postcommitId
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="DELETE FROM tb_postcommit WHERE postcommit_id=:postcommitId AND postcommit_report =1",nativeQuery=true)
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
	
}
