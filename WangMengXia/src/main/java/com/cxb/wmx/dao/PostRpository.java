package com.cxb.wmx.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.wmx.entity.Post;

public interface PostRpository extends JpaRepository<Post, Integer>, JpaSpecificationExecutor<Post>{

	/**
	 * 通过管理员的审查后的删除
	 * @param postId
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
	
}
