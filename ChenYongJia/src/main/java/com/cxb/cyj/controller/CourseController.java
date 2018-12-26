package com.cxb.cyj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.cyj.entity.CourseTui;
import com.cxb.cyj.entity.Result;
import com.cxb.cyj.fegin.ConsumerServiceZhang;
import com.cxb.cyj.service.CourseTuiService;

/**
 * 
 * @Description: 课程推荐控制器
 * @ClassName: CourseController.java
 * @author ChenYongJia
 * @Date 2018年12月04日 下午20:40:56
 * @Email 867647213@qq.com
 */
@RestController
@RequestMapping(value = "/course", name = "课程推荐管理")
public class CourseController {
	
	@Autowired
	private ConsumerServiceZhang consumerServiceZhang;
	
	@Autowired
	private CourseTuiService courseTuiService;
	
	/**
	 * 查询课程推荐 http://localhost:3011/chenyongjia/ChenYongJia/course/getCurrIdBySubscriptionNum
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@RequestMapping(value = "/getCurrIdBySubscriptionNum", name = "查询课程前二十信息", method = RequestMethod.GET)
	public Object getCurrIdBySubscriptionNum(CourseTui courseTui) {
		if (courseTui.getP()==1) {
			return consumerServiceZhang.getCurrIdBySubscriptionNum();
		} else {
			return consumerServiceZhang.getCurrIdBySubscriptionNum();
		}
	}
	
	/**
	 * 添加课程推荐 http://localhost:3011/chenyongjia/ChenYongJia/course/saveCourseTui
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@RequestMapping(value = "/saveCourseTui", name = "添加课程推荐信息", method = RequestMethod.PUT)
	public Object saveCourseTui(CourseTui courseTui) {
		if (courseTuiService.countCourseTui()>12) {
			return new Result(false, "推荐课程已满十二条,请先移除其他推荐课程在进行推荐操作");
		} else if (courseTuiService.saveCourseTui(courseTui)) {
			return new Result(true, "推荐课程添加成功");
		} else {
			return new Result(false, "推荐课程添加失败");
		}
	}
	
	/**
	 * 删除课程推荐 http://localhost:3011/chenyongjia/ChenYongJia/course/delCourseTui
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@RequestMapping(value = "/delCourseTui", name = "删除课程推荐信息", method = RequestMethod.DELETE)
	public Object delCourseTui(CourseTui courseTui) {
		if (courseTuiService.delCourseTui(courseTui.getCourseId())) {
			return new Result(true, "推荐课程移除成功");
		} else {
			return new Result(false, "推荐课程移除失败");
		}
	}
	
	/**
	 * 查询课程推荐id http://localhost:3011/chenyongjia/ChenYongJia/course/getCourseId
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@RequestMapping(value = "/getCourseId", name = "查询课程推荐id", method = RequestMethod.GET)
	public List<Integer> getCourseId(){
		return courseTuiService.countCourseTuiCourseId();
	}
	
}
