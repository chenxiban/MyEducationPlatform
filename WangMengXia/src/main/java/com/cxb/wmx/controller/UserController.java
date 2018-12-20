package com.cxb.wmx.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping(value="/user")
public class UserController {

	@SuppressWarnings("unused")
	@Autowired
	private UserService userService;
	private Date date = new Date();
	private Timestamp timestamp = new Timestamp(date.getTime());
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/user/loginUsers?userName=贴吧管理员&userPwd=123456
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
			/*return new Result(true,"登录成功");*/
					
			if (userPwd.equals(u.getUserPwd())) {
				users.getUserPwd();
				return new Result(true,"登录成功");
			} else {
				return new Result(false,"密码错误");
			}
		}else {
			return new Result(false,"当前用户不存在");
		}
	}
	
	/**
	 * 获取登录人的详细信息
	 * http://localhost:3011/wangmengxia/WangMengXia/user/getUserById?uid=1
	 * http://localhost:3030/WangMengXia/user/getUserById&uid=1
	 * @author 王梦霞
	 * @param uid
	 * @return
	 */
	@RequestMapping(value="/getUserById",method=RequestMethod.GET)
	public Object getUserById(Integer uid) {
		return userService.selectUserById(uid);
	}
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/user/getUserPostCountByUid?uid=1
	 * 用户发帖总数,评论总数,点赞总数
	 * @param uid
	 * @param pid
	 * @return
	 */
	@RequestMapping(value="/getUserPostCountByUid")
	public Object getUserPostCountByUid(Integer uid) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("postCount", userService.getUserPostCount(uid));
		List<Integer> pid=userService.getUserPostCountByUid(uid);
		map.put("postCmmit", userService.getUserPostCommit(pid));
		map.put("postLike", userService.getUserPostLike(pid));
		map.put("postDisLike", userService.getUserPostDisLike(pid));
		return map;
	}
}

