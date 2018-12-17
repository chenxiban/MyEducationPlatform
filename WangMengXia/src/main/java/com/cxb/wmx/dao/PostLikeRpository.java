package com.cxb.wmx.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.cxb.wmx.entity.Postcommit;
import com.cxb.wmx.entity.Postlike;


public interface PostLikeRpository extends JpaRepository<Postlike, Integer>, JpaSpecificationExecutor<Postlike>{

	
	/**
	 * 前10的总点赞最多的帖子
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="SELECT postlike_id,postlike_createtime,postlike_stuts,postlike_update_time,user_id,post_id,COUNT(post_id) AS number FROM tb_postlike WHERE postlike_stuts=1 GROUP BY  post_id ORDER BY number DESC",nativeQuery=true)
	List<Postlike> selectPostListByTopD();
	/**
	 * 前10的总踩赞最多的帖子
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="SELECT postlike_id,postlike_createtime,postlike_stuts,postlike_update_time,user_id,post_id,COUNT(post_id) AS number FROM tb_postlike WHERE postlike_stuts=2 GROUP BY  post_id ORDER BY number DESC",nativeQuery=true)
	List<Postlike> selectPostListByTopC();
}
