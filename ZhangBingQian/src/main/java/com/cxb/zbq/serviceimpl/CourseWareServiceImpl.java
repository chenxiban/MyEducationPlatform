package com.cxb.zbq.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.zbq.dao.ChapterRepository;
import com.cxb.zbq.dao.CourseWareRepository;
import com.cxb.zbq.entity.CourseWare;
import com.cxb.zbq.service.CourseWareService;
@Service
public class CourseWareServiceImpl implements CourseWareService {
	@Autowired
	private CourseWareRepository cRepository;
	@Autowired
	private ChapterRepository chapterRepository;
	

	@Override
	public List<CourseWare> findAllClassHourByCurrId(Integer currId) {
		List<Integer> cwIds=chapterRepository.getChapterIdListByCurriculumId(currId);
		System.out.println("1>>"+cwIds.size());
		if (cwIds!=null) {
			List<CourseWare> list=new ArrayList<>();
			for (int i = 0; i < cwIds.size(); i++) {
				System.out.println("cw>>"+cwIds.get(i));
				list.addAll(cRepository.findByClassHourId(cwIds.get(i)));
			}
			System.out.println("2>>"+list.size());
			return list;
		}
		return null;
	}

	@Override
	public int deleteCourseWare(Integer cId) {
		return cRepository.deleteCourseWare(cId);
	}

	@Override
	public int deleteCourseWareByCurrId(Integer classHourId) {
		List<CourseWare> list=cRepository.findByClassHourId(classHourId);
		int n=0;
		if (list!=null) {
			List<Integer> idList=new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				idList.add(list.get(i).getClassHourId());
			}
			for (int i = 0; i < idList.size(); i++) {
				n+=cRepository.deleteCourseWare(idList.get(i));
			}
		}
		return n;
	}

	@Override
	public List<CourseWare> findByClassHourId(Integer classHourId) {
		return cRepository.findByClassHourId(classHourId);
	}


}
