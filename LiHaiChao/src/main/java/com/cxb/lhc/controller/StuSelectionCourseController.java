package com.cxb.lhc.controller;
  
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.lhc.entity.StuSelectionCourse;
import com.cxb.lhc.service.StuSelectionCourseService;
import com.cxb.lhc.util.Result;
 
/**
 * 
 * @Description:   
 * @ClassName:     courseController.java
 * @author         lihaichao
 * @Date           2018年12月10日 下午9:37:42
 * @Email          1273822019@qq.com
 */
@RestController
@RequestMapping("/stuSelectionCourse")
public class StuSelectionCourseController {
	@Autowired
	private StuSelectionCourseService courseservice; 
	
	/**
	 * 获取首页点击的课程调用课程服务，根据课程ID获取课程
	 * @param courseId
	 * @return
	 */
	//http://localhost:3011/LiHaiChao/stuSelectionCourse/getCourseByCourseId
	@RequestMapping(value="/getCourseByCourseId",method=RequestMethod.POST)
	Object getCourseByCourseId(Integer courseId) {
		return courseservice.getCourseByCourseId(courseId);
	}
	
	/**学生选课操作
	 * 点击立即参见学生选课表中添加一条数据
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	//http://localhost:3011/LiHaiChao/stuSelectionCourse/saveStucourse?courseId=1&studentId=1
	@RequestMapping(value="/saveStucourse")
	Result saveStucourse(Integer courseId,Integer studentId) {
		Integer nInteger=courseservice.saveStucourse(courseId,studentId);
		Result result=new Result();
		if(nInteger>0) {
			//需要对张冰倩组的修改订阅人数方法进行+1操作
	    	result.setState(1);
	    	result.setMsg("添加课程成功");
	    }else {
	    	result.setState(0);
	    	result.setMsg("添加课程失败");

	    }
		return result;
			
	}
	/**
	 * 学生在个人中心进行退课操作
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	//http://localhost:3011/LiHaiChao/stuSelectionCourse/delStuCourseByStuCourseId?courseId=1&studentId=1
	@RequestMapping("/delStuCourseByStuCourseId")
	Result delStuCourseByStuCourseId(Integer courseId,Integer studentId) {
		Integer nInteger=courseservice.delStuCourseByStuCourseId(courseId, studentId);
		Result result=new Result();
		if(nInteger>0) {
			//需要对张冰倩组的修改订阅人数方法进行-1操作
	    	result.setState(1);
	    	result.setMsg("删除课程成功");
	    }else {
	    	result.setState(0);
	    	result.setMsg("删除课程失败");

	    }
		return result;
	}
	
}
     
