package com.cxb.cyj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cxb.cyj.entity.User;
import com.cxb.cyj.service.UserService;
import com.cxb.cyj.util.IsEmptyUtils;

/**
 * 
 * @Description: 自定义用户权限认证
 * @ClassName: MyUserDetailsService.java
 * @author Chenyongjia
 * @Date 2018年12月4日 上午11.23
 * @Email 867647213@qq.com
 */
@Service
public class CustomUserServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("收到的账号"+username);
        User users=userService.findsLoginName(username);
        if(IsEmptyUtils.isEmpty(users)){
        	throw new UsernameNotFoundException("Login account does not exist!!!");
        } 
        System.out.println("用户为:" + users.getUsersName() + ";密码为:" + users.getUsersPassword());
        return users;
	}

}
