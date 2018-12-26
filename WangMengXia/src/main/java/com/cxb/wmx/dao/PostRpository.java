package com.cxb.wmx.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.wmx.entity.Post;

/**
 * 帖子dao
 * @author 王梦霞
 *
 */
public interface PostRpository extends JpaRepository<Post, Integer>, JpaSpecificationExecutor<Post>{

	/**
	 * 根据postId查询Post帖子
	 * @param postId
	 * @return
	 */
	Post findByPostId(Integer postId);
	
	/**
	 * 通过管理员的审查后的删除
	 * @param postId
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="DELETE FROM tb_post WHERE post_id =:postId AND post_report=1",nativeQuery=true)
	@Modifying
	@Transactional
	int deletePostById(@Param(value="postId") Integer postId);
	
	
	/**
	 * 根据分类查询是否置顶,固定查询已经置顶,是否取消置顶
	 * @author 王梦霞
	 * @param barId
	 * @return
	 */
	@Query(value="SELECT p.post_id,p.post_top FROM tb_post p LEFT JOIN tb_bar b ON b.bar_id=p.bar_id WHERE b.bar_id=:barId AND p.post_top=1",nativeQuery=true)
	List<Post> queryByBarId(@Param(value="barId") Integer barId);
	
	/**
	 * 查询是否有一个全部置顶的
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="SELECT * FROM tb_post WHERE post_top=2",nativeQuery=true)
	List<Post> queryByAllTop();
	
	/**
	 * 修改top,以及分类id,根据分类置顶
	 * @param postId
	 * @param barId
	 * @param postTop
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="UPDATE tb_post SET post_top=:postTop,bar_id=:barId WHERE post_id=:postId",nativeQuery=true)
	@Modifying
	@Transactional
	int update(@Param(value="postId")Integer postId,@Param(value="barId")Integer barId,@Param(value="postTop")Integer postTop);
	
	/**
	 * 修改top,置顶全部,直接修改全部的置顶top状态
	 * @param postId
	 * @param postTop
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="UPDATE tb_post SET post_top=:postTop WHERE post_id=:postId",nativeQuery=true)
	@Modifying
	@Transactional
	int updateBys(@Param(value="postId")Integer postId,@Param(value="postTop")Integer postTop);
		
	
	/**
	 * 查询帖子详情及分页,后台根据评论,点赞,踩赞最多去查询
	 * @author 王梦霞
	 * @param postId
	 * @param page
	 * @param rows
	 * @return
	 */
	@Query(value="SELECT * FROM tb_post WHERE post_id IN (:postId) LIMIT :page"+","+":rows",nativeQuery=true)
	List<Post> queryByTopById(@Param(value="postId") List<Integer> postId,@Param(value="page") Integer page,@Param(value="rows") Integer rows);
	
	/**
	 * 用户删除自己发的帖子
	 * @author 王梦霞
	 * @param pid
	 * @return
	 */
	@Query(value="DELETE FROM tb_post WHERE post_id =:pid",nativeQuery=true)
	@Modifying
	@Transactional
	int deleteUserPostByPid(@Param(value="pid") Integer pid);
	
	/**
	 * 根据帖子id查询帖子的评论总数
	 * @author 王梦霞
	 * @param pid
	 * @return
	 */
	@Query(value="SELECT COUNT(*) AS postCommit FROM tb_postcommit WHERE post_id=:pid",nativeQuery=true)
	int queryPostComByPid(@Param("pid") Integer pid);
	
	/**
	 * 根据帖子id查询帖子的点赞总数,,,,,,也是点赞最多的帖子进行降序排列
	 * @author 王梦霞
	 * @param pid
	 * @return
	 z */
	@Query(value="SELECT COUNT(*) AS number FROM tb_postlike WHERE post_id=:pid AND postlike_stuts=1",nativeQuery=true)
	int queryPostLikeByPidDz(@Param("pid") Integer pid);
	
	/**
	 * 根据帖子id查询帖子的踩赞总数
	 * @author 王梦霞
	 * @param pid
	 * @return
	 */
	@Query(value="SELECT COUNT(*) AS number FROM tb_postlike WHERE post_id=:pid AND postlike_stuts=2",nativeQuery=true)
	int queryPostLikeByPidCz(@Param("pid") Integer pid);
	/**
	 * 根据时间降序排列帖子
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="SELECT  post_id,post_content,post_createtime,post_name,post_report,post_title,post_top,post_update_time,user_id,user_touurl,bar_id FROM tb_post ORDER BY post_createtime DESC",nativeQuery=true)
	List<Post> queryPostTimeDesc();
	
	/**
	 * 给陈永佳组提供的查询帖子详细信息的方法
	 * @author 王梦霞
	 * @param postId
	 * @return
	 */
	@Query(value="SELECT * FROM tb_post WHERE post_id IN(:pid)",nativeQuery=true)
	List<Post> selectPostListByPostId(@Param("pid") List<Integer> postId);
	
	
	
	/**
	 * 查询讨论主题总数
	 * 刘森川
	 * @param userId
	 * @return 
	 */
	@Query(value = "SELECT COUNT(*) FROM tb_post WHERE user_id=?1", nativeQuery = true) 
	int selectPostCount(Integer userId);
	
	/**
	 * 查询发表主题的标题，部分内容，用户，时间，分类
	 * 刘森川
	 * @param postId
	 * @return
	 */
	@Query(value = "SELECT p.post_content AS postContent,p.post_createtime AS postCreatetime,p.post_name AS postName,p.post_title AS postTitle,b.bar_category AS barCategory FROM tb_post p LEFT JOIN tb_bar b ON p.bar_id=b.bar_id WHERE user_id=?1", nativeQuery = true) 
	List<PostBar> selectPostA(Integer userId);
	
	/**
	 * 查询该用户发表的评论
	 * 刘森川
	 * @param postId
	 * @return
	 */
	@Query(value = "SELECT COUNT(postcommit_id) FROM tb_postcommit WHERE user_id=?1", nativeQuery = true) 
	int selectPostCommit(Integer userId);
	
	/**
	 * 查询发表主题的总点赞数
	 * 刘森川
	 * @param postId
	 * @return
	 */
	@Query(value = "SELECT COUNT(postlike_id) FROM tb_postlike WHERE postlike_stuts=1 AND post_id=?1", nativeQuery = true) 
	int selectPostDZ(Integer postId);
	
	/**
	 * 查询该主题的评论数
	 * 刘森川
	 * @param postId
	 * @return
	 */
	@Query(value = "SELECT COUNT(*) FROM tb_postcommit WHERE post_id=?1", nativeQuery = true) 
	int selectPostCom(Integer postId);
	
	/**
	 * 查询举报状态为0的
	 * @author 王梦霞
	 * @param postReport
	 * @return
	 */
	Page<Post> findByPostReport(Integer postReport,Pageable pageable);
}
