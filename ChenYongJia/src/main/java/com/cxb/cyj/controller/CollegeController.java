package com.cxb.cyj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.cyj.service.CollegeService;

/**
 * 
 * @Description: 登录控制器
 * @ClassName: UserController.java
 * @author ChenYongJia
 * @Date 2018年12月04日 下午20:40:56
 * @Email 867647213@qq.com
 */
@RestController
@RequestMapping(value="/college",name="机构设置管理")
public class CollegeController {
	
	@Autowired
	private CollegeService collegeService;
	
	/**
	 * 查询机构http://localhost:3011/chenyongjia/ChenYongJia/college/getCollege
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@RequestMapping(value = "/getCollege", name = "查询机构", method = RequestMethod.GET)
	public Object getCollege() {
		return collegeService.showColleges();
	}
	
}
