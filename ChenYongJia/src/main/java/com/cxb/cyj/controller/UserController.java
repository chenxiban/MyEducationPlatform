package com.cxb.cyj.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.cyj.entity.Result;
import com.cxb.cyj.entity.User;
import com.cxb.cyj.entitysearch.UserSearch;
import com.cxb.cyj.service.UserService;
import com.cxb.cyj.util.IsEmptyUtils;

/**
 * 
 * @Description: 用户控制器
 * @ClassName: UserController.java
 * @author ChenYongJia
 * @Date 2018年12月04日 下午20:40:56
 * @Email 867647213@qq.com
 */
@RestController
@RequestMapping(value = "/user", name = "用户模块")
public class UserController {

	@Autowired
	private UserService userService;

	@Value("${server.port}")
	private String serverPort;

	/**
	 * http://localhost:3011/chenyongjia/ChenYongJia/user/getFuture
	 * 
	 * @author Chenyongjia
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('user:getFuture')") // 等于
															// .antMatchers("/deleteOrder").hasAnyAuthority("deleteOrder")
	@RequestMapping(value = "/getFuture", name = "测试控制器方法")
	public List<String> getFuture() {
		List<String> list = new ArrayList<>();
		list.add("不积跬步，无以至千里；");
		list.add("不积小流，无以成江海。");
		list.add("出自端口号:" + serverPort);
		return list;
	}

	/**
	 * 分页检索查询 http://localhost:3011/chenyongjia/ChenYongJia/users/getAllPageUsers
	 * 
	 * @author ChenYongJia
	 * @param userSearch
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('user:getAllPageUsers')")
	@RequestMapping(value = "/getAllPageUsers", name = "查询用户", method = RequestMethod.GET)
	public Object getAllPageUsers(UserSearch userSearch) {
		System.out.println("当前查询参数===>" + userSearch);
		Pageable pageable = PageRequest.of(userSearch.getPage() - 1, userSearch.getRows(), Sort.Direction.ASC,
				"userId");
		Page<User> page = userService.sreachByUser(userSearch, pageable);
		Long total = page.getTotalElements();
		List<User> list = page.getContent();

		System.out.println("查询到的数据为=====>" + list);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}

	/**
	 * 添加用户信息
	 * http://localhost:3011/chenyongjia/ChenYongJia/user/addUsers?usersName=郭士才7&usersStuNo=123456
	 * 
	 * @author GuoShiCai
	 * @param u
	 * @return
	 */
	@RequestMapping(value = "/addUsers", method = RequestMethod.PUT)
	public Object addUsers(User u) {
		u.setUserCreatTime(new Date(System.currentTimeMillis()));
		u.setUserPassword("cyj123");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // 加密
		String encodedPassword = passwordEncoder.encode(u.getUserPassword().trim());
		u.setUserPassword(encodedPassword);
		u.setUserCreatTime(new Date());
		User ulist = userService.findsLoginName(u.getUserName());
		if (IsEmptyUtils.isEmpty(ulist)) {
			if (userService.addUser(u)) {
				return new Result(true, "用户添加成功");
			} else {
				return new Result(false, "用户添加失败");
			}
		} else {
			return new Result(false, "用户名重复,请重新填写");
		}
	}

	/**
	 * 删除用户 http://localhost:3011/chenyongjia/ChenYongJia/user/delUsers
	 * 
	 * @author GuoShiCai
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/delUsers", name = "删除用户", method = RequestMethod.DELETE)
	public Object delUsers(String userId) {
		List<String> list = new ArrayList<String>();
		String[] ids = userId.split(",");
		for (String dids : ids) {
			list.add(dids);
		}
		System.out.println(list);
		if (userService.delUser(list)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 修改用户
	 * http://localhost:3011/chenyongjia/ChenYongJia/user/updUsers?usersId=1&usersName=是是是&usersStuNo=1111
	 * 
	 * @author GuoShiCai
	 * @param u
	 * @return
	 */
	@RequestMapping(value = "/updUsers", name = "修改用户", method = RequestMethod.POST)
	public Object updUsers(User u) {
		User user = userService.updUserById(u.getUserId());
		if (!IsEmptyUtils.isEmpty(u.getUserName())) {
			user.setUserName(u.getUserName());
		}
		if (!IsEmptyUtils.isEmpty(u.getUserStuNo())) {
			user.setUserStuNo(u.getUserStuNo());
		}
		if (!IsEmptyUtils.isEmpty(u.getUserProtectMTel())) {
			user.setUserProtectMTel(u.getUserProtectMTel());
		}
		if (!IsEmptyUtils.isEmpty(u.getUserProtectEMail())) {
			user.setUserProtectEMail(u.getUserProtectEMail());
		}

		user.setUserId(u.getUserId());
		if (userService.addUser(user)) {
			return new Result(true, "用户修改成功");
		} else {
			return new Result(false, "用户名重复,请重新填写!");
		}
	}

}
