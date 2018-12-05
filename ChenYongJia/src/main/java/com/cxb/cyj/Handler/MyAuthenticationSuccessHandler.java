package com.cxb.cyj.Handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * 
 * @Description:身份验证成功的处理程序
 * @ClassName: MyAuthenticationSuccessHandler.java
 * @author ChenYongJia
 * @Date 2018年12月02日 晚上22：54
 * @Email chen87647213@163.com
 */
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	// 用户认证成功
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth)
			throws IOException, ServletException {
		System.out.println("用户登陆成功");
		res.sendRedirect("about");
	}

}
