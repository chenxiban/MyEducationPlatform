package com.cxb.mzl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.mzl.entity.Usersdetails;
import com.cxb.mzl.service.UsersdetailsService;

/**
*@author 作者 E-mail 谢立博 13837051752@163.com
*@version 创建时间:2018年12月20日下午10:37:04
*类说明   用户详情控制器
*/
@RestController
@RequestMapping(value = "/usersdetails", name = "用户详情模块")
public class UsersdetailsController {
	@Autowired
	private UsersdetailsService usersdetailsService;
	
	/**
	 * http://locahost:3011/mizhongliang/MiZhongLiang/usersdetails/getUserDeteils
	 * */
	@RequestMapping(value ="/getUserDeteils", name = "显示用户信息") 
	public List<Integer> getUserDeteils(Integer userId){
		return usersdetailsService.getUserDeteils(userId);
	}
	/**
	 * http://locahost:3011/mizhongliang/MiZhongLiang/usersdetails/UpdateUsersdetails
	 * */
	@RequestMapping(value ="/UpdateUsersdetails", name = "修改用户详情") 
	public Usersdetails UpdateUsersdetails(Usersdetails usersdetails) {
		return usersdetailsService.UpdateUsersdetails(usersdetails);
	}
	/**
	 * http://locahost:3011/mizhongliang/MiZhongLiang/usersdetails/queryTeacherIdAndName
	 * */
	@RequestMapping(value ="/queryTeacherIdAndName", name = "查询老师姓名和id集合") 
	public 	List <Usersdetails> queryTeacherIdAndName(){
		return usersdetailsService.queryTeacherIdAndName();
		
	}
	/**
	 * http://locahost:3011/mizhongliang/MiZhongLiang/usersdetails/queryStudentIdAndName
	 * */
	@RequestMapping(value ="/queryStudentIdAndName", name = "查询学生姓名和id集合") 
	public List <Usersdetails> queryStudentIdAndName(){
		return usersdetailsService.queryStudentIdAndName();
		
	}

}
