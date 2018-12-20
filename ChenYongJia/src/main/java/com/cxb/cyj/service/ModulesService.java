package com.cxb.cyj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cxb.cyj.entity.Modules;

/**
 * 
 * @Description:   模块业务类
 * @ClassName:     ModulesService.java
 * @author         ChenYongJia
 * @Date           2018年12月04日 下午20:40:56
 * @Email          867647213@qq.com
 */
@Service
public interface ModulesService {
	
	/**
	 * 显示所有菜单
	 * @return
	 */
	List<Modules> showModules(); 
	
	/**
	 * 根据角色id查询拥有的模块
	 * @param roles
	 * @return
	 */
	List<Modules> getModulesRoles(List<Integer> roles);
	
	/**
	 * 根据id查询子菜单
	 * 
	 * @param id
	 * @param moduleId
	 * @return
	 */
	List<Modules> queryChildrenById(int id, List<Integer> moduleId);
	
	/**
	 * 根据根节点查询
	 * @param parentId
	 * @return
	 */
	List<Modules> queryChildren(Integer parentId);
	
	/**
	 * 添加模块
	 * @param m
	 * @return
	 */
	boolean addModules(Modules m);
	
	/**
	 * 修改模块
	 * @param m
	 * @return
	 */
	boolean updModules(Modules m);
	
	/**
	 * 根据id查询模块
	 * @param parentId
	 * @return
	 */
	Modules getById(Integer id);
	
	/**
	 * 批量删除模块
	 * @param id
	 * @return
	 */
	boolean delModules(List<String> id); 
	
	/**
	 * 根据父id查询子菜单
	 * @param parentId
	 * @return
	 */
	List<String> getChildrenByParentId(List<String> parentId);
	
	/**
	 * 根据父id查询孙子菜单
	 * @param parentId
	 * @return
	 */
	List<String> getChildrenByParentIds(List<String> parentId); 
	
	/**
	 * 根据roleId查询模块
	 * @param roleId
	 * @return
	 */
	List<Modules> queryRoleSetModuleTree(List<Integer> roleId);
	
}
