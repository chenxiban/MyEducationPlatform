package com.cxb.wmx.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * @Description:   默认控制器
 * @ClassName:     DefaultController.java
 */
@Controller
public class DefaultController {

	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/
	 * @return
	 */
	@GetMapping("/ho_login")
	public String login() {
		return "ho_login";
	}
	
	@GetMapping("/ho_main")
	public String admin() {
		return "ho_main";
	}
	@GetMapping("/qian_barpost")
	public String barpost() {
		return "qian_barpost";
	}
	@GetMapping("/qian_fabiao")
	public String fabiao() {
		return "qian_fabiao";
	}
	@GetMapping("/qian_nopost")
	public String nopost() {
		return "qian_nopost";
	}
	@GetMapping("/qian_postinfo")
	public String postinfo() {
		return "qian_postinfo";
	}
	@GetMapping("/qian_user")
	public String user() {
		return "qian_user";
	}
	@GetMapping("/qian_main")
	public String main() {
		return "qian_main";
	}

}
