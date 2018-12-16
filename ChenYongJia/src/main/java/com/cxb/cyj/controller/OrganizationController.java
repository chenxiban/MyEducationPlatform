package com.cxb.cyj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.cyj.service.OrganizationService;

/**
 * 
 * @Description: 登录控制器
 * @ClassName: UserController.java
 * @author ChenYongJia
 * @Date 2018年12月04日 下午20:40:56
 * @Email 867647213@qq.com
 */
@RestController
@RequestMapping(value = "/organization", name = "机构管理")
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationService;
	
	/**
	 * 查询模块http://localhost:3011/chenyongjia/ChenYongJia/organization/queryAllOrganization
	 * 
	 * @author WangChuanWei
	 * @return
	 */
	@RequestMapping(value = "/queryAllOrganization", name = "查询机构", method = RequestMethod.GET)
	public Object queryAllOrganization(String organizationSchool) {
		return organizationService.queryAll(organizationSchool);
	}
	
}
