package com.cxb.lhc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.lhc.repository.StuSelectionCourseReository;
import com.cxb.lhc.service.StuSelectionCourseClient;
import com.cxb.lhc.service.StuSelectionCourseService;
import com.cxb.lhc.entity.StudentRecord;;


/**
 * 
 * @Description:   学生进行选课操作的service实现类
 * @ClassName:     StuSelectionCourseServiceImpl
 * @author         liu
 * @Date           2018年12月14日 下午17:15
 * @Email          1273822019@qq.com
 */
@Service
public class StuSelectionCourseServiceImpl implements StuSelectionCourseService{
 
	@Autowired
	private StuSelectionCourseReository stuRepository;
	@Autowired
	private StuSelectionCourseClient stuSelectionCourseClient;
	/**
	 * 点击立即参加
	 * 往学生选课表中添加一条数据
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	@Override
	public Integer saveStucourse(Integer courseId, Integer studentId) {		
		return stuRepository.saveStucourse(courseId, studentId);
	}
	
	/**
	 * 学生在个人中心进行退课操作
	 * @param courseId
	 * @param studentId
	 * @return
	 */

	public Integer delStuCourseByStuCourseId(Integer courseId,Integer studentId){
		 return stuRepository.delStuCourseByStuCourseId(courseId, studentId);
	 }
	/**在选择课程后
	 * 根据课程id调用张冰倩组方法修改课程订阅人数+1
	 * @param courseId
	 * @return
	 */
	public Object updCourseStudentNum(Integer courseId) {
		return stuSelectionCourseClient.updCourseStudentNum(courseId);
	}
	/**在取消课程后
	 * 根据课程id调用张冰倩组方法修改课程订阅人数-1
	 * @param courseId
	 * @return
	 */
public	Object updExitCourseStudentNum(Integer courseId) {
	return stuSelectionCourseClient.updExitCourseStudentNum(courseId);
}
	
	
	/**11111111111111111111111111111111111111111111111111111111111111111111*/
	/**
	 * 
	 * 获取首页点击课程服务
	 * 根据课程ID获取课程信息
	 * @param courseId
	 * @return
	 */	
	
	public Object getCurrAndNoticeByCurrId(Integer curriculumId) {		
		return stuSelectionCourseClient.getCurrAndNoticeByCurrId(curriculumId);
	}
	
	/**
	 * 根据课程id获取所有章节课时信息
	 * @param courseId
	 * @return
	 */
	
	public Object getCoursewareByCurrId(Integer courseId) {
		// TODO Auto-generated method stub
		return stuSelectionCourseClient.getCoursewareByCurrId(courseId);
	}
	
	/**
	 * 根据课程id获取所有课件信息
	 * @param courseId
	 * @return
	 */
	
	public Object getChapterByCurrId(Integer curriculumId,String name) {
		// TODO Auto-generated method stub
		return stuSelectionCourseClient.queryId(curriculumId,name);
	};
	
	/**
	 * 获取所有课程信息及课程封面图(首页)
	 * @param courseId
	 * @return
	 */
	
	public Object getCurrAndCoverMap(Integer courseId) {
		// TODO Auto-generated method stub
		return stuSelectionCourseClient.getCurrAndCoverMap(courseId);
	};
	
	/**
	 * 查询改学生是否有学习记录
	 * @param unitCourseId
	 * @return
	 */
	public Integer  SelStucourse(Integer unitCourseId,Integer studentId) {
		// TODO Auto-generated method stub
		return stuRepository.SelStucourse(unitCourseId, studentId);
	}
	
	/**
	 * 查询改学生是否有学习记录,返回一条学习记录
	 * @param courseId
	 * @return
	 */
	public double  SelStucourseByID(Integer unitCourseId,Integer studentId) {
		// TODO Auto-generated method stub
		return stuRepository.SelStucourseByID(unitCourseId, studentId);
	}
	/**
	 * 学生学习过后，修改学生学习记录表
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	@Override
	public Integer UpStucourse(Integer studentState,Double videoExitTime,Long videoStudentingTime,Integer studentId,Integer unitCourseId) {
		// TODO Auto-generated method stub
		return stuRepository.UpStucourse(studentState, videoExitTime, videoStudentingTime, studentId, unitCourseId);
	}

	/**
	 * 
	 * 获取首页点击课程服务
	 * 根据课程ID获取课程信息
	 * @param courseId
	 * @return
	 */	
	
	public Object getCourseByCourseId(Integer courseId) {		
		return stuSelectionCourseClient.getCourseByCourseId(courseId);
	}
	/**
     * 	向学生学习表中添加一条数据
     * @param courseId
     * @param studentId
     * @return
     */ 
	public Integer savestudentrecord(Integer studentId,Integer unitCourseId) {
		return stuRepository.savestudentrecord(studentId,unitCourseId);
	}

}
