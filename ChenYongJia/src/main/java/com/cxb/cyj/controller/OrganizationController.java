package com.cxb.cyj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.cyj.service.OrganizationService;

/**
 * 
 * @Description: 机构控制器
 * @ClassName: OrganizationController.java
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
	 * 查询机构http://localhost:3011/chenyongjia/ChenYongJia/organization/queryAllOrganization
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@RequestMapping(value = "/queryAllOrganization", name = "查询机构", method = RequestMethod.GET)
	public Object queryAllOrganization(String organizationSchool) {
		return organizationService.queryAll(organizationSchool);
	}
	
	/**
	 * 查询所有机构http://localhost:3011/chenyongjia/ChenYongJia/organization/getAllOrganization
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@RequestMapping(value = "/getAllOrganization", name = "查询所有机构", method = RequestMethod.GET)
	public Object getAllOrganization() {
		return organizationService.getAll();
	}
	
}
