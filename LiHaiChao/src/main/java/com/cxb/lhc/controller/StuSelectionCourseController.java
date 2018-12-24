package com.cxb.lhc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.lhc.service.StuSelectionCourseService;
import com.cxb.lhc.util.Result;

/**
 * @Description:
 * @ClassName: courseController.java
 * @author lihaichao
 * @Date 2018年12月10日 下午9:37:42
 * @Email 1273822019@qq.com
 */
@RestController
@RequestMapping("/stuSelectionCourse")
public class StuSelectionCourseController {
	@Autowired
	private StuSelectionCourseService courseservice;
	/**
	 * 根据课程id获取所有章节课时信息
	 * @param courseId
	 * @return
	 */
	
	// http://localhost:3011/lihaichao/LiHaiChao/stuSelectionCourse/getCoursewareByCurrId
	@RequestMapping(value = "/getCoursewareByCurrId", method = RequestMethod.GET)
	Object getCoursewareByCurrId(Integer courseId) {
		return courseservice.getCoursewareByCurrId(courseId);
	}
	
	/**
	 * 
	 * 获取首页点击课程服务
	 * 根据课程ID获取课程信息
	 * @param courseId
	 * @return
	 */	
	// http://localhost:3011/lihaichao/LiHaiChao/stuSelectionCourse/getCurrAndNoticeByCurrId
	@RequestMapping(value = "/getCurrAndNoticeByCurrId", method = RequestMethod.GET)
	Object getCurrAndNoticeByCurrId(Integer courseId) {
		Object object=(Integer) courseservice.getCurrAndNoticeByCurrId(courseId);
		return object;
	}
	/**
	 * 根据课程id获取所有课件信息
	 * @param courseId
	 * @return
	 */
	// http://localhost:3011/lihaichao/LiHaiChao/stuSelectionCourse/getCurrAndCoverMap
	@RequestMapping(value = "/getCurrAndCoverMap", method = RequestMethod.GET)
	public Object getCurrAndCoverMap(Integer courseId) {
		return courseservice.getCurrAndCoverMap(courseId);
	};
	
	/**
	 * 学生在个人中心进行退课操作
	 * @param studentId
	 * @return
	 */
	@RequestMapping(value = "/getChapterByCurrId", method = RequestMethod.GET)
	Object getChapterByCurrId(Integer courseId) {
		return courseservice.getChapterByCurrId(courseId);
	}
	/**
	 * 学生选课操作 点击立即参见学生选课表中添加一条数据
	 * 
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	// http://localhost:3011/lihaichao/LiHaiChao/stuSelectionCourse/saveStucourse?courseId=1&studentId=1
	@RequestMapping(value = "/saveStucourse",method=RequestMethod.POST)
	Result saveStucourse(Integer courseId, Integer studentId) {
		Integer nInteger = courseservice.saveStucourse(courseId, studentId);
		Result result = new Result();
		if (nInteger > 0) {
			// 需要对张冰倩组的修改订阅人数方法进行+1操作
			result.setState(1);
			result.setMsg("添加课程成功");
		} else {
			result.setState(0);
			result.setMsg("添加课程失败");

		}
		return result;

	}
	
	/**
	 * 学生添加学习记录操作 先查询数据库中是否存在记录，若存在进行修改,不存在进行添加
	 * 
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	// http://localhost:3011/lihaichao/LiHaiChao/stuSelectionCourse/SelStucourse?courseId=1&studentId=1
	@RequestMapping(value = "/SelStucourse",method=RequestMethod.GET)
	Integer SelStucourse(Integer courseId,Integer studentId,Integer studentState, Double videoExitTime, Integer videoStudentingTime,
			 Integer unitCourseId) {
		Integer nInteger = courseservice.SelStucourse(courseId, studentId);
		if(nInteger==0) {
			this.saveStucourse(courseId, studentId);
		}else {
			this.UpStucourse(studentState, videoExitTime, videoStudentingTime, studentId, unitCourseId);
		}
		return nInteger;
	}
	/**
	 * 学生学习过后，修改学生学习记录表
	 * @param studentState
	 * @param videoExitTime
	 * @param videoStudentingTime
	 * @param studentId
	 * @param unitCourseId
	 * @return
	 */
	@RequestMapping(value = "/SelStucourse",method=RequestMethod.PUT)
	public Integer UpStucourse(Integer studentState, Double videoExitTime, Integer videoStudentingTime,
			Integer studentId, Integer unitCourseId) {
		// TODO Auto-generated method stub
		return courseservice.UpStucourse(studentState, videoExitTime, videoStudentingTime, studentId, unitCourseId);
	}
	/**
	 * 学生在个人中心进行退课操作
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	// http://localhost:3011/LiHaiChao/stuSelectionCourse/delStuCourseByStuCourseId?courseId=1&studentId=1
	@RequestMapping(value="/delStuCourseByStuCourseId",method=RequestMethod.DELETE)
	Result delStuCourseByStuCourseId(Integer courseId, Integer studentId) {
		Integer nInteger = courseservice.delStuCourseByStuCourseId(courseId, studentId);
		Result result = new Result();
		if (nInteger > 0) {
			// 需要对张冰倩组的修改订阅人数方法进行-1操作
			result.setState(1);
			result.setMsg("删除课程成功");
		} else {
			result.setState(0);
			result.setMsg("删除课程失败");
		}
		return result;
	}

}
