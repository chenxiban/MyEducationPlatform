package com.cxb.cyj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.cyj.dao.UsersRepository;
import com.cxb.cyj.entity.User;
import com.cxb.cyj.service.UserService;

/**
 * 
 * @Description:   用户业务实现类
 * @ClassName:     UserServiceImpl.java
 * @author         ChenYongJia
 * @Date           2018年12月04日 下午20:40:56
 * @Email          867647213@qq.com
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepository usersRepository;
	
	/**
	 * 根据姓名查询
	 * 
	 * @param usersName
	 * @return
	 */
	@Override
	public User findsLoginName(String userName) {
		return usersRepository.findByUserName(userName);
	}
	
}
