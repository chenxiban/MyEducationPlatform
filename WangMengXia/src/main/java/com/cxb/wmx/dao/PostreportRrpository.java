package com.cxb.wmx.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.wmx.entity.Postreport;
import java.lang.Integer;

/**
 * 
 * @Description:   PostreportRrpository举报dao接口
 * @ClassName:     Bar.java
 * @author         王梦霞
 */
public interface PostreportRrpository extends JpaRepository<Postreport, Integer>, JpaSpecificationExecutor<Postreport>{
	
	/**
	 * 根据id查询Postreport
	 * @param postreportId
	 * @return
	 */
	Postreport findByPostreportId(Integer postreportId);
	
	/**
	 * 根据状态查询举报总数
	 * @param postreportStuts
	 * @return
	 */
	@Query(value = "SELECT COUNT(postreport_id) FROM tb_postreport WHERE postreport_stuts =:postreportStuts ", nativeQuery = true)
	Integer queryByStuts(@Param(value="postreportStuts") Integer postreportStuts);
	
	/**
	 * 根据状态查询举报信息
	 * @param postreportStuts
	 * @return
	 */
	List<Postreport> findByPostreportStuts(Integer postreportStuts);
	
	/**
	 * 根据用户id和当前帖子id查询是否可以再次举报
	 * @param userId
	 * @param postId
	 * @return
	 */
	@Query(value = "SELECT postreport_id,postreport_content,postreport_createtime,postreport_stuts,postreport_update_time,user_id,post_id FROM tb_postreport WHERE user_id=:userId AND post_id=:postId AND postreport_stuts NOT IN(1,2) ", nativeQuery = true)
	Postreport findChongFu(@Param(value="userId") Integer userId,@Param(value="postId") Integer postId);
}
