package com.cxb.cyj.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cxb.cyj.entity.User;
import com.cxb.cyj.entitysearch.UserSearch;

/**
 * 
 * @Description:   用户业务类
 * @ClassName:     UserService.java
 * @author         ChenYongJia
 * @Date           2018年12月04日 下午20:40:56
 * @Email          867647213@qq.com
 */
@Service
public interface UserService {
	
	/**
	 * 多条件分页检索查询
	 * @param userName
	 * @param userIsLookout
	 * @param birthStart
	 * @param birthEnd
	 * @param email
	 * @param mtel
	 * @param page
	 * @param rows
	 * @return
	 */
	public Page<User> sreachByUser(UserSearch userSearch, Pageable pageable);
	
	/**
	 * 根据姓名查询
	 * 
	 * @param usersName
	 * @return
	 */
	User findsLoginName(String usersName);
	
}
