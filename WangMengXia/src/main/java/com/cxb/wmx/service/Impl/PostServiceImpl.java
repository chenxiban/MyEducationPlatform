package com.cxb.wmx.service.Impl;

import java.util.ArrayList;
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
import com.cxb.wmx.dao.PostRpository;
import com.cxb.wmx.dao.PostreplyRpository;
import com.cxb.wmx.entity.Post;
import com.cxb.wmx.entity.Postcommit;
import com.cxb.wmx.entity.Result;
import com.cxb.wmx.entitysearch.PostSearch;
import com.cxb.wmx.service.PostService;
import com.cxb.wmx.util.IsEmptyUtils;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRpository postRpository;

	@Autowired
	private PostComRpository postComRpository;

	@Autowired
	private PostreplyRpository postreplyRpository;

	@Override
	public Page<Post> sreachByPost(PostSearch postSearch, Pageable pageable) {
		return postRpository.findAll(this.getWhereClause(postSearch), pageable);
	}

	private Specification<Post> getWhereClause(PostSearch postSearch) {
		return new Specification<Post>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();// 动态SQL表达式
				List<Expression<Boolean>> exList = predicate.getExpressions();// 动态SQL表达式集合

				if (postSearch.getBarCategory() != null && !"".equals(postSearch.getBarCategory())) {
					exList.add(cb.like(root.<String>get("barCategory"), "%" + postSearch.getBarCategory() + "%"));
				}
				if (postSearch.getPostName() != null && !"".equals(postSearch.getPostName())) {
					exList.add(cb.like(root.<String>get("postName"), "%" + postSearch.getPostName() + "%"));
				}
				return predicate;
			}
		};
	}

	/**
	 * @author 王梦霞
	 * 删除帖子
	 */
	@Override
	public Object deletePostById(Integer postId) {
		Post post = postRpository.getOne(postId);
		if (post.getPostReport() == 0) {
			return new Result(false, "该帖子未被举报,或者未举报成功,删除失败");
		} else {
			List<Postcommit> postcommit = postComRpository.selectPostComiByPostId(post.getPostId());
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < postcommit.size(); i++) {
				list.add(postcommit.get(i).getPostcommitId());
			}
			if (IsEmptyUtils.isEmpty(postComRpository.selectPostComiByPostId(postId))) {
				try {
					postRpository.deleteById(postId);
					return new Result(true, "当前帖子删除成功");
				} catch (Exception e) {
					return new Result(false, "当前帖子删除失败");
				}
			} else {
				if (IsEmptyUtils.isEmpty(postreplyRpository.selectByListId(list))) {
					if (postComRpository.deleteComByList(list) > 0) {
						try {
							postRpository.deleteById(postId);
							return new Result(true, "当前帖子删除成功");
						} catch (Exception e) {
							return new Result(false, "当前帖子删除失败");
						}
					} else {
						return new Result(false, "当前帖子下的评论删除失败");
					}
				} else {
					if (postComRpository.deleteRetByList(list) > 0) {
						if (postComRpository.deleteComByList(list) > 0) {
							try {
								postRpository.deleteById(postId);
								return new Result(true, "当前帖子删除成功");
							} catch (Exception e) {
								return new Result(false, "当前帖子删除失败");
							}
						} else {
							return new Result(false, "当前帖子下的评论删除失败");
						}
					} else {
						return new Result(false, "当前帖子评论下的回复删除失败");
					}
				}
			}

		}

	}

}
