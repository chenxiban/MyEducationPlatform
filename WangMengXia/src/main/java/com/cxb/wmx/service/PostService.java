package com.cxb.wmx.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.cxb.wmx.entity.Post;
import com.cxb.wmx.entity.Postlike;

public interface PostService {
	
	/**
	 * @author 王梦霞
	 * 删除帖子
	 * @param postId
	 * @return
	 */
	public Object deletePostById(Integer postId);
	
	/**
	 * 动态查询条件的排序分页
	 * @author 王梦霞
	 * @param post
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Post> queryAllPage(Post post,Pageable pageable);
	
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
	
	/**
	 * 查询前20评论最多的帖子分页
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Post> queryPageTop(Integer page,Integer rows);
	
	/**
	 * 前10的总点赞最多的帖子
	 * @author 王梦霞
	 * @return
	 */
	public List<Post> selectPostListByTopD(Integer page,Integer rows);
	/**
	 * 前10的总踩赞最多的帖子
	 * @author 王梦霞
	 * @return
	 */
	public List<Post> selectPostListByTopC(Integer page,Integer rows);
	
	/**
	 * 用户删除自己发的帖子
	 * @author 王梦霞
	 * @param pid
	 * @return
	 */
	public boolean deleteUserPostByPid(Integer pid);
}
