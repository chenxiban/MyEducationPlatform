package com.cxb.cyj.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.cyj.entity.College;
import com.cxb.cyj.entity.Result;
import com.cxb.cyj.service.CollegeService;
import com.cxb.cyj.util.IsEmptyUtils;

/**
 * 
 * @Description: 登录控制器
 * @ClassName: UserController.java
 * @author ChenYongJia
 * @Date 2018年12月04日 下午20:40:56
 * @Email 867647213@qq.com
 */
@RestController
@RequestMapping(value = "/college", name = "机构设置管理")
public class CollegeController {

	@Autowired
	private CollegeService collegeService;

	/**
	 * 查询机构http://localhost:3011/chenyongjia/ChenYongJia/college/getCollege
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@RequestMapping(value = "/getCollege", name = "查询机构", method = RequestMethod.GET)
	public Object getCollege() {
		return collegeService.showColleges();
	}

	/**
	 * 查询机构http://localhost:3011/chenyongjia/ChenYongJia/college/addCollege
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@RequestMapping(value = "/addCollege", name = "添加机构", method = RequestMethod.PUT)
	public Object addCollege(College c, Integer oid) {
		c.setCollegeCreatTime(new Date());
		System.out.println("得到的College对象为====>" + c + "机构id为=====>" + oid);
		if (collegeService.addCollege(c, oid)) {
			return new Result(true,"添加机构信息成功");
		} else {
			return new Result(false,"添加机构信息失败");
		}
	}
	
	/**
	 * 查询机构http://localhost:3011/chenyongjia/ChenYongJia/college/updateCollege
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@RequestMapping(value = "/updateCollege", name = "修改机构", method = RequestMethod.POST)
	public Object updateCollege(College c, Integer oid) {
		College college=collegeService.getById(c.getCollegeId());
		if (!IsEmptyUtils.isEmpty(c.getCollegeName())) {
			college.setCollegeName(c.getCollegeName());
		}
		if (!IsEmptyUtils.isEmpty(c.getCollegeWeight())) {
			college.setCollegeWeight(c.getCollegeWeight());
		}
		if (!IsEmptyUtils.isEmpty(c.getCollegePath())) {
			college.setCollegePath(c.getCollegePath());
		}
		if (!IsEmptyUtils.isEmpty(c.getCollegeUpdateMan())) {
			college.setCollegeUpdateMan(c.getCollegeUpdateMan());
		}
		
		System.out.println("得到的College对象为====>" + c + "机构id为=====>" + oid);
		if (collegeService.addCollege(college, oid)) {
			return new Result(true,"修改机构信息成功");
		} else {
			return new Result(false,"修改机构信息失败");
		}
	}
	
	/**
	 * 查询专业信息 http://localhost:3011/chenyongjia/ChenYongJia/college/getCollegeInfos
	 * 提供给张冰倩组用于调用查询所有专业
	 * @return
	 */
	@RequestMapping(value="/getCollegeInfos",method=RequestMethod.GET)
	public List<College> getCollegeInfos(){
		int collegeRmark=2;
		return collegeService.findByCollegeRmark(collegeRmark);
	}

}
