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
	 * 根据分类查询是否置顶,固定查询已经置顶
	 * @author 王梦霞
	 * @param barId
	 * @return
	 */
	@Query(value="SELECT p.post_id,p.post_top FROM tb_post p LEFT JOIN tb_bar b ON b.bar_id=p.bar_id WHERE b.bar_id=:barId AND p.post_top=1",nativeQuery=true)
	List<Post> queryByBarId(@Param(value="barId") Integer barId);
	
	/**
	 * 根据分类查询是否置顶,固定查询已经置顶
	 * @author 王梦霞
	 * @param barId
	 * @return
	 */
	@Query(value="SELECT * FROM tb_post WHERE post_top=2",nativeQuery=true)
	List<Post> queryByAllTop();
	
	/**
	 * 修改top,以及分类id
	 * @param postId
	 * @param barId
	 * @param postTop
	 * @return
	 */
	@Query(value="UPDATE tb_post SET post_top=:postTop,bar_id=:barId WHERE post_id=:postId",nativeQuery=true)
	@Modifying
	@Transactional
	int update(@Param(value="postId")Integer postId,@Param(value="barId")Integer barId,@Param(value="postTop")Integer postTop);
		
}
