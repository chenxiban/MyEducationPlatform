package com.cxb.cyj.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.cyj.dao.PermissionRepository;
import com.cxb.cyj.entity.Permission;
import com.cxb.cyj.service.PermissionService;

/**
 * 
 * @Description:   权限业务实现类
 * @ClassName:     PermissionServiceImpl.java
 * @author         ChenYongJia
 * @Date           2018年12月04日 下午20:40:56
 * @Email          867647213@qq.com
 */
@Service
public class PermissionServiceImpl implements PermissionService {
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	/**
	 * 查询所有权限集合
	 * @return 权限字符串集合
	 * @author Chenyongjia
	 */
	@Override
	public List<String> queryAll() {
		List<String> pList=new ArrayList<String>();
		List<Permission> list=permissionRepository.findAll();
		for (int i = 0; i < list.size(); i++) {
			pList.add(list.get(i).getPermissionValue());
		}
		return pList;
	}

	/**
	 * 批量插入权限数据
	 * @param pList
	 * @return 成功插入的权限数据条数
	 * @author Chenyongjia
	 */
	@Override
	public Integer batchInsert(List<Permission> pList) {
		Integer num=0;
		for (int i = 0; i < pList.size(); i++) {
			Permission entity=pList.get(i);
			if (permissionRepository.save(entity) != null) {
				num+=1;
			} 
		}
		return num;
	}

	/**
	 * 查询所有权限集合
	 * @return 权限字符串集合
	 * @author Chenyongjia
	 */
	@Override
	public List<Permission> queryNode() {
		List<Permission> permissionTree = permissionRepository.findsBy();// 查询出所有的权限树
		List<Permission> nodes=new ArrayList<Permission>();
		System.out.println("nodes.size()的长度=====>"+nodes.size());
		for (int i = 0; i < permissionTree.size(); i++) {
			Permission node=new Permission();
			System.out.println("Permission对象为===>"+node);
			node.setText(permissionTree.get(i).getPermissionModule());
			// 为node对象设置children属性
			node.setChildren(this.findsByPermissionModules(permissionTree.get(i).getPermissionModule()));
			System.out.println("查到的Children属性为====>"+node.getChildren());
			System.out.println("node对象为===>"+node);// 错误在这里
			nodes.add(node);
		}
		System.out.println("nodes集合为===>"+nodes);
		return nodes;
	}
	
	/**
	 * 用于查询孩子节点
	 * @param permissionModule
	 * @author Chenyongjia
	 * @return
	 */
	@Override
	public List<Permission> findsByPermissionModules(String permissionModule) {
		List<Permission>  objectsList = permissionRepository.findsByPermissionModule(permissionModule);
		for (int i = 0; i < objectsList.size(); i++) {
			objectsList.get(i).setId(objectsList.get(i).getPermissionId());
			objectsList.get(i).setText(objectsList.get(i).getPermissionName());
			objectsList.get(i).setPermissionLastUpdateTime(objectsList.get(i).getPermissionLastUpdateTime());
		}
		System.out.println("查询孩子节点=======================>"+objectsList);
		return objectsList;
	}

	
	/**
	 * 根据角色Ids查询出角色设置的权限树
	 */
	@Override
	public List<Permission> queryRoleSetPermission(List<Integer> roleId) {
		List<Integer> permissionIds = permissionRepository.queryPermissionIdsByRoleIds(roleId);// 查询出角色拥有的权限Ids
		List<Permission> permissionTree = permissionRepository.findsBy();// 查询出所有的权限树
		List<Permission> nodes = new ArrayList<Permission>();
		for (int i = 0; i < permissionTree.size(); i++) {
			Permission node = new Permission();
			System.out.println("Permission对象为===>" + node);
			node.setText(permissionTree.get(i).getPermissionModule());
			// 为node对象设置children属性
			node.setChildren(this.findsByPermissionModules(permissionTree.get(i).getPermissionModule()));
			System.out.println("查到的Children属性为====>" + node.getChildren());
			System.out.println("node对象为===>" + node);// 错误在这里
			nodes.add(node);
		}
		System.out.println("nodes集合为===>" + nodes);

		// 把角色拥有的权限树设置为选中
		this.setPermissionTreeChecked(nodes, permissionIds);
		return nodes;
	}

	/**
	 * 把角色拥有的权限树设置为选中
	 * 
	 * @param permissionTree
	 * @param permissionIds
	 */
	private void setPermissionTreeChecked(List<Permission> permissionTree, List<Integer> permissionIds) {
		for (Permission module : permissionTree) {// 遍历出所有权限所属模块
			System.out.println("module=============>" + module);
			for (Permission p : module.getChildren()) {// 遍历出所有权限节点
				System.out.println("module.getChildren()==========>" + module.getChildren());
				if (permissionIds.contains(p.getId())) {
					p.setChecked(true);// 角色拥有的权限勾选中
				}
			}

		}
	}
	
	
	@Override
	public List<String> queryPermissionValueByUserId(Integer userId) {
		return null;
	}

	@Override
	public boolean deletePermission(Integer roleId) {
		try {
			permissionRepository.deletePermission(roleId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean setRolePermission(Integer roleId, Integer permissionIds) {
		try {
			permissionRepository.setRolePermission(roleId, permissionIds);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
