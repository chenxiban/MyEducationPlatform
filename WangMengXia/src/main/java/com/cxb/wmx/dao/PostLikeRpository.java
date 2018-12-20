package com.cxb.wmx.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.wmx.entity.Postcommit;
import com.cxb.wmx.entity.Postlike;


public interface PostLikeRpository extends JpaRepository<Postlike, Integer>, JpaSpecificationExecutor<Postlike>{

	
	/**
	 * 前10的总点赞最多的帖子
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="SELECT postlike_id,postlike_createtime,postlike_stuts,postlike_update_time,user_id,post_id,COUNT(post_id) AS number FROM tb_postlike WHERE postlike_stuts=1 GROUP BY  post_id ORDER BY number DESC",nativeQuery=true)
	List<Postlike> selectPostListByTopD();
	/**
	 * 前10的总踩赞最多的帖子
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="SELECT postlike_id,postlike_createtime,postlike_stuts,postlike_update_time,user_id,post_id,COUNT(post_id) AS number FROM tb_postlike WHERE postlike_stuts=2 GROUP BY  post_id ORDER BY number DESC",nativeQuery=true)
	List<Postlike> selectPostListByTopC();
	
	/**
	 * 用户给帖子点赞
	 * @param barId
	 * @return
	 */
	@Query(value="INSERT INTO tb_postlike (post_id,user_id,postlike_stuts) VALUES (:postId,:userId,1)",nativeQuery=true)
	@Modifying
	@Transactional
	int addPostlikeDz(@Param("postId")Integer postId,@Param("userId")Integer userId);
	
	/**
	 * 用户给帖子踩赞
	 * @param 
	 * @return
	 */
	@Query(value="INSERT INTO tb_postlike (post_id,user_id,postlike_stuts) VALUES (:postId,:userId,2)",nativeQuery=true)
	@Modifying
	@Transactional
	int addPostlikeCz(@Param("postId")Integer postId,@Param("userId")Integer userId);
	
	/**
	 * 用户给帖子取消点赞
	 * @param 
	 * @return
	 */
	@Query(value="DELETE FROM tb_postlike WHERE post_id=:postId AND user_id=:userId",nativeQuery=true)
	@Modifying
	@Transactional
	int deletePostlikeDz(@Param("postId")Integer postId,@Param("userId")Integer userId);
	
	/**
	 * 用户给帖子取消点赞
	 * @param 
	 * @return
	 */
	@Query(value="DELETE FROM tb_postlike WHERE post_id=:postId AND user_id=:userId",nativeQuery=true)
	@Modifying
	@Transactional
	int deletePostlikeCz(@Param("postId")Integer postId,@Param("userId")Integer userId);

	/**
	 * 用户给帖子点赞后进行踩赞的操作
	 * @param 
	 * @return
	 */
	@Query(value="UPDATE tb_postlike SET postlike_stuts=2 WHERE post_id=:postId AND user_id=:userId",nativeQuery=true)
	@Modifying
	@Transactional
	int updatePostlikeDz(@Param("postId")Integer postId,@Param("userId")Integer userId);
	
	/**
	 * 用户给帖子踩赞后进行点赞的操作
	 * @param 
	 * @return
	 */
	@Query(value="UPDATE tb_postlike SET postlike_stuts=1 WHERE post_id=:postId AND user_id=:userId",nativeQuery=true)
	@Modifying
	@Transactional
	int updatePostlikeCz(@Param("postId")Integer postId,@Param("userId")Integer userId);
}
