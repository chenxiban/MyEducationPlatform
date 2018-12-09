package com.cxb.wmx.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.entity.Result;
import com.cxb.wmx.entity.Users;
import com.cxb.wmx.service.UserService;
import com.cxb.wmx.util.IsEmptyUtils;

/**
 * 用户控制层
 * @author 王梦霞
 *
 */
@RestController
@RequestMapping(value="/user",name="管理员")
public class UserController {

	@SuppressWarnings("unused")
	@Autowired
	private UserService userService;
	private Date date = new Date();
	private Timestamp timestamp = new Timestamp(date.getTime());
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/user/loginUsers
	 * @param users
	 * @return
	 * 王梦霞
	 */
	@RequestMapping(value = "/loginUsers", name = "管理员登录")
	public Object loginUsers(Users users) {
		Users u = userService.findByUserName(users.getUserName());
		if (!IsEmptyUtils.isEmpty(u)) {// 查询当前用户存在不
			int uid = u.getUserId();
			String userName = users.getUserName();
			String userPwd = users.getUserPwd();
		}
		return u;
	}
}

