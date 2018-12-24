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
import org.springframework.web.bind.annotation.RestController;

import com.cxb.cyj.entity.Clazz;
import com.cxb.cyj.entity.Result;
import com.cxb.cyj.service.ClazzService;
import com.cxb.cyj.util.IsEmptyUtils;

@RestController
@RequestMapping(value = "/clazz", name = "班级模块")
public class ClazzController {

	@Autowired
	private ClazzService clazzService;
	
	/**
	 * 添加班级信息
	 * http://localhost:3011/chenyongjia/ChenYongJia/clazz/addClazzs?className=晨曦班&clazz_college_id=1
	 * 
	 * @author GuoShiCai
	 * @param c
	 * @return
	 */
	@RequestMapping(value = "/addClazzs",name = "添加班级", method = RequestMethod.PUT)
	public Object addClazzs(Clazz c) {
		c.setClassCreatTime(new Date(System.currentTimeMillis()));
		Clazz ulist = clazzService.findsClassName(c.getClassName());
		if (IsEmptyUtils.isEmpty(ulist)) {
			if (clazzService.addClazz(c)) {
				return new Result(true, "班级添加成功");
			} else {
				return new Result(false, "班级添加失败");
			}
		} else {
			return new Result(false, "班级名重复,请重新填写");
		}
	}
	
	/**
	 * 修改班级
	 * http://localhost:3011/chenyongjia/ChenYongJia/clazz/updClazz?classId=1&className=晨曦班时
	 * 
	 * @author GuoShiCai
	 * @param u
	 * @return
	 */
	@RequestMapping(value = "/updClazz", name = "修改班级", method = RequestMethod.POST)
	//@RequestMapping(value = "/updClazz", name = "修改班级")
	public Object updClazz(Clazz c) {
		Clazz clazz = clazzService.updClazzById(c.getClassId());
		System.out.println("============>"+c.getCollege());
		if (!IsEmptyUtils.isEmpty(c.getClassName())) {
			clazz.setClassName(c.getClassName());
		}
		if (!IsEmptyUtils.isEmpty(c.getClassNumber())) {
			clazz.setClassNumber(c.getClassNumber());
		}
		if (!IsEmptyUtils.isEmpty(c.getCollege())) {
			clazz.setCollege(c.getCollege());
		}

		clazz.setClassId(c.getClassId());
		if (clazzService.addClazz(clazz)) {
			return new Result(true, "班级修改成功");
		} else {
			return new Result(false, "班级名重复,请重新填写!");
		}
	}
	
	/**
	 * 删除班级 http://localhost:3011/chenyongjia/ChenYongJia/clazz/delClazz
	 * 
	 * @author GuoShiCai
	 * @param classId
	 * @return
	 */
	@RequestMapping(value = "/delClazz", name = "删除班级", method = RequestMethod.DELETE)
	//@RequestMapping(value = "/delClazz", name = "删除班级")
	public Object delClazz(String classId) {
		List<String> list = new ArrayList<String>();
		String[] ids = classId.split(",");
		for (String dids : ids) {
			list.add(dids);
		}
		if (clazzService.delClazz(list)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 分页检索查询 http://localhost:3011/chenyongjia/ChenYongJia/clazz/getAllPageClazz
	 * 
	 * @author GuoShiCai
	 * @param clazzSearch
	 * @return
	 */
	@PreAuthorize(value = "hasAuthority('clazz:getAllPageClazz')")
	@RequestMapping(value = "/getAllPageClazz", name = "查询班级", method = RequestMethod.GET)
	public Object getAllPageUsers(Clazz clazzSearch) {
		System.out.println("当前查询参数===>" + clazzSearch);
		Pageable pageable = PageRequest.of(clazzSearch.getPage() - 1, clazzSearch.getRows(), Sort.Direction.ASC,
				"classId");
		Page<Clazz> page = clazzService.sreachByClazz(clazzSearch, pageable);
		Long total = page.getTotalElements();
		List<Clazz> list = page.getContent();

		System.out.println("查询到的数据为=====>" + list);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
}
