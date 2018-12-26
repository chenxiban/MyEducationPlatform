package com.cxb.cyj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cxb.cyj.entity.Organization;

/**
 * 
 * @Description:   机构业务类
 * @ClassName:     OrganizationService.java
 * @author         ChenYongJia
 * @Date           2018年12月04日 下午20:40:56
 * @Email          867647213@qq.com
 */
@Service
public interface OrganizationService {
	
	/**
	 * 根据organizationSchool查询Organization
	 * @return
	 */
	List<Organization> queryAll(String organizationSchool);
	
	/**
	 * 查询所有Organization
	 * @return
	 */
	List<Organization> getAll();
	
	/**
	 * 根据机构id删除机构
	 * @param organizationId
	 * @return
	 */
	boolean delOrganization(Integer organizationId);
	
	/**
	 * 添加机构信息
	 * @param organization
	 * @return
	 */
	boolean saveOrganization(Organization organization);
	
	/**
	 * 修改机构信息
	 * @param organization
	 * @return
	 */
	boolean updOrganization(Organization organization);
	
	/**
	 * 根据机构id查询
	 * @param organizationId
	 * @return
	 */
	Organization getById(Integer organizationId);
	
}
