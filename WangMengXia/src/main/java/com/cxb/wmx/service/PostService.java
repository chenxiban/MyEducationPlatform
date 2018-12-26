package com.cxb.wmx.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cxb.wmx.dao.PostBar;
import com.cxb.wmx.entity.Post;

public interface PostService {
	
	/**
	 * 根据pid查询所有帖子
	 * @param pid
	 * @return
	 */
	public List<Post> selectPostByPid(Integer pid);
	
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
	
	/**
	 * 根据帖子id查询帖子的评论总数
	 * @author 王梦霞
	 * @param pid
	 * @return
	 */
	public int queryPostComByPid(Integer pid);
	
	/**
	 * 根据帖子id查询帖子的点赞总数
	 * @author 王梦霞
	 * @param pid
	 * @return
	 */
	public int queryPostLikeByPidDz(Integer pid);
	
	/**
	 * 根据帖子id查询帖子的踩赞总数
	 * @author 王梦霞
	 * @param pid
	 * @return
	 */
	public int queryPostLikeByPidCz(Integer pid);
	
	/**
	 * 根据时间排序帖子
	 * @author 王梦霞
	 * @return
	 */
	public List<Post> queryPostTimeDesc();
	
	/**
	 * 给陈永佳组提供的查询帖子详细信息的方法
	 * @author 王梦霞
	 * @param postId
	 * @return
	 */
	public List<Post> selectPostListByPostId(List<Integer> postId);
	
	/**
	 * 发帖人进行发帖
	 * @author 王梦霞
	 * @param post
	 * @return
	 */
	public boolean addLauyiPost(Post post);
	
	public boolean delPostById(Integer postId);
	
	
	/**
	 * 查询发表主题的标题，部分内容，用户，时间，分类
	 * 刘森川
	 * @param postId
	 * @return
	 */
	public List<PostBar> selectPostA(Integer userId);
	
	/**
	 * 查询讨论主题总数
	 * 刘森川
	 * @param postSearch
	 * @param pageable
	 * @return
	 */
	
	public int selectPostCount(Integer userId);
	
	/**
	 * 查询发表主题的总评论数
	 * 刘森川
	 * @param userId
	 * @return
	 */
	public int selectPostCommit(Integer userId);
	
	/**
	 * 查询发表主题的总点赞数
	 * 刘森川
	 * @param postId
	 * @param postlikeId
	 * @return
	 */
	public int selectPostDZ(Integer postId);
	
	/**
	 * 查询分页
	 * 刘森川
	 * @param userId
	 * @return
	 */
	public Page<Post> queryAllPage(Integer page,Integer size);//分页,排序
	
	/**
	 * 查询该主题的评论数
	 * 刘森川
	 * @param postId
	 * @return
	 */
	public int selectPostCom(Integer postId);
}
