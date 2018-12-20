package com.cxb.cyj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cxb.cyj.entity.Permission;

/**
 * 
 * @Description:   权限业务类
 * @ClassName:     PermissionService.java
 * @author         ChenYongJia
 * @Date           2018年12月04日 下午20:40:56
 * @Email          867647213@qq.com
 */
@Service
public interface PermissionService {
	
	/**
	 * 查询所有权限集合
	 * @return 权限字符串集合
	 * @author Chenyongjia
	 */
	List<String> queryAll();
	
	/**
	 * 查询所有权限集合
	 * @return 权限字符串集合
	 * @author Chenyongjia
	 */
	List<Permission> queryNode();
	
	/**
	 * 批量插入权限数据
	 * @param pList
	 * @return 成功插入的权限数据条数
	 * @author Chenyongjia
	 */
	Integer batchInsert(List<Permission> pList);
	
	/**
	 * 用于查询孩子节点
	 * @param permissionModule
	 * @author Chenyongjia
	 * @return
	 */
	List<Permission> findsByPermissionModules(String permissionModule);
	
}
