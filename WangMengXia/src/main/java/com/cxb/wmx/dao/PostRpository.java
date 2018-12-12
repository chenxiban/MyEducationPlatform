package com.cxb.wmx.dao;

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
	
		
}
