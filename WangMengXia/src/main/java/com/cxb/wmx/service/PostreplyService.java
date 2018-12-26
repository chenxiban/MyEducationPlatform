package com.cxb.wmx.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cxb.wmx.entity.Postreply;
import com.cxb.wmx.entity.Postreplylike;
import com.cxb.wmx.entitysearch.PostreplySearch;

public interface PostreplyService {

	
	/**
	 * 根据回复id查询所有回复
	 * @author 王梦霞
	 * @param hfId
	 * @return
	 */
	public List<Postreply> selectAllRelByhfId(Integer hfId);
	/**
	 * 动态查询条件的排序分页
	 * 王梦霞
	 * @param barSearch
	 * @param pageable
	 * @return
	 */
	public Page<Postreply> sreachByPostreply(PostreplySearch postreplySearch, Pageable pageable);
	
	/**
	 * 删除
	 * @param barId
	 * @return
	 */
	public Object deletePostreplyById(Integer hfId);
	
	/**
	 * @author 王梦霞
	 * 用户删除自己的回复
	 * @param hfId
	 * @return
	 */
	public boolean deleteUserPostreplyById(Integer hfId);
	
	/**
	 * 根据回复id查询回复的点赞总数
	 * @author 王梦霞
	 * @param hfId
	 * @return
	 */
	public int queryPostReplyLikeByhfIdDz(Integer hfId);
	
	/**
	 * 根据回复id查询回复的踩赞总数
	 * @author 王梦霞
	 * @param hfId
	 * @return
	 */
	public int queryPostReplyLikeByhfIdCz(Integer hfId);
	
	/**
	 * 动态查询条件的排序分页（个人中心-->回复帖子）
	 * 刘森川
	 * @param postSearch
	 * @param pageable
	 * @return
	 */
	public Page<Postreply> selectPageByPostreply(PostreplySearch postreplySearch, Pageable pageable);
	/**
	 * 查询发表总回复数
	 * 刘森川
	 * @param userName
	 * @return
	 */
	public int selectPostReplyCount(Integer userId);
	
	/**
	 * 查询分页
	 * 刘森川
	 * @param userId
	 * @return
	 */
	public Page<Postreply> queryAllPage(Integer page,Integer size);//分页,排序
	
	/**
	 * 查询发表回复的时间,内容,帖子id
	 * @param userId
	 * @return 刘森川
	 */
	public List<Integer> selectPostReplyCtime(Integer userId);
	
	/**
	 * 根据评论id查询回复基于那条评论
	 * @param userId
	 * @return 刘森川
	 */
	public List<String> selectPostReplyPostCom(Integer postId);
}
