package com.cxb.wmx.service.Impl;

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

import com.cxb.wmx.dao.BarRpository;
import com.cxb.wmx.entity.Bar;
import com.cxb.wmx.entitysearch.BarSearch;
import com.cxb.wmx.service.BarService;

@Service
public class BarServiceImpl implements BarService{

	@Autowired
	private BarRpository barRpository;
	@Override
	public List<Bar> selectAllBar() {
		return barRpository.findAll();
	}

	@Override
	public boolean addBar(Bar bar) {
		
		try {
			barRpository.save(bar);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateBar(Bar bar) {
		try {
			barRpository.save(bar);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteBar(Integer bid) {
		try {
			barRpository.deleteById(bid);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Bar findByBarCategory(String barName) {
		return barRpository.findByBarCategory(barName);
	}

	@Override
	public Page<Bar> sreachByBar(BarSearch barSearch, Pageable pageable) {
		return barRpository.findAll(this.getWhereClause(barSearch),pageable);
	}

	/**
	 * 动态分页查询贴吧分类
	 * @param barSearch
	 * @return
	 */
	private Specification<Bar> getWhereClause(BarSearch barSearch) {
		 return new Specification<Bar>() {
			private static final long serialVersionUID = 1L;

				@Override
				public Predicate toPredicate(Root<Bar> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					Predicate predicate = cb.conjunction();//动态SQL表达式			
					List<Expression<Boolean>> exList = predicate.getExpressions();//动态SQL表达式集合
	               if( barSearch.getBarCategory() != null && !"".equals(barSearch.getBarCategory()) ){
	            	   exList.add(cb.like(root.<String>get("barCategory"), "%"+barSearch.getBarCategory()+"%"));
	               }
	               return predicate;
				}
	       };
	}

	@Override
	public Bar queryBarId(Integer bId) {
		return barRpository.getOne(bId);
	}

	@Override
	public boolean deleteBarByIds(List<String> list) {
		try {
			barRpository.deleteBarByIds(list);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	
}
