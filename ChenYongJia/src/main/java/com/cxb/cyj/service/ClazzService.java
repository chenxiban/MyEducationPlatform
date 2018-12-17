package com.cxb.cyj.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cxb.cyj.entity.Clazz;
import com.cxb.cyj.entitysearch.ClazzSearch;

@Service
public interface ClazzService {
	
	/**
	 * 根据班级名查询
	 * 
	 * @param className
	 * @return
	 */
	Clazz findsClassName(String className);

	/**
	 * 添加班级信息
	 * 
	 * @param c
	 * @return
	 */
	boolean addClazz(Clazz c);
	
	/**
	 * 修改班级信息
	 * @param id
	 * @return
	 */
	Clazz updClazzById(Integer classId);
	
	/**
	 * 删除班级信息
	 * @param stuList
	 * @return
	 */
	boolean delClazz(List<String> stuList);
	
	/**
	 * 多条件分页检索查询
	 * @param className
	 * @param classCreatTimeStart
	 * @param classCreatTimeEnd
	 * @param page
	 * @param rows
	 * @return
	 */
	Page<Clazz> sreachByClazz(ClazzSearch clazzSearch, Pageable pageable);
	
}
