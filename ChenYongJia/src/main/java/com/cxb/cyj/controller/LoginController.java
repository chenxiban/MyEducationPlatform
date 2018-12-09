package com.cxb.cyj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.cyj.entity.Result;
import com.cxb.cyj.entity.User;
import com.cxb.cyj.md5.PasswordEncoder;
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
	private ConsumerService consumerService;

	@Autowired
	private UserService userService;

	/**
	 * http://localhost:3011/chenyongjia/ChenYongJia/oauth/token?username=user_1&password=123456
	 * name:登录获取Token
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@RequestMapping("/oauth/token")
	public Object getToken(String username, String password) {
		/*User user = userService.findsLoginName(username);
		if (IsEmptyUtils.isEmpty(username)) {
			return new Result(false, "用户名不能为空!");
		} else if (IsEmptyUtils.isEmpty(password)) {
			return new Result(false, "用户密码不能为空!");
		}

		if (IsEmptyUtils.isEmpty(user)) {
			return new Result(false, "当前用户不存在");
		} else {
			PasswordEncoder encoder = new PasswordEncoder(username, "MD5");
			String loginpwd = encoder.encode(password);
			if (loginpwd.equals(user.getUsersPassword())) {
				Object object = consumerService.getToken(username, password);
				if (IsEmptyUtils.isEmpty(object)) {
					return new Result(false, "登录失败");
				} else {
					return new Result(true, object);
				}
			} else {
				return new Result(false, "用户密码输入错误");
			}
		}*/
		return consumerService.getToken(username, password);

	}

	/**
	 * http://localhost:3011/chenyongjia/ChenYongJia/oauth/check_token?token=a18b696b-4943-483a-8e16-f80885b3c2df
	 * name:验证token是否有效
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@RequestMapping("/oauth/check_token")
	public Object checkToken(String token) {
		System.out.println("用于验证的token为=======>" + token);
		try {
			Object object=consumerService.checkToken(token);
			return new Result(true, object);
		} catch (Exception e) {
			return new Result(false, "当前token无效，请登录重试！！！");
		}
	}

	/**
	 * http://localhost:3011/chenyongjia/ChenYongJia/oauth/check_token?refresh_token=token
	 * name:注销token
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@RequestMapping("/oauth/refresh_Token")
	public boolean refreshToken(String token) {
		System.out.println("用于注销的token为=======>" + token);
		if (!IsEmptyUtils.isEmpty(consumerService.refreshToken(token))) {
			return true;
		} else {
			return false;
		}
	}

}
