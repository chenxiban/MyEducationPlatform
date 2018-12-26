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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.cyj.entity.Result;
import com.cxb.cyj.entity.User;
import com.cxb.cyj.entitysearch.UserSearch;
import com.cxb.cyj.service.MyTokenService;
import com.cxb.cyj.service.RolesService;
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
	@Autowired
	private RolesService rolesService;
	@Autowired
	private MyTokenService myTokenService;

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
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
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
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
	@RequestMapping(value = "/addUsers",name="添加用户信息", method = RequestMethod.PUT)
	public Object addUsers(User u) {
		u.setUserCreatTime(new Date(System.currentTimeMillis()));
		u.setUserPassword("cyj123");
		u.setUserStuNo(201800001);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // 加密
		String encodedPassword = passwordEncoder.encode(u.getUserPassword().trim());
		u.setUserPassword(encodedPassword);
		u.setUserPsdWrongTime(0);
		u.setUserIsLookout("否");
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
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
	@RequestMapping(value = "/delUsers", name = "删除用户", method = RequestMethod.DELETE)
	public Object delUsers(String userId) {// 有待修订
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
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
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
		user.setUserPsdWrongTime(u.getUserPsdWrongTime());
		user.setUserId(u.getUserId());
		if (userService.addUser(user)) {
			return new Result(true, "用户修改成功");
		} else {
			return new Result(false, "用户名重复,请重新填写!");
		}
	}
	
	/**
	 * 修改用户锁定状态 http://localhost:3011/chenyongjia/ChenYongJia/user/lockUsers
	 * 
	 * @param u
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
	@RequestMapping(value = "/lockUsers", name = "锁定用户", method = RequestMethod.POST)
	public Object lockUsers(User u) {
		User user = userService.getUserById(u.getUserId());
		user.setUserIsLookout(u.getUserIsLookout());
		user.setUserPsdWrongTime(u.getUserPsdWrongTime());
		user.setUserId(u.getUserId());
		if (userService.addUser(user)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 重置密码 http://localhost:3011/chenyongjia/ChenYongJia/user/clearUsers
	 * 
	 * @param u
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
	@RequestMapping(value = "/clearUsers", name = "重置密码" ,method = RequestMethod.POST)
	public Object clearUsers(User u) {
		User user = userService.getUserById(u.getUserId());
		user.setUserName(u.getUserName());
		user.setUserPassword("cyj666");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // 加密
		String encodedPassword = passwordEncoder.encode(user.getUserPassword().trim());
		user.setUserPassword(encodedPassword);
		user.setUserId(u.getUserId());
		if (userService.addUser(user)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 查询用户未拥有的角色
	 * http://localhost:3011/chenyongjia/ChenYongJia/user/getRolesList 不带分页
	 * 
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
	@RequestMapping(value = "/getRolesList", name = "不分页查询角色", method = RequestMethod.GET)
	public Object getRolesList(Integer[] roleId,@RequestParam(value = "userId", required = false) Integer userId) {
		List<Integer> urRoles = userService.getUserRole(userId);
		System.out.println(urRoles);
		if (!IsEmptyUtils.isEmpty(urRoles)) {
			return rolesService.getRolesList(urRoles);
		} else {
			return rolesService.getRolesLists();
		}
	}
	
	/**
	 * 查询用户未拥有的角色
	 * http://localhost:3011/chenyongjia/ChenYongJia/user/getUserIdByToken?token=598b984a-f0c2-4771-bd99-3739fffacf3b 不带分页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getUserIdByToken", name = "通过token换取用户信息", method = RequestMethod.GET)
	public Object getUserIdByToken(@RequestParam(value="token") String token) {
		return myTokenService.findByTokenAcc(token);
	}
	
	/**
	 * 查询老师
	 * http://localhost:3011/chenyongjia/ChenYongJia/user/getByTeacher
	 * 
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
	@RequestMapping(value = "/getByTeacher", name = "查询老师", method = RequestMethod.GET)
	public Object getByTeacher(@RequestParam(value="collegeId") Integer collegeId,@RequestParam(value="p") Integer p,Integer page,Integer rows) {
		return userService.getByTeacher(collegeId,p,page,rows);
	}
	
	/**
	 * 修改老师专业绑定
	 * http://localhost:3011/chenyongjia/ChenYongJia/user/updateUser
	 * 
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
	@RequestMapping(value = "/updateUser", name = "修改老师专业绑定", method = RequestMethod.POST)
	public Object updateUser(@RequestParam(value="userId") Integer userId,@RequestParam(value="collegeId") Integer collegeId) {
		return userService.updateUser(userId,collegeId);
	}
	
	@RequestMapping(value="/getUserInfo",name="提供芈忠良获取所有用户信息",method=RequestMethod.GET)
	public List<User> getUserInfo(){
		return userService.getUserInfo();
	}
	
	/**
	 * 班级设置学生
	 * http://localhost:3011/chenyongjia/ChenYongJia/user/addUserClazz
	 * @param userId
	 * @param classId
	 * @param p
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
	@RequestMapping(value = "/addUserClazz", name = "为班级设置学生", method = RequestMethod.POST)
	public Object addUserClazz(@RequestParam(value="userId") Integer userId,@RequestParam(value="classId") Integer classId,@RequestParam(value="p") Integer p) {
		return userService.addUserClazz(userId, classId, p);
	}
	
}
