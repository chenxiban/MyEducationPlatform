package com.cxb.wmx.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.wmx.entity.Users;

public interface UserService {

	/**
	 * 查询用户名称
	 * @param userName
	 * @return
	 * 王梦霞
	 */
	public Users findByUserName(String userName);
	
	/**
	 * 管理员登录
	 * @param userName
	 * @param userPwd
	 * @return
	 * 王梦霞mizhongliang
	 */
	public boolean findByUserNameAndUserPwd(String userName,String userPwd);
	
	/**
	 * 根据用户id查询u用户详细信息
	 * @param uid
	 * @return
	 */
	public Users selectUserById(Integer uid);
	
	/**
	 * 用户的发帖
	 * @author 王梦霞
	 * @return
	 */
	List<Integer> getUserPostCountByUid(Integer uid);
	
	/**
	 * 用户的发帖总数
	 * @author 王梦霞
	 * @return
	 */
	Integer getUserPostCount(Integer uid);
	
	/**
	 * 用户的评论总数
	 * @author 王梦霞
	 * @return
	 */
	Integer getUserPostCommit(List<Integer> pid);
	
	/**
	 * 用户的点赞总数
	 * @author 王梦霞
	 * @return
	 */
	Integer getUserPostLike(List<Integer> pid);
	
	/**
	 * 用户的踩赞总数
	 * @author 王梦霞
	 * @return
	 */
	Integer getUserPostDisLike(List<Integer> pid);
}
