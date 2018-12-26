package com.cxb.cyj.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.cyj.entity.Result;
import com.cxb.cyj.entity.User;
import com.cxb.cyj.service.PermissionService;
import com.cxb.cyj.service.UserService;
import com.cxb.cyj.service.impl.ConsumerService;
import com.cxb.cyj.util.IsEmptyUtils;

/**
 * 
 * @Description: 登录控制器
 * @ClassName: UserController.java
 * @author ChenYongJia
 * @Date 2018年12月04日 下午20:40:56
 * @Email 867647213@qq.com
 */
@RestController
public class LoginController {

	@Autowired
	private ConsumerService consumerServiceTwo;
	
	@Autowired
	private PermissionService permissionService;

	@Autowired
	private UserService userService;

	/**
	 * 用于oauth2.0的密码认证模式的参数
	 * 
	 * @author chenyongjia
	 */
	private String grant_type = "";
	private final String client_id = "client_1";
	private final String client_secret = "123456";
	private final String scope = "all";

	/**
	 * http://localhost:3011/chenyongjia/ChenYongJia/oauth/token?username=user_1&password=123456
	 * name:登录获取Token
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@RequestMapping(value = "/oauth/token", method = RequestMethod.GET)
	public Object getToken(String username, String password,String backUrl) {
		grant_type = "password";

		User user = userService.findsLoginName(username);
		if (IsEmptyUtils.isEmpty(username)) {
			return new Result(false, "用户名不能为空!");
		} else if (IsEmptyUtils.isEmpty(password)) {
			return new Result(false, "用户密码不能为空!");
		}

		if (IsEmptyUtils.isEmpty(user)) {
			return new Result(false, "当前用户不存在");
		} else {
			User user2=new User();
			user2.setUserName(username);
			user2.setUserPassword(password);
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // 加密
			System.out.println("密码是否相等=========>"+passwordEncoder.matches(password, user.getUserPassword()));
			if (passwordEncoder.matches(password, user.getUserPassword())) {
				int p=user.getUserPsdWrongTime();
				if (p<3) {
					user.setUserPsdWrongTime(0);
					user.setUserLastLoginTime(new Date());
					userService.addUser(user);
					Object object = consumerServiceTwo.getToken(grant_type, username, password, client_id, client_secret, scope);
					if (IsEmptyUtils.isEmpty(object)) {
						return new Result(false, "登录失败，请重试");
					} else {
						// 根据用户Id查询出该用户的所有权限
						List<String> permissionValueList = userService
								.queryPermissionValueByUserId(user.getUserId());
						List<Integer> urRoles=userService.getUserRole(user.getUserId());
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("object", object);
						map.put("roleIds", urRoles);
						map.put("permission", permissionValueList);
						if (!IsEmptyUtils.isEmpty(backUrl)) {
							map.put("backUrl", backUrl);
						}
						return new Result(true, map);
					}
				} else {
					return new Result(false, "当前用户已被锁定请联系管理员");
				}
			} else {
				int p=user.getUserPsdWrongTime();
				if (p<3) {
					if (p == 3) {
						user.setUserPsdWrongTime(p+1);
						user.setUserIsLookout("是");
						user.setUserLockTime(new Date());
						userService.addUser(user);
					} else {
						user.setUserPsdWrongTime(p+1);
						userService.addUser(user);
					}
				} else {
					return new Result(false, "当前用户已被锁定请联系管理员");
				}
				return new Result(false, "用户密码输入错误");
			}
		}

		//return consumerServiceTwo.getToken(grant_type, username, password, client_id, client_secret, scope);

	}

	/**
	 * http://localhost:3011/chenyongjia/ChenYongJia/oauth/check_token?token=a18b696b-4943-483a-8e16-f80885b3c2df
	 * name:验证token是否有效
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@RequestMapping(value = "/oauth/check_token", method = RequestMethod.GET)
	public Object checkToken(@RequestParam(value = "token") String token) {
		System.out.println("用于验证的token为=======>" + token);
		try {
			Object object = consumerServiceTwo.checkToken(token);
			return new Result(true, object);
		} catch (Exception e) {
			return new Result(false, "当前token无效，请登录重试！！！");
		}
	}

	/**
	 * http://localhost:3011/chenyongjia/ChenYongJia/oauth/refresh_Token?token=token
	 * name:注销token
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@RequestMapping(value = "/oauth/refresh_Token", method = RequestMethod.GET)
	public boolean refreshToken(@RequestParam(value = "token") String token) {
		grant_type = "refresh_token";
		System.out.println("用于注销的token为=======>" + token);
		if (!IsEmptyUtils.isEmpty(consumerServiceTwo.refreshToken(grant_type, token, client_id, client_secret))) {
			return true;
		} else {
			return false;
		}
	}

}
