package com.cxb.mzl.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.mzl.dao.UsersdetailsRepository;
import com.cxb.mzl.entity.Usersdetails;
import com.cxb.mzl.service.UsersdetailsService;

/**
*@author 作者 E-mail 谢立博 13837051752@163.com
*@version 创建时间:2018年12月20日下午10:33:28
*类说明   用户详情类
*/
@Service
public class UsersdetailsServiceImpl implements UsersdetailsService {
	@Autowired
	private UsersdetailsRepository usersdetailsRepository;
	
	/**
	 * 根据用户id查询用户详情
	 * */
	@Override
	public List<Integer> getUserDeteils(Integer userId) {
		return usersdetailsRepository.getUserDeteils(userId);
	}
	/**
	 * 跟据用户id修改用户详细信息（即个人中心资料设置）
	 * */
	@Override
	public Usersdetails UpdateUsersdetails(Usersdetails usersdetails) {
		return usersdetailsRepository.save(usersdetails);
	}
	/**
	 * 查询所有老师id以及名字
	 * */
	@Override
	public List<Usersdetails> queryTeacherIdAndName() {
		return usersdetailsRepository.queryTeacherIdAndName();
	}
	/**
	 * 查询所有学生id以及名字
	 * */
	@Override
	public List<Usersdetails> queryStudentIdAndName() {
		return usersdetailsRepository.queryStudentIdAndName();
	}

}
