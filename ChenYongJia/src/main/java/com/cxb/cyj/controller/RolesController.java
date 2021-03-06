package com.cxb.cyj.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.cyj.entity.Result;
import com.cxb.cyj.entity.Roles;
import com.cxb.cyj.entitysearch.RolesSearch;
import com.cxb.cyj.service.PermissionService;
import com.cxb.cyj.service.RolesService;
import com.cxb.cyj.service.UserService;
import com.cxb.cyj.util.IsEmptyUtils;

/**
 * 
 * @Description: 角色控制器
 * @ClassName: RolesController.java
 * @author WangChuanWei
 * @Date 2018年12月04日 下午20:40:56
 * @Email 867647213@qq.com
 */
@RestController
@RequestMapping(value = "/roles", name = "角色模块")
public class RolesController {

	@Autowired
	private RolesService rolesService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private PermissionService permissionService;
	/**
	 * 分页检索查询 http://localhost:3011/chenyongjia/ChenYongJia/roles/getAllPageRoles
	 * 
	 * @author WangChuanWei
	 * @param rolesSearch
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
	@RequestMapping(value = "/getAllPageRoles", name = "查询角色", method = RequestMethod.GET)
	public Object getAllPageRoles(RolesSearch rolesSearch) {
		// System.out.println("当前查询参数===>" + rolesSearch);
		Pageable pageable = PageRequest.of(rolesSearch.getPage() - 1, rolesSearch.getRows(), Sort.Direction.ASC,
				"rolesId");
		Page<Roles> page = rolesService.sreachByRoles(rolesSearch, pageable);
		Long total = page.getTotalElements();
		List<Roles> list = page.getContent();

		System.out.println("查询到的数据为=====>" + list);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 获取角色权限
	 * http://localhost:3011/chenyongjia/ChenYongJia/roles/getRolesPermissionByRoleId?roles_id=1
	 * @author WangChuanWei
	 * @param id
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
	@RequestMapping(value = "/getRolesPermissionByRoleId", name = "获取角色权限", method = RequestMethod.GET)
	public Object getRolesPermissionByRoleId(Integer id) {
		return rolesService.getRolesPermissionByRoleId(id);
	}

	/**
	 * 获取用户角色
	 * http://localhost:3011/chenyongjia/ChenYongJia/roles/getUserRolesByUserId
	 * 
	 * @author WangChuanWei
	 * @param id
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
	@RequestMapping(value = "/getUserRolesByUserId", name = "获取用户角色", method = RequestMethod.GET)
	public Object getUserRolesByUserId(Integer userId) {
		return rolesService.getUserRolesByUserId(userId);
	}

	/**
	 * 添加角色
	 * http://localhost:3011/chenyongjia/ChenYongJia/roles/addRoles?rolesName=666
	 * 
	 * @author WangChuanWei
	 * @param r
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
	@RequestMapping(value = "/addRoles", name = "添加角色", method = RequestMethod.PUT)
	public Object addRoles(Roles r) {
		r.setRolesCreatTime(new Date());
		Roles rlist = rolesService.getAllRoles(r.getRolesName());
		if (IsEmptyUtils.isEmpty(rlist)) {
			if (rolesService.addUser(r)) {
				return new Result(true, "角色添加成功");
			} else {
				return new Result(false, "角色添加失败");
			}
		} else {
			return new Result(false, "角色名重复,请重新填写");
		}
	}

	/**
	 * 删除角色 http://localhost:3011/chenyongjia/ChenYongJia/roles/delRoles
	 * 
	 * @author WangChuanWei
	 * @param roleId
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
	@RequestMapping(value = "/delRoles", name = "删除角色", method = RequestMethod.DELETE)
	public Object delRoles(@RequestParam(value="roleId") String roleId) {
		List<String> list = new ArrayList<String>();
		String[] ids = roleId.split(",");
		for (String dids : ids) {
			list.add(dids);
		}
		System.out.println(list);
		if (rolesService.delRole(list)) {
			return new Result(true, "角色删除成功");
		} else {
			return new Result(false, "当前角色有用户正在使用或拥有模块,删除失败!");
		}
	}

	/**
	 * 修改角色 http://localhost:3011/chenyongjia/ChenYongJia/roles/updRoles
	 * 
	 * @author WangChuanWei
	 * @param u
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
	@RequestMapping(value = "/updRoles", name = "修改角色", method = RequestMethod.POST)
	public Object updRoles(Roles u) {
		Roles roles = rolesService.getRolesById(u.getRolesId());
		roles.setRolesName(u.getRolesName());
		roles.setRolesEname(u.getRolesEname());
		roles.setRolesId(u.getRolesId());
		if (rolesService.addUser(roles)) {
			return new Result(true, "角色修改成功");
		} else {
			return new Result(false, "角色名重复,请重新填写!");
		}
	}
	
	/**
	 * 角色设置菜单模块
	 * http://localhost:3011/chenyongjia/ChenYongJia/roles/setRoleModule
	 * @author WangChuanWei
	 * @param roleId
	 * @param moduleId
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
	@RequestMapping(value = "/setRoleModule", name = "角色设置菜单模块",method = RequestMethod.POST)
	public Object setRoleModule(
			Integer roleId,
			@RequestParam(value = "moduleId", required = false) String moduleId) {
		String msg = null;
		System.out.println("移除当前角色权限====>"+rolesService.delRoleModule(roleId));
		String [] moduleIdss=moduleId.split(",");
		for (String moduleIds:moduleIdss) {
			int k = rolesService.setRoleModule(roleId, Integer.parseInt(moduleIds));
			msg = "角色roleId=>" + roleId + "->成功设置" + k + "个菜单模块.";
		}
		return new Result(true, msg);// 设置成功
	}
	
	/**
	 * 增加用户角色 http://localhost:3011/chenyongjia/ChenYongJia/roles/addByRole?userId=1&rolesId=2&usersId=1
	 * 
	 * @param roleId
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
	@RequestMapping(value = "/addByRole", name = "增加角色", method = RequestMethod.GET)
	public Object addByRole(Integer usersId, Integer rolesId, Integer userId) {
		if (rolesService.addByRole(rolesId, usersId)) {
			// 根据用户Id查询出该用户的所有权限
			List<String> permissionValueList = userService
					.queryPermissionValueByUserId(userId);
			List<Integer> urRoles = userService.getUserRole(userId);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("roleIds", urRoles);
			map.put("permission",permissionValueList);
			return new Result(true, map);
		} else {
			return new Result(false, "角色增加失败");
		}
	}
	
	/**
	 * 移除用户角色 http://localhost:3011/chenyongjia/ChenYongJia/roles/delRolesId?usersId=1&rolesId=3&userId=1
	 * 
	 * @param rolesId
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
	@RequestMapping(value = "/delRolesId", name = "移除角色", method = RequestMethod.DELETE)
	public Object delRolesId(Integer rolesId, Integer usersId, Integer userId) {
		if (rolesService.deleteByRoleId(rolesId, usersId)) {
			// 根据用户Id查询出该用户的所有权限
			List<Integer> urRoles = userService.getUserRole(userId);
			// 根据用户Id查询出该用户的所有权限
						List<String> permissionValueList = userService
								.queryPermissionValueByUserId(userId);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("roleIds", urRoles);
			map.put("permission",permissionValueList);
			if (rolesId==3) {// 如果移除的是老师
				userService.updateUser(usersId,21);
			}
			return new Result(true, "角色移除成功");
		} else {
			return new Result(false, "角色移除失败");
		}
	}
	
	/**
	 * 获取所有角色
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
	@RequestMapping(value="/getAllRoles",method=RequestMethod.GET)
	public List<Roles> getAllRoles(){
		return rolesService.findAll();
	}
	
	/**
	 * 角色设置权限 http://localhost:3011/chenyongjia/ChenYongJia/roles/setRolePermission
	 * 
	 * @author WangChuanWei
	 * @param roleId
	 * @param moduleId
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('ROLE_ALL')")
	@RequestMapping(value = "/setRolePermission", name = "角色设置操作权限", method = RequestMethod.POST)
	public Object setRolePermission(Integer roleId, String permissionIds, int id) {
		if (permissionService.deletePermission(roleId)) {
			List<Integer> list = new ArrayList<Integer>();
			String[] ids = permissionIds.split(",");
			for (int i = 0; i < ids.length; i++) {
				if (!IsEmptyUtils.isEmpty(ids[i])) {
					list.add(Integer.parseInt(ids[i]));
				}
			}
			System.out.println("list=>" + list);
			//String msg=null;
			boolean k;
			for (Integer permissionId2 : list) {
				k = permissionService.setRolePermission(roleId, permissionId2);
				//msg = "角色roleId=>" + roleId + "->成功设置" + k + "个操作权限.";
				if (!k) {
					return new Result(false, "设置失败");// 设置成功
				}
			}
			// 根据用户Id查询出该用户的所有权限
			List<String> permissionValueList = userService.queryPermissionValueByUserId(id);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("permission", permissionValueList);// 响应给客户端的当前用户权限
			return new Result(true, map);// 设置成功
		} else {
			return new Result(false, "设置失败");// 设置成功
		}
	}

}
