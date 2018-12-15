package com.cxb.wmx.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.cxb.wmx.dao.PostComRpository;
import com.cxb.wmx.dao.PostRpository;
import com.cxb.wmx.dao.PostreplyRpository;
import com.cxb.wmx.entity.Bar;
import com.cxb.wmx.entity.Post;
import com.cxb.wmx.entity.Postcommit;
import com.cxb.wmx.entity.Result;
import com.cxb.wmx.entitysearch.PostSearch;
import com.cxb.wmx.service.PostService;
import com.cxb.wmx.util.IsEmptyUtils;

@SuppressWarnings("unused")
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRpository postRpository;

	@Autowired
	private PostComRpository postComRpository;

	@Autowired
	private PostreplyRpository postreplyRpository;

	protected Path<Post> join;

	/*
	 * @Override public Page<Post> sreachByPost(PostSearch post, Pageable pageable)
	 * { return postRpository.findAll(this.getWhereClause(post), pageable); }
	 * 
	 * private Specification<Post> getWhereClause(PostSearch post) { return new
	 * Specification<Post>() { private static final long serialVersionUID = 1L;
	 * 
	 * @Override public Predicate toPredicate(Root<Post> root, CriteriaQuery<?>
	 * query, CriteriaBuilder cb) { Predicate predicate = cb.conjunction();//
	 * 动态SQL表达式 List<Expression<Boolean>> exList = predicate.getExpressions();//
	 * 动态SQL表达式集合
	 * 
	 * if (post.getPostName() != null && !"".equals(post.getPostName())) {
	 * exList.add(cb.like(root.<String>get("postName"), "%" + post.getPostName() +
	 * "%")); } if (post.getBarCategory() != null &&
	 * !"".equals(post.getBarCategory())) {
	 * exList.add(cb.like(root.<String>get("barCategory"), "%" +
	 * post.getBarCategory() + "%")); }
	 * 
	 * if (post.getBarCategory() != null && !"".equals(post.getBarCategory())) {
	 * Path<String> barCategory= join.<String>get("barCategory"); Predicate p1 =
	 * cb.like(barCategory, "%"+post.getBarCategory()+"%"); exList.add(p1); } return
	 * predicate; } }; }
	 */

	/**
	 * @author 王梦霞 删除帖子
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

	@SuppressWarnings("deprecation")
	@Override
	public Page<Post> queryAllPage(Post post, Integer page, Integer size) {// 分页
		Sort sort = new Sort(Sort.Direction.ASC, "postId");
		Pageable pageable = new PageRequest(page, size, sort);
		return postRpository.findAll(this.getWhereClause(post), pageable);
	}

	/**
	 * 查询条件动态组装 动态生成where语句 匿名内部类形式
	 * 
	 * @param
	 * @author 王梦霞
	 * @return
	 */
	@SuppressWarnings("serial")
	private Specification<Post> getWhereClause(final Post post) {
		return new Specification<Post>() {
			@Override
			public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> queryy, CriteriaBuilder cb) {
				Join<Post, Bar> join = root.join("bar", JoinType.INNER);
				Predicate predicate = cb.conjunction();// 动态SQL表达式
				List<Expression<Boolean>> exList = predicate.getExpressions();// 动态SQL表达式集合
				if (post.getPostName() != null && !"".equals(post.getPostName())) {
					exList.add(cb.like(root.<String>get("postName"), "%" + post.getPostName() + "%"));
				}
				// 动态查询贴吧分类名称
				if (post.getBarCategory() != null && !"".equals(post.getBarCategory())) {
					Path<String> barCategory = join.<String>get("barCategory");
					Predicate p1 = cb.like(barCategory, "%" + post.getBarCategory() + "%");
					exList.add(p1);
				}
				return predicate;
			}

		};
	}

	@Override
	public boolean queryByBarId(Integer postId, Integer barId, Integer allTop) {
		if (allTop == 0) {
			List<Post> list = postRpository.queryByBarId(barId);
			Integer p = 0;
			if (IsEmptyUtils.isEmpty(list)) {
				return postRpository.update(postId, barId, 1) > 0 ? true : false;// 直接修改当前postId的帖子状态为置顶
			} else {
				for (int i = 0; i < list.size(); i++) {
					p = list.get(i).getPostId();
				}
				postRpository.update(p, barId, 0);// 修改不是当前id的top为0

				return postRpository.update(postId, barId, 1) > 0 ? true : false;
			}
		} else {
			List<Post> list = postRpository.queryByAllTop();
			Integer p = 0;
			if (IsEmptyUtils.isEmpty(list)) {
				return postRpository.update(postId, barId, 2) > 0 ? true : false;// 直接修改当前postId的帖子状态为置顶
			} else {
				for (int i = 0; i < list.size(); i++) {
					p = list.get(i).getPostId();
				}
				postRpository.update(p, barId, 0);// 修改不是当前id的top为0

				return postRpository.update(postId, barId, 2) > 0 ? true : false;
			}
		}

	}

	@Override
	public boolean queryByPostId(Integer postId) {
		Post post = postRpository.getOne(postId);
		post.setPostTop(0);
		try {
			postRpository.save(post);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
