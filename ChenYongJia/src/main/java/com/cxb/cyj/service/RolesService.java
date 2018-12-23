package com.cxb.cyj.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cxb.cyj.entity.Permission;
import com.cxb.cyj.entity.Roles;
import com.cxb.cyj.entitysearch.RolesSearch;


@Service
public interface RolesService {
	
	/**
	 * 多条件分页检索查询
	 * @param rolesSearch
	 * @param pageable
	 * @return
	 */
	Page<Roles> sreachByRoles(RolesSearch rolesSearch, Pageable pageable);
	
	/**
	 * 根据name查询
	 * @param u
	 * @return
	 */
	Roles getAllRoles(String name);
	
	/**
	 * 根据角色id查询角色拥有的权限
	 * 
	 * @param id
	 * @return
	 */
	List<Permission> getRolesPermissionByRoleId(Integer id);
	
	/**
	 * 根据id获取用户表未被设置的角色信息
	 * @param ids
	 * @return
	 */
	List<Roles> getRolesList(List<Integer> ids);
	
	/**
	 * 获取所有用户信息
	 * @return
	 */
	List<Roles> getRolesLists();
	
	/**
	 * 根据用户id查询该用户拥有的角色
	 * @param id
	 * @return
	 */
	List<Roles> getUserRolesByUserId(Integer id);
	
	/**
	 * 添加角色信息
	 * 
	 * @param u
	 * @return
	 */
	boolean addUser(Roles r);

	/**
	 * 删除角色信息
	 * 
	 * @param id
	 * @return
	 */
	boolean delRole(List<String> stuList);
	
	/**
	 * 根据id查询
	 * @param rid
	 * @return
	 */
	Roles getRolesById(Integer rid);
	
	/**
	 * 删除角色
	 * @param stuList
	 * @return
	 */
	boolean deleteByRoleId(Integer stuList,Integer usersId);
	
	/**
	 * 增加用户角色
	 * @param rolesId
	 * @param usersId
	 * @return
	 */
	boolean addByRole(Integer rolesId,Integer usersId);
	
	/**
	 * 设置模块
	 * @param roleId
	 * @param moduleIds
	 * @return
	 */
	Integer setRoleModule(Integer roleId,Integer moduleIds);
	
	/**
	 * 根据roleId删除模块
	 * @param roleId
	 * @return
	 */
	boolean delRoleModule(Integer roleId);
	
	/**
	 * 查询所有
	 * @return
	 */
	List<Roles> findAll();
	
}
