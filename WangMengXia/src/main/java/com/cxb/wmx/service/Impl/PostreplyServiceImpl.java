package com.cxb.wmx.service.Impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.cxb.wmx.dao.PostReplypostRpository;
import com.cxb.wmx.dao.PostreplyRpository;
import com.cxb.wmx.dao.ReplylikeRpostiory;
import com.cxb.wmx.entity.Postreply;
import com.cxb.wmx.entity.Postreplyreport;
import com.cxb.wmx.entity.Result;
import com.cxb.wmx.entitysearch.PostreplySearch;
import com.cxb.wmx.service.PostreplyService;
import com.cxb.wmx.util.IsEmptyUtils;

/**
 * 回复实现类
 * 
 * @author 王梦霞
 */
@Service
public class PostreplyServiceImpl implements PostreplyService {

	@Autowired
	private PostreplyRpository postreplyRpository;
	@Autowired
	private ReplylikeRpostiory replylikeRpostiory;
	
	@Autowired
	private PostReplypostRpository postReplypostRpository;

	@Override
	public Page<Postreply> sreachByPostreply(PostreplySearch postreplySearch, Pageable pageable) {
		return postreplyRpository.findAll(this.getWhereClause(postreplySearch), pageable);
	}

	private Specification<Postreply> getWhereClause(PostreplySearch postreplySearch) {
		return new Specification<Postreply>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Postreply> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();// 动态SQL表达式
				List<Expression<Boolean>> exList = predicate.getExpressions();// 动态SQL表达式集合

				if (postreplySearch.getUserName() != null && !"".equals(postreplySearch.getUserName())) {
					exList.add(cb.like(root.<String>get("userName"), "%" + postreplySearch.getUserName() + "%"));
				}
				return predicate;
			}
		};
	}


	@Override
	public Object deletePostreplyById(Integer hfId) {
		Postreply postreply = postreplyRpository.getOne(hfId);// 获取回复id
		List<Postreplyreport> postreplyreport=postReplypostRpository.findByPostreply(postreply);
		if (postreply.getPostreplyReport() == 0) {
			return new Result(false, "该回复未被举报,或者未举报成功,删除失败");
		} else {
			if (IsEmptyUtils.isEmpty(replylikeRpostiory.findByPostreply(postreply)) && IsEmptyUtils.isEmpty(postreplyreport)) {
				try {
					postreplyRpository.deleteById(hfId);
					return new Result(true, "回复删除成功");
				} catch (Exception e) {
					return new Result(false, "回复删除失败");
				}
			} else {
				if (replylikeRpostiory.deleteByHfid(hfId) > 0 && postReplypostRpository.deleteByPostreplyId(hfId)>0) {
					try {
						postreplyRpository.deleteById(hfId);
						return new Result(true, "回复删除成功");
					} catch (Exception e) {
						return new Result(false, "回复删除失败");
					}
				} else {
					return new Result(false, "当前回复下的点踩赞以及回复举报信息未删除成功，删除失败");
				}
			}
		}
	}

	@Override
	public boolean deleteUserPostreplyById(Integer hfId) {
		return postreplyRpository.deleteUserPostreplyById(hfId) > 0 ? true : false;
	}

	@Override
	public List<Postreply> selectAllRelByhfId(Integer hfId) {
		return postreplyRpository.findAll();
	}

	@Override
	public int queryPostReplyLikeByhfIdDz(Integer hfId) {
		return postreplyRpository.queryPostReplyLikeByhfIdDz(hfId);
	}

	@Override
	public int queryPostReplyLikeByhfIdCz(Integer hfId) {
		return postreplyRpository.queryPostReplyLikeByhfIdCz(hfId);
	}
	
	
	@Override
	//动态查询条件的排序分页（个人中心-->回复帖子）
	public Page<Postreply> selectPageByPostreply(PostreplySearch postreplySearch, Pageable pageable) {
		return postreplyRpository.findAll(this.getWhereClauseReply(postreplySearch),pageable);
	}
	private Specification<Postreply> getWhereClauseReply(PostreplySearch postreplySearch) {
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
	public int selectPostReplyCount(Integer userId) {
		return postreplyRpository.selectPostReplyCount(userId);
	}
	@Override
	public List<Integer> selectPostReplyCtime(Integer userId) {
		return postreplyRpository.selectPostReplyCtime(userId);
	}
	@Override
	public List<String> selectPostReplyPostCom(Integer postId) {
		return postreplyRpository.selectPostReplyPostCom(postId);
	}
	@Override
	public Page<Postreply> queryAllPage(Integer page, Integer size) {
		Sort sort = new Sort(Sort.Direction.DESC, "postreplyCreatetime"); 
	    Pageable pageable =PageRequest.of(page, size, sort);
	    return postreplyRpository.findAll(pageable);	
	    }

}
