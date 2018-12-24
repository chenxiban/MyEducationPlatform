package com.cxb.wmx.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cxb.wmx.entity.Disreplylike;

public interface DisreplylikeRepository
		extends JpaRepository<Disreplylike, Integer>, JpaSpecificationExecutor<Disreplylike> {

	/**
	 * @author sun 给帖子评论的回复点赞
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@Query(value = "INSERT INTO tb_disreplylike (user_id, dispostreply_id,disreplylike_stuts)VALUES(?1 ,?2,1)", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer insertReplyLike(Integer userId, Integer dispostreplyId);

	/**
	 * @author sun 给帖子评论的回复点踩
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@Query(value = "INSERT INTO tb_disreplylike (user_id, dispostreply_id,disreplylike_stuts)VALUES(?1 ,?2,2)", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer insertReplyOut(Integer userId, Integer dispostreplyId);

	/**
	 * @author sun 查看该用户是否点过赞
	 * @param dispostId
	 * @param userId
	 * @return
	 */
	@Query(value = "SELECT COUNT(*) FROM tb_disreplylike  WHERE disreplylike_stuts=?1 AND user_id=?2 AND disreplylike_stuts=1", nativeQuery = true)
	public Integer seleteUserWhetherLikeThis(Integer dispostreplyId, Integer userId);

	/**
	 * @author sun 查看该用户是否点过踩
	 * @param dispostId
	 * @param userId
	 * @return
	 */
	@Query(value = "SELECT COUNT(*) FROM tb_disreplylike  WHERE dispostreply_id=?1 AND user_id=?2 AND disreplylike_stuts=2", nativeQuery = true)
	public Integer seleteUserWhetherDisLikeThis(Integer dispostreplyId, Integer userId);

	/**
	 * @author sun 取消喜欢/踩
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@Query(value = "UPDATE tb_disreplylike  SET disreplylike_stuts = 0 WHERE user_id = ?1 AND dispostreply_id =?2 and disreplylike_stuts = 1", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer updateCancelLike(Integer userId, Integer dispostreplyId);

	/**
	 * @author sun 已点踩的用户点赞,改为点赞
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@Query(value = "UPDATE tb_disreplylike  SET disreplylike_stuts = 1 WHERE user_id =?1 AND dispostreply_id = ?2 AND disreplylike_stuts = 2", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer updateReplyLike(Integer userId, Integer dispostreplyId);

	/**
	 * @author sun 已点赞的用户点踩,改为点踩
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@Query(value = "UPDATE tb_disreplylike  SET disreplylike_stuts = 2 WHERE user_id =?1 AND dispostreply_id = ?2 AND disreplylike_stuts = 1", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer updateReplyOut(Integer userId, Integer dispostreplyId);

	/**
	 * @author sun 查询帖子评价回复的点赞数
	 * @param dispostId
	 * @return
	 */
	@Query(value = "SELECT COUNT(*) FROM tb_disreplylike WHERE dispostreply_id=?1 and disreplylike_stuts=1", nativeQuery = true)
	public Integer selectReplyLikeCount(Integer dispostreplyId);

	/**
	 * @author sun 查询帖子评价回复的点踩数
	 * @param dispostId
	 * @return
	 */
	@Query(value = "SELECT COUNT(*) FROM tb_disreplylike WHERE dispostreply_id=?1 and disreplylike_stuts=2", nativeQuery = true)
	public Integer selectReplyDisLikeCount(Integer dispostreplyId);
}
