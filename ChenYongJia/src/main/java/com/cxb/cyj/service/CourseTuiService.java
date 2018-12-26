package com.cxb.cyj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cxb.cyj.entity.CourseTui;

/**
 * 
 * @Description:   课程推荐业务类
 * @ClassName:     CourseTuiService.java
 * @author         ChenYongJia
 * @Date           2018年12月04日 下午20:40:56
 * @Email          867647213@qq.com
 */
@Service
public interface CourseTuiService {
	
	/**
	 * 添加推荐课程
	 * @param courseTui
	 * @return
	 */
	boolean saveCourseTui(CourseTui courseTui);
	
	/**
	 * 删除推荐课程
	 * @param courseId
	 * @return
	 */
	boolean delCourseTui(Integer courseId);
	
	/**
	 * 查询推荐总数
	 * @return
	 */
	Integer countCourseTui();
	
	/**
	 * 查询推荐课程的id
	 * @return
	 */
	List<Integer> countCourseTuiCourseId();
	
}
