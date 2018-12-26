package com.cxb.mzl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cxb.mzl.entity.Usersdetails;

/**
*@author 作者 E-mail 谢立博 13837051752@163.com
*@version 创建时间:2018年12月20日下午10:31:09
*类说明   用户详情类
*/

public interface UsersdetailsService {
	/**
	 * 根据用户id查询用户详情
	 * */
	List<Integer> getUserDeteils(Integer userId);
	/**
	 * 跟据用户id修改用户详细信息（即个人中心资料设置）
	 * */
	public Usersdetails UpdateUsersdetails(Usersdetails usersdetails);
	/**
	 * 查询所有老师id以及名字
	 * */
	List <Usersdetails> queryTeacherIdAndName();
	/**
	 * 查询所有学生id以及名字
	 * */
	List <Usersdetails> queryStudentIdAndName();
}
