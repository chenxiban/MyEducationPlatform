package com.cxb.cyj.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.cxb.cyj.dao.ClazzRepository;
import com.cxb.cyj.dao.CollegeRepository;
import com.cxb.cyj.entity.Clazz;
import com.cxb.cyj.entity.College;
import com.cxb.cyj.entitysearch.ClazzSearch;
import com.cxb.cyj.service.ClazzService;
import com.cxb.cyj.util.IsEmptyUtils;

@Service
public class ClazzServiceImpl implements ClazzService {

	@Autowired
	private ClazzRepository clazzRepository;
	
	@Autowired
	private CollegeRepository collegeRepository;
	
	@Override
	public boolean addClazz(Clazz c) {
		try {
			System.out.println("要添加的专业为====>"+c.getCollegeId());
			College college=collegeRepository.findByCollegeId(c.getCollegeId());
			c.setCollege(college);
			
			System.out.println("要添加的专业为====>"+college);
			
			clazzRepository.save(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 根据姓名查询
	 * 
	 * @param usersName
	 * @return
	 */
	@Override
	public Clazz findsClassName(String className) {
		return clazzRepository.findByClassName(className);
	}

	@Override
	public Clazz updClazzById(Integer classId) {
		return clazzRepository.findByClassId(classId);
	}

	@Override
	public boolean delClazz(List<String> stuList) {
		try {
			clazzRepository.deleteBatch(stuList);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Page<Clazz> sreachByClazz(ClazzSearch clazzSearch, Pageable pageable) {
		return clazzRepository.findAll(this.getWhereClause(clazzSearch), pageable);
	}
	
	/**
	 * 查询条件动态组装 动态生成where语句 匿名内部类形式
	 * 
	 * @param us
	 * @return
	 * @author ChenYongJia
	 */
	@SuppressWarnings({ "serial" })
	private Specification<Clazz> getWhereClause(final ClazzSearch cs) {
		return new Specification<Clazz>() {

			@Override
			public Predicate toPredicate(Root<Clazz> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();// 动态SQL表达式
				List<Expression<Boolean>> exList = predicate.getExpressions();// 动态SQL表达式集合

				if (!IsEmptyUtils.isEmpty(cs.getClassName())) {
					exList.add(cb.like(root.<String>get("className"), "%" + cs.getClassName() + "%"));
				}
				if (!IsEmptyUtils.isEmpty(cs.getClassCreatTimeStart())) {
					exList.add(cb.greaterThanOrEqualTo(root.<Date>get("classCreatTimeStart"), cs.getClassCreatTimeStart()));
				}
				if (!IsEmptyUtils.isEmpty(cs.getClassCreatTimeEnd())) {
					exList.add(cb.lessThanOrEqualTo(root.<Date>get("classCreatTimeEnd"), cs.getClassCreatTimeEnd()));
				}
				return predicate;
			}

		};
	}

}
