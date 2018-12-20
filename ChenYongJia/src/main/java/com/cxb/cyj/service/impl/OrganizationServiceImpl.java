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
	
}
