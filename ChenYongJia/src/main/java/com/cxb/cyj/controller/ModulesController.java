package com.cxb.cyj.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.cyj.entity.Modules;
import com.cxb.cyj.entity.Result;
import com.cxb.cyj.service.ModulesService;
import com.cxb.cyj.util.IsEmptyUtils;

@RestController
@RequestMapping(value = "/modules", name = "菜单模块")
public class ModulesController {

	@Autowired
	private ModulesService modulesService;

	/**
	 * 查询左侧菜单树 MenuTree
	 * http://localhost:3011/chenyongjia/ChenYongJia/modules/queryMenuTree
	 * 
	 * @author WangChuanWei
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/queryMenuTree", name = "查询左侧菜单树", method = RequestMethod.GET)
	public Object queryModuleTree(Integer[] roleId) {
		List<Integer> roleIds = new ArrayList<Integer>();
		for (int i = 0; i < roleId.length; i++) {
			roleIds.add(roleId[i]);
		}
		System.out.println("roleId=>" + roleIds);
		return modulesService.getModulesRoles(roleIds);
	}

	/**
	 * 查询模块http://localhost:3011/chenyongjia/ChenYongJia/modules/getModules
	 * 
	 * @author WangChuanWei
	 * @return
	 */
	@RequestMapping(value = "/getModules", name = "查询模块", method = RequestMethod.GET)
	public Object getModules() {
		return modulesService.showModules();
	}

	/**
	 * 添加模块 http://localhost:3011/chenyongjia/ChenYongJia/modules/addModules
	 * 
	 * @author WangChuanWei
	 * @param modules
	 * @return
	 */
	@RequestMapping(value = "/addModules", name = "添加模块", method = RequestMethod.PUT)
	public Object addModules(Modules modules) {
		modules.setModulesCreateTime(new Date());
		if (modulesService.addModules(modules)) {
			return new Result(true, "模块添加成功");
		} else {
			return new Result(false, "模块名称重复,添加失败");
		}
	}

	/**
	 * 修改模块 http://localhost:3011/chenyongjia/ChenYongJia/modules/updModules
	 * 
	 * @author WangChuanWei
	 * @param modules
	 * @return
	 */
	/**
	 * 
	 * @param modules
	 * @return
	 */
	@RequestMapping(value = "/updModules", name = "修改模块", method = RequestMethod.POST)
	public Object updModules(Modules modules) {
		Modules modules2 = modulesService.getById(modules.getModulesId());
		System.out.println("modules2===============>" + modules.getModulesUpdateMan());
		if (!IsEmptyUtils.isEmpty(modules.getModulesName())) {
			modules2.setModulesName(modules.getModulesName());
		}
		if (!IsEmptyUtils.isEmpty(modules.getModulesWeight())) {
			modules2.setModulesWeight(modules.getModulesWeight());
		}
		if (!IsEmptyUtils.isEmpty(modules.getModulesPath())) {
			modules2.setModulesPath(modules.getModulesPath());
		}
		if (!IsEmptyUtils.isEmpty(modules.getModulesUpdateMan())) {
			modules2.setModulesUpdateMan(modules.getModulesUpdateMan());
		}

		if (modulesService.updModules(modules2)) {
			return new Result(true, "模块修改成功");
		} else {
			return new Result(false, "模块名称重复,修改失败");
		}
	}

	/**
	 * 删除模块http://localhost:3011/chenyongjia/ChenYongJia/modules/delModules
	 * 
	 * @author WangChuanWei
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delModules", name = "删除模块", method = RequestMethod.DELETE)
	public Object delModules(@RequestParam(value = "id[]") String[] id) {
		List<String> list = new ArrayList<String>();
		for (String dids : id) {
			list.add(dids);
		}

		List<String> moduleId = modulesService.getChildrenByParentId(list);
		List<String> modulePid = modulesService.getChildrenByParentIds(list);
		if (IsEmptyUtils.isEmpty(moduleId) || moduleId.size() == 0) {
			if (modulesService.delModules(list)) {
				return new Result(true, "模块删除成功");
			} else {
				return new Result(false, "有角色拥有当前模块,删除失败");
			}
		}

		if (IsEmptyUtils.isEmpty(modulePid) || modulePid.size() == 0) {
			for (String dids : moduleId) {
				list.add(dids);
			}

			if (modulesService.delModules(list)) {
				return new Result(true, "模块删除成功");
			} else {
				return new Result(false, "有角色拥有当前模块,删除失败");
			}
		} else {
			for (String dids : moduleId) {
				list.add(dids);
			}

			for (String dids : modulePid) {
				list.add(dids);
			}

			if (modulesService.delModules(list)) {
				return new Result(true, "模块删除成功");
			} else {
				return new Result(false, "有角色拥有当前模块,删除失败");
			}
		}

	}

	/**
	 * 查询角色设置模块http://localhost:3011/chenyongjia/ChenYongJia/modules/queryRoleSetModuleTree
	 * 
	 * @author WangChuanWei
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/queryRoleSetModuleTree", name = "查询角色设置模块", method = RequestMethod.GET)
	public Object queryRoleSetModuleTree(Integer[] roleId) {
		List<Integer> roleIds = new ArrayList<Integer>();
		for (int i = 0; i < roleId.length; i++) {
			roleIds.add(roleId[i]);
		}
		System.out.println("roleId=>" + roleIds);
		return modulesService.queryRoleSetModuleTree(roleIds);
	}

}
