package com.cxb.cyj.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.cyj.entity.College;
import com.cxb.cyj.entity.Organization;
import com.cxb.cyj.entity.Result;
import com.cxb.cyj.service.CollegeService;
import com.cxb.cyj.service.OrganizationService;
import com.cxb.cyj.util.IsEmptyUtils;

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
	
	@Autowired
	private CollegeService collegeService;
	
	/**
	 * 查询机构http://localhost:3011/chenyongjia/ChenYongJia/organization/queryAllOrganization
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
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
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
	@RequestMapping(value = "/getAllOrganization", name = "查询所有机构", method = RequestMethod.GET)
	public Object getAllOrganization() {
		return organizationService.getAll();
	}
	
	/**
	 * 删除机构http://localhost:3011/chenyongjia/ChenYongJia/organization/delOrganization
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
	@RequestMapping(value = "/delOrganization", name = "删除机构", method = RequestMethod.DELETE)
	public Object delOrganization(Integer organizationId) {
		Organization organization=new Organization();
		organization.setOrganizationId(organizationId);
		List<College> list=collegeService.getAllChildren(organization);
		if (!IsEmptyUtils.isEmpty(list)) {
			return new Result(false,"其拥有或学院/院系/专业，机构删除失败！");
		}else if (organizationService.delOrganization(organizationId)) {
			return new Result(true,"机构删除成功！");
		} else {
			return new Result(false,"机构删除失败！");
		}
		
	}
	
	/**
	 * 添加机构 http://localhost:3011/chenyongjia/ChenYongJia/organization/saveOrganization
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
	@RequestMapping(value = "/saveOrganization", name = "添加机构信息", method = RequestMethod.POST)
	public Object saveOrganization(@RequestBody Organization organization) {
		organization.setOrganizationCreatTime(new Date());
		if (organizationService.saveOrganization(organization)) {
			return new Result(true,"机构添加成功！");
		} else {
			return new Result(false,"机构添加失败，机构名称重复！");
		}
	}
	
	/**
	 * 修改机构 http://localhost:3011/chenyongjia/ChenYongJia/organization/updOrganization
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
	@RequestMapping(value = "/updOrganization", name = "修改机构信息", method = RequestMethod.POST)
	public Object updOrganization(@RequestBody Organization organization) {
		Organization organizations=organizationService.getById(organization.getOrganizationId());
		
		if (!IsEmptyUtils.isEmpty(organization.getOrganizationSchool())) {
			organizations.setOrganizationSchool(organization.getOrganizationSchool());
		}
		if (!IsEmptyUtils.isEmpty(organization.getOrganizationHead())) {
			organizations.setOrganizationHead(organization.getOrganizationHead());
		}
		if (!IsEmptyUtils.isEmpty(organization.getOrganizationMtel())) {
			organizations.setOrganizationMtel(organization.getOrganizationMtel());
		}
		if (!IsEmptyUtils.isEmpty(organization.getOrganizationAddress())) {
			organizations.setOrganizationAddress(organization.getOrganizationAddress());
		}
		if (!IsEmptyUtils.isEmpty(organization.getOrganizationAbstract())) {
			organizations.setOrganizationAbstract(organization.getOrganizationAbstract());
		}
		
		if (organizationService.saveOrganization(organizations)) {
			return new Result(true,"机构修改成功！");
		} else {
			return new Result(false,"机构修改失败，机构名称重复！");
		}
	}
	
}
