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
	 * 查询所有Organization
	 * @return
	 */
	public List<Organization> queryAll(String organizationSchool);
	
}
