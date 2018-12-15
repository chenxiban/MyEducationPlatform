package com.cxb.cyj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cxb.cyj.entity.College;

/**
 * 
 * @Description:   机构业务类
 * @ClassName:     CollegeService.java
 * @author         ChenYongJia
 * @Date           2018年12月04日 下午20:40:56
 * @Email          867647213@qq.com
 */
@Service
public interface CollegeService {
	
	/**
	 * 显示所有机构
	 * @return
	 */
	public List<College> showColleges(); 
	
	/**
	 * 查询孩子菜单
	 */
	public List<College> queryChildren(Integer parentId);
	
}
