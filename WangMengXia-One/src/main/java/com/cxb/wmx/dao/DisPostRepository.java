package com.cxb.wmx.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.wmx.entity.Discommit;
import com.cxb.wmx.entity.Dislike;
import com.cxb.wmx.entity.Dispost;

public interface DisPostRepository extends JpaRepository<Dispost, Integer>,JpaSpecificationExecutor<Dispost>{

	/**
	 * @author 王梦霞
	 * 给陈永佳组提供的根据pid查询课程讨论的帖子详情
	 * @param pid
	 * @return
	 */
	@Query(value="SELECT * FROM tb_dispost WHERE dispost_id IN(:pid)",nativeQuery=true)
	List<Dispost> selectListDispostById(@Param("pid") List<Integer> pid);
	
	/**
	 * 查询课程讨论详情及分页,后台根据评论,点赞,踩赞最多去查询
	 * @author 王梦霞
	 * @param postId
	 * @param page
	 * @param rows
	 * @return
	 */
	@Query(value="SELECT * FROM tb_dispost WHERE dispost_id IN (:postId) LIMIT :page"+","+":rows",nativeQuery=true)
	List<Dispost> queryByTopById(@Param(value="postId") List<Integer> postId,@Param(value="page") Integer page,@Param(value="rows") Integer rows);
	
}
