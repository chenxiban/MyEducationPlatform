package com.cxb.lhc.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cxb.lhc.entity.StuSelectionCourse;
import com.cxb.lhc.impl.StuSelectionCourseServiceImpl;

/**
 * 
 * @Description: 学生进行选课操作的Service接口
 * @ClassName: StuSelectionCourseService
 * @author liu
 * @Date 2018年12月14日 下午16:58
 * @Email 1273822019@qq.com
 */

@FeignClient(value = "zhangbingqian", fallback = StuSelectionCourseServiceImpl.class)
public interface StuSelectionCourseService {
	/**
	 * 
	 * 获取首页点击课程服务
	 * 根据课程ID获取课程信息
	 * @param courseId
	 * @return
	 */		
	@RequestMapping("/Curriculum/getCurriculumById")
	Object getCourseByCourseId(Integer courseId);
	
	/*public Object getcourseFuture(Integer courseId) {
		return restTemplate.getForObject("http://localhost:3050/ZhangBingQian/Curriculum/getCurriculumById", Integer.class);
	}*/
	
	/**在选择课程后
	 * 根据课程id调用张冰倩组方法修改课程订阅人数+1
	 * @param courseId
	 * @return
	 */
	/*@RequestMapping("/")
	Object updCourseStudentNum(Integer courseId);*/
	
	/**在取消课程后
	 * 根据课程id调用张冰倩组方法修改课程订阅人数-1
	 * @param courseId
	 * @return
	 */
	/*@RequestMapping("/")
	Object updExitCourseStudentNum(Integer courseId);
	*/
	/**
	 * 根据课程id获取课程对应信息
	 * 
	 * @param courseId
	 * @return
	 */
	@RequestMapping("/curriculum/getCurrAndNoticeByCurrId")
	Object getCurrAndNoticeByCurrId(Integer courseId);

	/**
	 * 根据课程id获取所有章节课时信息
	 * 
	 * @param courseId
	 * @return
	 */
	@RequestMapping("/courseware/getCoursewareByCurrId")
	Object getCoursewareByCurrId(Integer courseId);

	/**
	 * 根据课程id获取所有课件信息
	 * 
	 * @param courseId
	 * @return
	 **/
	@RequestMapping("/chapter/getChapterByCurrId")
	Object getChapterByCurrId(Integer courseId);

	/**
	 * 获取所有课程信息及课程封面图(首页)
	 * 
	 * @param courseId
	 * @return
	 */
	@RequestMapping("/curriculum/getCurrAndCoverMap")
	Object getCurrAndCoverMap(Integer courseId);

	/**
	 * 点击立即参加
	 * 往学生选课表中添加一条数据
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	 @Transactional
     Integer saveStucourse(Integer courseId, Integer studentId);

	/**
	 * 查询改学生是否有学习记录
	 * 
	 * @param courseId
	 * @return
	 */
	Integer SelStucourse(Integer courseId,Integer studentId);

	/**
	 * 学生学习过后，修改学生学习记录表
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	Integer UpStucourse(Integer studentState,Double videoExitTime,Integer videoStudentingTime,Integer studentId,Integer unitCourseId);
	/**
	 * 学生在个人中心进行退课操作
	 * 
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	@Transactional
	Integer delStuCourseByStuCourseId(Integer courseId, Integer studentId);

}
