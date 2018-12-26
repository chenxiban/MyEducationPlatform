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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.cxb.wmx.dao.ComReportRpository;
import com.cxb.wmx.dao.PostComLikeRpository;
import com.cxb.wmx.dao.PostComRpository;
import com.cxb.wmx.dao.PostReplypostRpository;
import com.cxb.wmx.dao.PostreplyRpository;
import com.cxb.wmx.dao.ReplylikeRpostiory;
import com.cxb.wmx.entity.Postcommit;
import com.cxb.wmx.entity.Postreply;
import com.cxb.wmx.entity.Postreplylike;
import com.cxb.wmx.entity.Postreplyreport;
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

	@Autowired
	private PostComLikeRpository postComLikeRpository;
	
	@Autowired
	private ReplylikeRpostiory replylikeRpostiory;
	
	@Autowired
	private ComReportRpository comReportRpository;
	
	@Autowired
	private PostReplypostRpository postReplypostRpository;

	public List<Postcommit> selectPostCommitByPid(Integer pid) {
		return postComRpository.findAll();
	}

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
	 * @author 王梦霞 删除评论以及评论下的回复 先查到是否有这个评论,在判断这个评论是否举报成功 ,若都符合,在查询一下评论下是否有回复
	 *         若有回复,不论是否举报,删除回复后在删除评论 若无回复,直接删该评论
	 */
	@Override
	public Object deletePostCommitById(Integer postcommitId) {

		Postcommit postcommit = postComRpository.getOne(postcommitId);
		if (postcommit.getPostcommitReport() == 0) {
			return new Result(false, "该评论未被举报,或者未举报成功,删除失败");
		} else {
			if (IsEmptyUtils.isEmpty(postComLikeRpository.findByPostcommit(postcommit))) {// 如果评论点菜赞为空,不删除
				// 查询评论的举报信息为不为空
				if (!IsEmptyUtils.isEmpty(comReportRpository.findByPostcommit(postcommit))) {
					comReportRpository.deleteByPostcommitId(postcommitId);// 删除评论的举报信息
				}
				
				if (IsEmptyUtils.isEmpty(postreplyRpository.selectByPostcommitId(postcommitId))) {// 查询评论的回复信息
					return postComRpository.deletePostCommitByIds(postcommitId) > 0 ? new Result(true, "当前评论删除成功")
							: new Result(false, "当前评论删除失败");
				} else {// 不为空就要删除回复的所有相关信息
					List<Postreply> list=postreplyRpository.findByPostcommit(postcommit);// 查询当前评论的所有回复
					List<Integer> list2=new ArrayList<Integer>();
					for (int i = 0; i < list.size(); i++) {
						list2.add(list.get(i).getPostreplyId());
					}
					List<Postreplyreport> postreplyreport=postReplypostRpository.findPostreply(list2);
					System.out.println("要根据回复查询的回复点赞id=====》"+list2);
					System.out.println("要删除的评论举报信息=====》"+postreplyreport);
					
					List<Postreplylike> postreplylikes=new ArrayList<Postreplylike>();
					if (!IsEmptyUtils.isEmpty(list2)) {
						postreplylikes=replylikeRpostiory.findList(list2);
					}
					
					if (!IsEmptyUtils.isEmpty(postreplylikes) && !IsEmptyUtils.isEmpty(postreplyreport)) {
						for (int i = 0; i < postreplylikes.size(); i++) {
							postReplypostRpository.deleteByPostreplyId(postreplylikes.get(i).getPostreply().getPostreplyId());// 删除回复的举报
							replylikeRpostiory.deleteByHfid(postreplylikes.get(i).getPostreply().getPostreplyId());// 删除回复的点菜赞
							postreplyRpository.deleteById(postreplylikes.get(i).getPostreply().getPostreplyId());// 删除回复
						}
						if (postComRpository.deletePostCommitById(postcommitId) > 0) {
							postComRpository.deletePostCommitByIds(postcommitId);
							return new Result(true, "当前评论删除成功");
						} else {
							return new Result(false, "当前评论下的回复删除失败");
						}
					}else {
						if (postComRpository.deletePostCommitById(postcommitId) > 0) {
							postComRpository.deletePostCommitByIds(postcommitId);
							return new Result(true, "当前评论删除成功");
						} else {
							return new Result(false, "当前评论下的回复删除失败");
						}
					}
				}
			} else {
				if (postComLikeRpository.deleteByCommitId(postcommitId) > 0) {// 删除评论点菜赞
					// 查询评论的举报信息为不为空
					if (!IsEmptyUtils.isEmpty(comReportRpository.findByPostcommit(postcommit))) {
						comReportRpository.deleteByPostcommitId(postcommitId);// 删除评论的举报信息
					}
					List<Postreply> list=postreplyRpository.findByPostcommit(postcommit);// 查询当前评论的所有回复
					List<Integer> list2=new ArrayList<Integer>();
					for (int i = 0; i < list.size(); i++) {
						list2.add(list.get(i).getPostreplyId());
					}
					List<Postreplyreport> postreplyreport=postReplypostRpository.findPostreply(list2);
					System.out.println("2要根据回复查询的回复点赞id=====》"+list2);
					System.out.println("2要删除的评论举报信息=====》"+postreplyreport);
					List<Postreplylike> postreplylikes=new ArrayList<Postreplylike>();
					if (!IsEmptyUtils.isEmpty(list2)) {
						postreplylikes=replylikeRpostiory.findList(list2);
					}
					
					if (!IsEmptyUtils.isEmpty(postreplylikes) && !IsEmptyUtils.isEmpty(postreplyreport)) {
						for (int i = 0; i < postreplylikes.size(); i++) {
							postReplypostRpository.deleteByPostreplyId(postreplylikes.get(i).getPostreply().getPostreplyId());// 删除回复的举报
							replylikeRpostiory.deleteByHfid(postreplylikes.get(i).getPostreply().getPostreplyId());// 删除回复的点菜赞
							postreplyRpository.deleteById(postreplylikes.get(i).getPostreply().getPostreplyId());// 删除回复
						}
						if (postComRpository.deletePostCommitById(postcommitId) > 0) {
							postComRpository.deletePostCommitByIds(postcommitId);
							return new Result(true, "当前评论删除成功");
						} else {
							System.out.println("nnbbbbbbbbbbbbbbbb=====》"+list2);
							return new Result(false, "当前评论下的回复删除失败");
						}
					}else {
						if (postComRpository.deletePostCommitById(postcommitId) > 0) {
							postComRpository.deletePostCommitByIds(postcommitId);
							return new Result(true, "当前评论删除成功");
						} else {
							return new Result(false, "当前评论下的回复删除失败");
						}
					}
				} else {
					return new Result(false, "当前评论下的点赞以及踩赞删除失败");
				}

			}

		}

	}

	@Override
	public boolean deleteUserPostComByPid(Integer pid) {
		return postComRpository.deleteUserPostComByPid(pid) > 0 ? true : false;
	}

	@Override
	public int queryPostReplyByPid(Integer pid) {
		return postComRpository.queryPostReplyByPid(pid);
	}

	@Override
	public int queryPostReplyLikeByPidDz(Integer pid) {
		return postComRpository.queryPostReplyLikeByPidDz(pid);
	}

	@Override
	public int queryPostReplyLikeByPidCz(Integer pid) {
		return postComRpository.queryPostReplyLikeByPidCz(pid);
	}
	
	
	// 动态查询条件的排序分页（个人中心-->评论帖子）
		/*@Override
		public Page<Postcommit> selectPageByPostCommit(PostComSearch postComSearch, Pageable pageable) {
			return postComRpository.findAll(this.getWhereClauseCommit(postComSearch), pageable);
		}
		private Specification<Postcommit> getWhereClauseCommit(PostComSearch postComSearch) {
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
		}*/

		@Override
		//查询讨论评论总数
		public int selectPostCommitCount(Integer userId) {
			return	postComRpository.selectPostCommitCount(userId);
		}

		

		@Override
		//根据主题id查询主题
		public List<String> selectPostCommitPost(Integer postId) {
			return postComRpository.selectPostCommitPost(postId);
		}

		@Override
		//查询发表评论的时间,内容,帖子id
		public List<Integer> selectPostCommitCtime(Integer userId) {
			return postComRpository.selectPostCommitCtime(userId);
		}

		@Override
		public List<Postcommit> selectPostComByUser(Integer userId) {
			return postComRpository.selectPostComByUser(userId);
		}

		@Override
		public Page<Postcommit> selectPostComPage(Integer page, Integer size) {
			Sort sort = new Sort(Sort.Direction.DESC, "postcommitCreatetime"); 
		    Pageable pageable =PageRequest.of(page, size, sort);
		    return postComRpository.findAll(pageable);
		}


}
