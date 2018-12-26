package com.cxb.lhc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.lhc.entity.StudentRecord;
import com.cxb.lhc.service.StuSelectionCourseClient;
import com.cxb.lhc.service.StuSelectionCourseService;
import com.cxb.lhc.util.Result;
import com.cxb.lhc.util.StudentRecordUtil;

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
	@Autowired
	private StuSelectionCourseClient stuSelectionCourseClient;

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
		System.out.println("添加了学习记录表====》"+nInteger);
		Result result = new Result();
		if (nInteger > 0) {
			// 需要对张冰倩组的修改订阅人数方法进行+1操作
			//courseservice.updCourseStudentNum(courseId);
			result.setState(1);
			result.setMsg("添加课程成功");
		} else {
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
	/**刘莉莉
	 * 上下不一致
	 */
	
	/**
	 * 学生添加学习记录操作 先查询数据库中是否存在记录，若存在进行修改,不存在进行添加
	 * 
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	// http://localhost:3011/lihaichao/LiHaiChao/stuSelectionCourse/SelStucourse?courseId=1&studentId=1
	@RequestMapping(value = "/SelStucourse",method=RequestMethod.POST)
	Integer SelStucourse(Integer studentId,Integer studentState, double videoExitTime, Long videoStudentingTime,
			 Integer unitCourseId) {
		Long videoStudentingTimes=(Long)videoStudentingTime;
		System.out.println("jinliale");
		System.out.println("studentId=>"+studentId+"unitCourseId==>"+unitCourseId);
		Integer nInteger=courseservice.SelStucourse(unitCourseId, studentId);
		System.out.println("nInteger========>"+nInteger);
		if(nInteger==null) {
			System.out.println("程序员965");
			Integer savestucd=courseservice.savestudentrecord(studentId,unitCourseId);
			System.out.println("savestucd====>"+savestucd);
			return savestucd;
		}else {
			System.out.println("1024程序员节");
			System.out.println("studentState==>"+studentState+"videoExitTime==>"+videoExitTime+"videoStudentingTimes==>"+videoStudentingTimes);
			Integer upstuce=courseservice.UpStucourse(studentState, videoExitTime, videoStudentingTimes, studentId, unitCourseId);
			System.out.println("upstuce===》"+upstuce);
			return upstuce;
		}
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
	@RequestMapping(value = "/UpStucourse",method=RequestMethod.PUT)
	public Integer UpStucourse(Integer studentState,Double videoExitTime,Long videoStudentingTime,Integer studentId,Integer unitCourseId) {
		Integer number=0;
		System.out.println("修改了"+number+1+"次");
		// TODO Auto-generated method stub
		return courseservice.UpStucourse(studentState, videoExitTime, videoStudentingTime, studentId, unitCourseId);
	}
	/**
	 * 根据课程id获取所有章节课时信息
	 * @param courseId
	 * @return
	 */
	
	// http://localhost:3011/lihaichao/LiHaiChao/stuSelectionCourse/getCoursewareByCurrId
	@RequestMapping(value = "/getCoursewareByCurrId", method = RequestMethod.GET)
	Object getCoursewareByCurrId(Integer courseId) {
		return stuSelectionCourseClient.getCoursewareByCurrId(courseId);
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
	Object getCurrAndNoticeByCurrId(Integer curriculumId) {
		System.out.println("進來了——————————————————————》"+curriculumId);
		Object object=stuSelectionCourseClient.getCurrAndNoticeByCurrId(curriculumId);
					//StuSelectionCourseClient#getCurrAndNoticeByCurrId
		System.out.println("输出获取的object===========>"+object);
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
		return stuSelectionCourseClient.getCurrAndCoverMap(courseId);
	};
	
	// http://localhost:3011/lihaichao/LiHaiChao/stuSelectionCourse/getCurrAndCoverMap
	@RequestMapping(value = "/queryId", method = RequestMethod.GET)
	Object queryId(@RequestParam("curriculumId")Integer curriculumId,String name) {
		System.out.println("输出的curriculumId为"+curriculumId);
		Object object= stuSelectionCourseClient.queryId(curriculumId, name);
		System.out.println(object);
		return object;
	}
	
	/**
     * 	向学生学习表中添加一条数据
     * @param courseId
     * @param studentId
     * @return
     */
	// http://localhost:3011/lihaichao/LiHaiChao/stuSelectionCourse/savestudentrecord
	@RequestMapping(value="/savestudentrecord",method=RequestMethod.POST)
	Integer savestudentrecord(Integer unitCourseId, Integer studentId) {
		return courseservice.savestudentrecord(unitCourseId, studentId);
	}
	/**
	 * 根据学生ID和课程ID查询课程学习已经学习时间
	 * @param unitCourseId
	 * @param studentId
	 * @return
	 */
	// http://localhost:3011/lihaichao/LiHaiChao/stuSelectionCourse/SelStucourseByID
	@RequestMapping(value="SelStucourseByID",method=RequestMethod.GET)
	double SelStucourseByID(Integer unitCourseId, Integer studentId) {
		System.out.println("unitCourseId===>"+unitCourseId+"studentId===>"+studentId);
		return courseservice.SelStucourseByID(unitCourseId, studentId);
	}
	

}
