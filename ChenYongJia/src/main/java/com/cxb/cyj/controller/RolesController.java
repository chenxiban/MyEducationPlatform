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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.cyj.entity.Result;
import com.cxb.cyj.entity.Roles;
import com.cxb.cyj.entitysearch.RolesSearch;
import com.cxb.cyj.service.RolesService;
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

	/**
	 * 分页检索查询 http://localhost:3011/chenyongjia/ChenYongJia/roles/getAllPageRoles
	 * 
	 * @author WangChuanWei
	 * @param rolesSearch
	 * @return
	 */
	@RequestMapping(value = "/getAllPageRoles", name = "查询角色", method = RequestMethod.GET)
	public Object getAllPageRoles(RolesSearch rolesSearch) {
		// System.out.println("当前查询参数===>" + rolesSearch);
		Pageable pageable = PageRequest.of(rolesSearch.getPage() - 1, rolesSearch.getRows(), Sort.Direction.ASC,
				"roleId");
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
	 * 获取用户角色
	 * http://localhost:3011/chenyongjia/ChenYongJia/roles/getUserRolesByUserId
	 * 
	 * @author WangChuanWei
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getUserRolesByUserId", name = "获取用户角色", method = RequestMethod.GET)
	public Object getUserRolesByUserId(Integer id) {
		return rolesService.getUserRolesByUserId(id);
	}

	/**
	 * 添加角色
	 * http://localhost:3011/chenyongjia/ChenYongJia/roles/addRoles?rolesName=管理员
	 * 
	 * @author WangChuanWei
	 * @param r
	 * @return
	 */
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
	@RequestMapping(value = "/delRoles", name = "删除角色", method = RequestMethod.DELETE)
	public Object delRoles(String roleId) {
		List<String> list = new ArrayList<String>();
		String[] ids = roleId.split(",");
		for (String dids : ids) {
			list.add(dids);
		}
		System.out.println(list);
		if (rolesService.delRole(list)) {
			return new Result(true, "角色删除成功");
		} else {
			return new Result(false, "当前角色有用户正在使用,删除失败!");
		}
	}

	/**
	 * 修改角色 http://localhost:3011/chenyongjia/ChenYongJia/roles/updRoles
	 * 
	 * @author WangChuanWei
	 * @param u
	 * @return
	 */
	@RequestMapping(value = "/updRoles", name = "修改角色", method = RequestMethod.POST)
	public Object updRoles(Roles u) {
		Roles roles = rolesService.getRolesById(u.getRolesId());
		roles.setRolesName(u.getRolesName());
		roles.setRolesId(u.getRolesId());
		if (rolesService.addUser(roles)) {
			return new Result(true, "角色修改成功");
		} else {
			return new Result(false, "角色名重复,请重新填写!");
		}
	}

}
