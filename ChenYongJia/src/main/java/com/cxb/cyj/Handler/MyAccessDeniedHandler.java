package com.cxb.cyj.Handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// handle 403 page
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
	//记住用户登录失败的信息,或添加如登录失败三次就需要有验证码等功能, 防止暴力破解用户信息.
	private static Logger logger = LoggerFactory.getLogger(MyAccessDeniedHandler.class);

	@Override
	public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			AccessDeniedException e) throws IOException, ServletException {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null) {
			logger.info("User '" + auth.getName() + "' attempted to access the protected URL: "
					+ httpServletRequest.getRequestURI());
		}

		httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/403");

	}
}
