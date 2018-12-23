package com.cxb.cyj.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.cxb.cyj.dao.RolesRepository;
import com.cxb.cyj.entity.Permission;
import com.cxb.cyj.entity.Roles;
import com.cxb.cyj.entitysearch.RolesSearch;
import com.cxb.cyj.service.RolesService;
import com.cxb.cyj.util.IsEmptyUtils;

@Service
public class RolesServiceImpl implements RolesService {
	
	@Autowired
	private RolesRepository rolesRepository;
	
	/**
	 * 分页动态查询
	 */
	@Override
	public Page<Roles> sreachByRoles(RolesSearch rolesSearch, Pageable pageable) {
		return rolesRepository.findAll(this.getWhereClause(rolesSearch), pageable);
	}

	/**
	 * 根据名字查询
	 */
	@Override
	public Roles getAllRoles(String name) {
		// TODO Auto-generated method stub
		return rolesRepository.getAllRoles(name);
	}

	/**
	 * 根据id获取用户表未被设置的角色信息
	 */
	@Override
	public List<Roles> getRolesList(List<Integer> ids) {
		// TODO Auto-generated method stub
		return rolesRepository.getRolesList(ids);
	}

	/**
	 * 获取所有角色信息
	 */
	@Override
	public List<Roles> getRolesLists() {
		// TODO Auto-generated method stub
		return rolesRepository.findAll();
	}
	
	/**
	 * 根据角色id查询该角色拥有的权限
	 */
	@Override
	public List<Permission> getRolesPermissionByRoleId(Integer id) {
		// TODO Auto-generated method stub
		return rolesRepository.getRolesPermission(id);
	}

	/**
	 * 根据用户id查询该用户拥有的角色
	 */
	@Override
	public List<Roles> getUserRolesByUserId(Integer id) {
		// TODO Auto-generated method stub
		return rolesRepository.getUserRolesByUserId(id);
	}

	/**
	 * 添加角色信息
	 */
	@Override
	public boolean addUser(Roles r) {
		// TODO Auto-generated method stub
		try {
			rolesRepository.save(r);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 移除角色信息
	 */
	@Override
	public boolean delRole(List<String> stuList) {
		// TODO Auto-generated method stub
		try {
			rolesRepository.deleteBatch(stuList);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 根据id查询
	 */
	@Override
	public Roles getRolesById(Integer rid) {
		return rolesRepository.getOne(rid);
	}

	/**
	 * 删除角色
	 */
	@Override
	public boolean deleteByRoleId(Integer stuList, Integer userId) {
		// TODO Auto-generated method stub
		try {
			rolesRepository.deleteByRoleId(stuList,userId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 添加角色
	 */
	@Override
	public boolean addByRole(Integer roleId, Integer userId) {
		// TODO Auto-generated method stub
		return rolesRepository.addByRole(roleId, userId) > 0 ? true : false;
	}
	
	/**
	 * 查询条件动态组装 动态生成where语句 匿名内部类形式
	 * 
	 * @param us
	 * @return
	 */
	@SuppressWarnings({ "serial" })
	private Specification<Roles> getWhereClause(final RolesSearch rs) {
		return new Specification<Roles>() {

			@Override
			public Predicate toPredicate(Root<Roles> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();// 动态SQL表达式
				List<Expression<Boolean>> exList = predicate.getExpressions();// 动态SQL表达式集合
				if (!IsEmptyUtils.isEmpty(rs.getName())) {
					exList.add(cb.like(root.<String>get("rolesName"), "%" + rs.getName() + "%"));
				}
				/*if (!IsEmptyUtils.isEmpty(rs.getName())) {
					exList.add(cb.like(root.<String>get("rolesName"), "%" + rs.getName() + "%"));
				}*/
				return predicate;
			}

		};
	}

	/**
	 * 设置模块
	 */
	@Override
	public Integer setRoleModule(Integer roleId, Integer moduleIds) {
		return rolesRepository.setRoleModule(roleId, moduleIds);
	}

	/**
	 * 根据roleId删除模块
	 */
	@Override
	public boolean delRoleModule(Integer roleId) {
		try {
			rolesRepository.delRoleModule(roleId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
