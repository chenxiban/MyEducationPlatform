package com.cxb.cyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.cyj.dao.OrganizationRepository;
import com.cxb.cyj.entity.Organization;
import com.cxb.cyj.service.OrganizationService;

/**
 * 
 * @Description:   机构业务实现类
 * @ClassName:     OrganizationServiceImpl.java
 * @author         ChenYongJia
 * @Date           2018年12月09日 下午9:38:05
 * @Email          867647213@qq.com
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;
	
	/**
	 * 根据organizationSchool查询Organization
	 * @return
	 */
	@Override
	public List<Organization> queryAll(String organizationSchool) {
		return organizationRepository.findByOrganizationSchoolContaining(organizationSchool);
	}

	/**
	 * 查询所有Organization
	 * @return
	 */
	@Override
	public List<Organization> getAll() {
		return organizationRepository.findAll();
	}

	/**
	 * 根据机构id删除机构
	 * @param organizationId
	 * @return
	 */
	@Override
	public boolean delOrganization(Integer organizationId) {
		try {
			organizationRepository.deleteById(organizationId);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	/**
	 * 添加机构信息
	 * @param organization
	 * @return
	 */
	@Override
	public boolean saveOrganization(Organization organization) {
		try {
			organizationRepository.save(organization);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 修改机构信息
	 * @param organization
	 * @return
	 */

	@Override
	public boolean updOrganization(Organization organization) {
		try {
			organizationRepository.save(organization);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 根据机构id查询
	 * @param organizationId
	 * @return
	 */
	@Override
	public Organization getById(Integer organizationId) {
		return organizationRepository.findByOrganizationId(organizationId);
	}
	
}
