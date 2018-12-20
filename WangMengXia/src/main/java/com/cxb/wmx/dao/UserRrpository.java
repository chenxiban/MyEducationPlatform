package com.cxb.wmx.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.LikeExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.wmx.entity.Users;


public interface UserRrpository extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users>{

	/**
	 * 查询用户的名称
	 * @param userName
	 * @return
	 * 王梦霞
	 */
	Users findByUserName(String userName);
	
	/**
	 * 贴吧管理员登录功能
	 * 王梦霞
	 * @param userName
	 * @param userPwd
	 * @return
	 */
    Users findByUserNameAndUserPwd(String userName, String userPwd);
    
    /**
     * 根据id查询所有信息
     * @param uid
     * @return
     */
    Users findByUserId(Integer userId);
    /**
	 * 用户的发帖
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="SELECT post_id FROM tb_post WHERE user_id=:uid",nativeQuery=true)
	List<Integer> getUserPostCountByUid(@Param("uid") Integer uid);
	
	/**
	 * 用户的发帖总数
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="SELECT COUNT(post_id) AS postCount FROM tb_post WHERE user_id=:uid",nativeQuery=true)
	int getUserPostCount(@Param("uid") Integer uid);
	
	/**
	 * 用户的评论总数
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="SELECT COUNT(postcommit_id) AS postCommit FROM tb_postcommit WHERE post_id IN(:pid)",nativeQuery=true)
	int getUserPostCommit(@Param("pid") List<Integer> pid);
	
	/**
	 * 用户的点赞总数
	 * @author 王梦霞
	 * @returnpostDisLike
	 */
	@Query(value="SELECT COUNT(postlike_id) AS postLike FROM tb_postlike WHERE post_id IN(:pid) AND postlike_stuts=1",nativeQuery=true)
	int getUserPostLike(@Param("pid") List<Integer> pid);
	
	/**
	 * 用户的c踩赞总数
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="SELECT COUNT(postlike_id) AS postDisLike FROM tb_postlike WHERE post_id IN(:pid) AND postlike_stuts=2",nativeQuery=true)
	int getUserPostDisLike(@Param("pid") List<Integer> pid);
}
