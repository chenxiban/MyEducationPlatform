package com.cxb.wmx.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.wmx.entity.Commitlike;
import com.cxb.wmx.entity.Postlike;

/**
 * 评论点踩赞Rpostiory层
 * @author 王梦霞
 *
 */
public interface PostComLikeRpository extends JpaRepository<Commitlike, Integer>, JpaSpecificationExecutor<Commitlike>{

	/**
	 * 用户给评论点赞
	 * @param 
	 * @return
	 */
	@Query(value="INSERT INTO tb_commitlike (postcommit_id,user_id,commitlike_stuts) VALUES (:commitId,:userId,1) ",nativeQuery=true)
	@Modifying
	@Transactional
	int addPostComlikeDz(@Param("commitId")Integer commitId,@Param("userId")Integer userId);
	
	/**
	 * 用户给评论踩赞
	 * @param 
	 * @return
	 */
	@Query(value="INSERT INTO tb_commitlike (postcommit_id,user_id,commitlike_stuts) VALUES (:commitId,:userId,2)",nativeQuery=true)
	@Modifying
	@Transactional
	int addPostComlikeCz(@Param("commitId")Integer commitId,@Param("userId")Integer userId);
	
	/**
	 * 用户给评论取消点赞
	 * @param 
	 * @return
	 */
	@Query(value="DELETE FROM tb_commitlike WHERE postcommit_id=:commitId AND user_id=:userId",nativeQuery=true)
	@Modifying
	@Transactional
	int deletePostComlikeDz(@Param("commitId")Integer commitId,@Param("userId")Integer userId);
	
	/**
	 * 用户给评论取消点赞
	 * @param 
	 * @return
	 */
	@Query(value="DELETE FROM tb_commitlike WHERE postcommit_id=:commitId AND user_id=:userId",nativeQuery=true)
	@Modifying
	@Transactional
	int deletePostComlikeCz(@Param("commitId")Integer commitId,@Param("userId")Integer userId);

	/**
	 * 用户给评论点赞后进行踩赞的操作
	 * @param 
	 * @return
	 */
	@Query(value="UPDATE tb_commitlike SET commitlike_stuts=2 WHERE postcommit_id=:commitId AND user_id=:userId",nativeQuery=true)
	@Modifying
	@Transactional
	int updatePostComlikeDz(@Param("commitId")Integer commitId,@Param("userId")Integer userId);
	
	/**
	 * 用户给评论踩赞后进行点赞的操作
	 * @param 
	 * @return
	 */
	@Query(value="UPDATE tb_commitlike SET commitlike_stuts=1 WHERE postcommit_id=:commitId AND user_id=:userId",nativeQuery=true)
	@Modifying
	@Transactional
	int updatePostComlikeCz(@Param("commitId")Integer commitId,@Param("userId")Integer userId);
}
