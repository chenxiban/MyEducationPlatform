package com.cxb.wmx.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cxb.wmx.entity.Post;

public interface PostService {
	/**
	 * 动态查询条件的排序分页
	 * 王梦霞
	 * @param postSearch
	 * @param pageable
	 * @return
	 */
	/*public Page<Post> sreachByPost(PostSearch post, Pageable pageable);*/
	
	public Object deletePostById(Integer postId);
	
	/**
	 * 动态查询条件的排序分页
	 * @author 王梦霞
	 * @param post
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Post> queryAllPage(Post post,Integer page,Integer size);
	
	/**
	 * 根据分类是否置顶
	 * @author 王梦霞
	 * @param postId
	 * @param barId
	 * @param allTop 如果传0代表操作分类,如果传1代表操作全部
	 * @return
	 */
	public boolean queryByBarId(Integer postId,Integer barId,Integer allTop);
	
	/**
	 * 是否取消置顶
	 * @author 王梦霞
	 * @param postId
	 * @return
	 */
	public boolean queryByPostId(Integer postId);
	
}
