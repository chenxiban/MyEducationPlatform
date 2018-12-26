package com.cxb.cyj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cxb.cyj.entity.Organization;

/**
 * 
 * @Description: 机构Dao接口
 * @ClassName: OrganizationRepository.java
 * @author Chenyongjia
 * @Date 2018年11月12日 下午22:01
 * @Email 867647213@qq.com
 */
public interface OrganizationRepository extends JpaRepository<Organization, Integer>, JpaSpecificationExecutor<Organization> {

	/**
	 * 根据机构名查询
	 * 
	 * @param organizationSchool
	 * @return
	 * @author Chenyongjia
	 */
	List<Organization> findByOrganizationSchoolContaining(String organizationSchool);
	
	/**
	 * 根据机构id查询
	 * @param organizationId
	 * @return
	 */
	Organization findByOrganizationId(Integer organizationId);
}
