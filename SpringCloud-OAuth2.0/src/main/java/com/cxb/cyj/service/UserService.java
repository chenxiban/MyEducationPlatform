package com.cxb.cyj.service;

import org.springframework.stereotype.Service;

import com.cxb.cyj.entity.User;

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
	 * 根据姓名查询
	 * 
	 * @param usersName
	 * @return
	 */
	User findsLoginName(String userName);
	
}
