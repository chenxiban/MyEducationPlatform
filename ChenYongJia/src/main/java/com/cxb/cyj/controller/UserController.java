package com.cxb.cyj.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.cyj.entity.User;
import com.cxb.cyj.entitysearch.UserSearch;
import com.cxb.cyj.service.UserService;

/**
 * 
 * @Description:   用户控制器
 * @ClassName:     UserController.java
 * @author         ChenYongJia
 * @Date           2018年12月04日 下午20:40:56
 * @Email          867647213@qq.com
 */
@RestController
@RequestMapping(value="/user",name="用户模块")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Value("${server.port}")
	private String serverPort;

	/**
	 * http://localhost:8002/getFuture
	 * @return
	 */
	@PreAuthorize(value="hasAuthority('user:getFuture')")	//等于 .antMatchers("/deleteOrder").hasAnyAuthority("deleteOrder")
	@RequestMapping(value="/getFuture",name="测试控制器方法")
	public List<String> getFuture() {
		List<String> list = new ArrayList<>();
		list.add("不积跬步，无以至千里；");
		list.add("不积小流，无以成江海。");
		list.add("出自端口号:"+serverPort);
		return list;
	}
	
	/**
	 * 分页检索查询 http://localhost:8080/SpringBootJpaTows/users/getAllPageUsers
	 * @author ChenYongJia
	 * @param userSearch
	 * @return
	 */
	@PreAuthorize(value="hasAuthority('user:getAllPageUsers')")
	@RequestMapping(value = "/getAllPageUsers", name = "查询用户")
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

}
