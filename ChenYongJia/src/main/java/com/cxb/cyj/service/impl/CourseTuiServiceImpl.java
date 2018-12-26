package com.cxb.cyj.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.cyj.dao.CourseTuiRepository;
import com.cxb.cyj.entity.CourseTui;
import com.cxb.cyj.service.CourseTuiService;

/**
 * 
 * @Description:   课程推荐业务实现类
 * @ClassName:     CourseTuiServiceImpl.java
 * @author         ChenYongJia
 * @Date           2018年12月04日 下午20:40:56
 * @Email          867647213@qq.com
 */
@Service
public class CourseTuiServiceImpl implements CourseTuiService {

	@Autowired
	private CourseTuiRepository courseTuiRepository;
	
	/**
	 * 添加推荐课程
	 * @param courseTui
	 * @return
	 */
	@Override
	public boolean saveCourseTui(CourseTui courseTui) {
		return courseTuiRepository.save(courseTui) == null ? false : true;
	}

	/**
	 * 删除推荐课程
	 * @param courseId
	 * @return
	 */
	@Override
	public boolean delCourseTui(Integer courseId) {
		return courseTuiRepository.deleteBatch(courseId) > 0 ? true : false;
	}

	/**
	 * 查询推荐总数
	 * @return
	 */
	@Override
	public Integer countCourseTui() {
		return courseTuiRepository.findAll().size();
	}

	/**
	 * 查询推荐课程的id
	 * @return
	 */
	@Override
	public List<Integer> countCourseTuiCourseId() {
		List<CourseTui> list = courseTuiRepository.findAll();
		List<Integer> list2 = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			list2.add(list.get(i).getCourseId());
		}
		return list2;
	}

}
