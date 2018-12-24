package com.cxb.wmx.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cxb.wmx.entity.Dislike;

public interface DislikeRepository extends JpaRepository<Dislike, Integer>,JpaSpecificationExecutor<Dislike>{

	/**
	 * @author sun
	 * 给帖子点赞
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@Query(value="INSERT INTO tb_dislike (user_id, dispost_id,dislike_stuts)VALUES(?1 ,?2,1)",nativeQuery=true)
	@Modifying
	@Transactional
	public Integer insertThemeLike(Integer userId,Integer dispostId);
	
	/**
	 * @author sun
	 * 给帖子点踩
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@Query(value="INSERT INTO tb_dislike (user_id, dispost_id,dislike_stuts)VALUES(?1 ,?2,2)",nativeQuery=true)
	@Modifying
	@Transactional
	public Integer insertThemeOut(Integer userId,Integer dispostId);
	
	/**
	 * @author sun
	 * 查看该用户是否点过赞
	 * @param dispostId
	 * @param userId
	 * @return
	 */
	@Query(value="SELECT COUNT(*) FROM tb_dislike  WHERE dispost_id=?1 AND user_id=?2 AND dislike_stuts=1",nativeQuery=true)
	public Integer seleteUserWhetherLikeThis(Integer dispostId,Integer userId);

	/**
	 * @author sun
	 * 查看该用户是否点过踩
	 * @param dispostId
	 * @param userId
	 * @return
	 */
	@Query(value="SELECT COUNT(*) FROM tb_dislike  WHERE dispost_id=?1 AND user_id=?2 AND dislike_stuts=2",nativeQuery=true)
	public Integer seleteUserWhetherDisLikeThis(Integer dispostId,Integer userId);
	
	/**
	 * @author sun
	 * 取消喜欢/踩
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@Query(value="UPDATE tb_dislike  SET dislike_stuts = 0 WHERE user_id = ?1 AND dispost_id =?2 and dislike_stuts = 1",nativeQuery=true)
	@Modifying
	@Transactional
	public Integer updateCancelLike(Integer userId,Integer dispostId);
	
	/**
	 * @author sun
	 * 已点踩的用户点赞,改为点赞
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@Query(value="UPDATE tb_dislike  SET dislike_stuts = 1 WHERE user_id =?1 AND dispost_id = ?2 AND dislike_stuts = 2",nativeQuery=true)
	@Modifying
	@Transactional
	public Integer updateThemeLike(Integer userId,Integer dispostId);
	
	/**
	 * @author sun
	 * 已点赞的用户点踩,改为点踩
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@Query(value="UPDATE tb_dislike  SET dislike_stuts = 2 WHERE user_id =?1 AND dispost_id = ?2 AND dislike_stuts = 1",nativeQuery=true)
	@Modifying
	@Transactional
	public Integer updateThemeOut(Integer userId,Integer dispostId);
	
	
	/**
	 * @author Administratorsu
	 * 查询帖子的点赞数
	 * @param dispostId
	 * @return
	 */
	@Query(value="SELECT COUNT(*) FROM tb_dislike WHERE dispost_id=1 and dislike_stuts=1",nativeQuery=true)
	public Integer selectThemeLikeCount(Integer dispostId);
	
	/**
	 * @author Administratorsu
	 * 查询帖子的点踩数
	 * @param dispostId
	 * @return
	 */
	@Query(value="SELECT COUNT(*) FROM tb_dislike WHERE dispost_id=1 and dislike_stuts=2",nativeQuery=true)
	public Integer selectThemeDisLikeCount(Integer dispostId);
	
	/**
	 * 前10的总点赞最多的帖子
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="SELECT dislike_id,dislike_createtime,dislike_stuts,dislike_updatetime,user_id,dispost_id,COUNT(dispost_id) AS number FROM tb_dislike WHERE dislike_stuts=1 GROUP BY dispost_id ORDER BY number DESC ",nativeQuery=true)
	List<Dislike> selectDisPostListByTopD();
	/**
	 * 前10的总踩赞最多的帖子
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="SELECT dislike_id,dislike_createtime,dislike_stuts,dislike_updatetime,user_id,dispost_id,COUNT(dispost_id) AS number FROM tb_dislike WHERE dislike_stuts=2 GROUP BY dispost_id ORDER BY number DESC ",nativeQuery=true)
	List<Dislike> selectDisPostListByTopC();
	
}
