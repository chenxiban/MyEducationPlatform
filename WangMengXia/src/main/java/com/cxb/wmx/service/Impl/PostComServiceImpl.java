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

import com.cxb.wmx.dao.PostComRpository;
import com.cxb.wmx.dao.PostreplyRpository;
import com.cxb.wmx.entity.Postcommit;
import com.cxb.wmx.entity.Result;
import com.cxb.wmx.entitysearch.PostComSearch;
import com.cxb.wmx.service.PostComService;
import com.cxb.wmx.util.IsEmptyUtils;

@Service
public class PostComServiceImpl implements PostComService {

	@Autowired
	private PostComRpository postComRpository;

	@Autowired
	private PostreplyRpository postreplyRpository;

	private Specification<Postcommit> getWhereClause(PostComSearch postComSearch) {
		return new Specification<Postcommit>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Postcommit> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();// 动态SQL表达式
				List<Expression<Boolean>> exList = predicate.getExpressions();// 动态SQL表达式集合

				if (postComSearch.getPostcommitName() != null && !"".equals(postComSearch.getPostcommitName())) {
					exList.add(
							cb.like(root.<String>get("postcommitName"), "%" + postComSearch.getPostcommitName() + "%"));
				}
				return predicate;
			}
		};
	}

	@Override
	public Page<Postcommit> sreachByPostCom(PostComSearch postComSearch, Pageable pageable) {
		return postComRpository.findAll(this.getWhereClause(postComSearch), pageable);
	}

	/**
	 * @author 王梦霞 删除评论以及评论下的回复
	 * 先查到是否有这个评论,在判断这个评论是否举报成功 ,若都符合,在查询一下评论下是否有回复
	 * 若有回复,不论是否举报,删除回复后在删除评论
	 * 若无回复,直接删该评论
	 */
	@Override
	public Object deletePostCommitById(Integer postcommitId) {

		Postcommit postcommit = postComRpository.getOne(postcommitId);
		if (postcommit.getPostcommitReport() == 0) {
			return new Result(false, "该评论未被举报,或者未举报成功,删除失败");
		} else {
			if (IsEmptyUtils.isEmpty(postreplyRpository.selectByPostcommitId(postcommitId))) {
				return postComRpository.deletePostCommitByIds(postcommitId) > 0 ? new Result(true, "当前评论删除成功")
						: new Result(false, "当前评论删除失败");
			} else {
				if (postComRpository.deletePostCommitById(postcommitId) > 0) {
					return postComRpository.deletePostCommitByIds(postcommitId) > 0 ? new Result(true, "当前评论删除成功")
							: new Result(false, "当前评论删除失败");
				} else {
					return new Result(false, "当前评论下的回复删除失败");
				}
			}
		}

	}
	
}
