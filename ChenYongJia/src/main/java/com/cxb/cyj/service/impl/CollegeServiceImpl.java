package com.cxb.cyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.cyj.dao.CollegeRepository;
import com.cxb.cyj.entity.College;
import com.cxb.cyj.service.CollegeService;

/**
 * 
 * @Description:   机构业务实现类
 * @ClassName:     CollegeServiceImpl.java
 * @author         ChenYongJia
 * @Date           2018年12月04日 下午20:40:56
 * @Email          867647213@qq.com
 */
@Service
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	private CollegeRepository collegeRepository;

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

}
