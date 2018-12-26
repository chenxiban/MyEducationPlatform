package com.cxb.cyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.cyj.dao.CollegeRepository;
import com.cxb.cyj.dao.OrganizationRepository;
import com.cxb.cyj.entity.College;
import com.cxb.cyj.entity.Organization;
import com.cxb.cyj.service.CollegeService;

/**
 * 
 * @Description: 机构业务实现类
 * @ClassName: CollegeServiceImpl.java
 * @author ChenYongJia
 * @Date 2018年12月04日 下午20:40:56
 * @Email 867647213@qq.com
 */
@Service
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	private CollegeRepository collegeRepository;

	@Autowired
	private OrganizationRepository organizationRepository;

	@Override
	public List<College> showColleges() {
		// 查询出所有根菜单
		List<College> rootList = collegeRepository.queryChildren(0);
		// 递归设置子菜单
		this.setChildrens(rootList);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^最终得到的机构列表=>" + rootList);
		return rootList;
	}

	/**
	 * 给菜单设置子菜单
	 * 
	 * @param parentList
	 */
	private void setChildrens(List<College> parentList) {
		for (College m : parentList) {
			// 查询出子菜单
			List<College> childrenList = this.queryChildren(m.getCollegeId());
			System.out.println("*****************************************************设置子菜单=>" + m.getCollegeName());
			// 如果没有子菜单则递归结束
			if (childrenList != null && !childrenList.isEmpty()) {// 有子菜单
				// 设置子菜单
				System.out.println("设置的子菜单是=>" + childrenList);
				m.setChildren(childrenList);
				// 如果有子菜单则继续递归设置子菜单
				this.setChildrens(childrenList);
			}
		}
	}

	/**
	 * 查询孩子菜单
	 */
	@Override
	public List<College> queryChildren(Integer parentId) {
		return collegeRepository.queryChildren(parentId);
	}

	/**
	 * 添加机构信息
	 * 
	 * @param c
	 * @return
	 */
	@Override
	public boolean addCollege(College c, Integer oid) {
		try {
			Organization organization = organizationRepository.getOne(oid);
			c.setOrganization(organization);
			System.out.println("查询到的机构为==========>" + organization);
			collegeRepository.save(c);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * 修改机构信息
	 * 
	 * @param c
	 * @return
	 */
	@Override
	public boolean updateCollege(College c, Integer oid) {
		try {
			Organization organization = organizationRepository.getOne(oid);
			c.setOrganization(organization);
			System.out.println("查询到的机构为==========>" + organization);
			collegeRepository.save(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 根据id查询信息
	 * 
	 * @param collegeId
	 * @return
	 */
	@Override
	public College getById(Integer collegeId) {
		return collegeRepository.getOne(collegeId);
	}

	/**
	 * 根据collegeRmark=2查询
	 * 
	 * @param collegeRmark
	 * @return
	 * @author Chenyongjia
	 */
	@Override
	public List<College> findByCollegeRmark(Integer collegeRmark) {
		return collegeRepository.findByCollegeRmark(collegeRmark);
	}

	/**
	 * 查询全部
	 * @return
	 */
	@Override
	public List<College> getAllChildren(Organization organization) {
		return collegeRepository.findByOrganization(organization);
	}
	
	@Override
	public boolean delCollge(List<String> id) {
		try {
			collegeRepository.deleteBatch(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Integer> getChildrenByParentId(List<String> parentId) {
		return collegeRepository.getChildrenByParentId(parentId);
	}

	@Override
	public List<Integer> getChildrenByParentIds(List<String> parentId) {
		return collegeRepository.getChildrenByParentIds(parentId);
	}

}
