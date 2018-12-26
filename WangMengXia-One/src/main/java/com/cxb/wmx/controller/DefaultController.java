package com.cxb.wmx.controller;


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
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/ho_mian
	 * @return
	 */
	
	@GetMapping("/ho_mian")
	public String admin() {
		return "ho_mian";
	}
	@GetMapping("/ho_dispostcommit")
	public String dispostcommit() {
		return "ho_dispostcommit";
	}
	@GetMapping("/ho_dispostdlike")
	public String dispostdlike() {
		return "ho_dispostdlike";
	}
	@GetMapping("/ho_dispostlike")
	public String dispostlike() {
		return "ho_dispostlike";
	}

}
