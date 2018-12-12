package com.cxb.wmx.service.Impl;

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

import com.cxb.wmx.dao.PostreplyRpository;
import com.cxb.wmx.entity.Bar;
import com.cxb.wmx.entity.Postreply;
import com.cxb.wmx.entitysearch.PostreplySearch;
import com.cxb.wmx.service.PostreplyService;

@Service
public class PostreplyServiceImpl implements PostreplyService{

	@Autowired
	private PostreplyRpository postreplyRpository;
	@Override
	public Page<Postreply> sreachByPostreply(PostreplySearch postreplySearch, Pageable pageable) {
		return postreplyRpository.findAll(this.getWhereClause(postreplySearch),pageable);
	}
	private Specification<Postreply> getWhereClause(PostreplySearch postreplySearch) {
		 return new Specification<Postreply>() {
				private static final long serialVersionUID = 1L;

					@Override
					public Predicate toPredicate(Root<Postreply> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
						Predicate predicate = cb.conjunction();//动态SQL表达式			
						List<Expression<Boolean>> exList = predicate.getExpressions();//动态SQL表达式集合
						
		               if( postreplySearch.getUserName() != null && !"".equals(postreplySearch.getUserName()) ){
		            	   exList.add(cb.like(root.<String>get("userName"), "%"+postreplySearch.getUserName()+"%"));
		               }
		               return predicate;
					}
		       };
	}
	@Override
	public boolean deletePostreplyById(Integer hfId) {
			return postreplyRpository.deletePostreplyById(hfId)>0 ?true:false;
	}

}
