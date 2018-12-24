package com.cxb.wmx.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cxb.wmx.entity.Disclazzlike;

public interface DisclazzlikeRepository extends JpaRepository<Disclazzlike, Integer>,JpaSpecificationExecutor<Disclazzlike>{


	/**
	 * @author sun
	 * 给帖子评论点赞
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@Query(value="INSERT INTO tb_disclazzlike (user_id, discommit_id,disclazzlike_stuts)VALUES(?1 ,?2,1)",nativeQuery=true)
	@Modifying
	@Transactional
	public Integer insertCommitLike(Integer userId,Integer discommitId);
	
	/**
	 * @author sun
	 * 给帖子回复点踩
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@Query(value="INSERT INTO tb_disclazzlike (user_id, discommit_id,disclazzlike_stuts)VALUES(?1 ,?2,2)",nativeQuery=true)
	@Modifying
	@Transactional
	public Integer insertCommitOut(Integer userId,Integer discommitId);
	
	/**
	 * @author sun
	 * 查看该用户是否点过赞
	 * @param dispostId
	 * @param userId
	 * @return
	 */
	@Query(value="SELECT COUNT(*) FROM tb_disclazzlike  WHERE discommit_id=?1 AND user_id=?2 AND disclazzlike_stuts=1",nativeQuery=true)
	public Integer seleteUserWhetherLikeThis(Integer discommitId,Integer userId);

	/**
	 * @author sun
	 * 查看该用户是否点过踩
	 * @param dispostId
	 * @param userId
	 * @return
	 */
	@Query(value="SELECT COUNT(*) FROM tb_disclazzlike  WHERE discommit_id=?1 AND user_id=?2 AND disclazzlike_stuts=2",nativeQuery=true)
	public Integer seleteUserWhetherDisLikeThis(Integer discommitId,Integer userId);
	
	/**
	 * @author sun
	 * 取消喜欢/踩
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@Query(value="UPDATE tb_disclazzlike  SET disclazzlike_stuts = 0 WHERE user_id = ?1 AND discommit_id =?2 and disclazzlike_stuts = 1",nativeQuery=true)
	@Modifying
	@Transactional
	public Integer updateCancelLike(Integer userId,Integer discommitId);
	
	/**
	 * @author sun
	 * 已点踩的用户点赞,改为点赞
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@Query(value="UPDATE tb_disclazzlike  SET disclazzlike_stuts = 1 WHERE user_id =?1 AND discommit_id = ?2 AND disclazzlike_stuts = 2",nativeQuery=true)
	@Modifying
	@Transactional
	public Integer updateCommitLike(Integer userId,Integer discommitId);
	
	/**
	 * @author sun
	 * 已点赞的用户点踩,改为点踩
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@Query(value="UPDATE tb_disclazzlike  SET disclazzlike_stuts = 2 WHERE user_id =?1 AND discommit_id = ?2 AND disclazzlike_stuts = 1",nativeQuery=true)
	@Modifying
	@Transactional
	public Integer updateCommitOut(Integer userId,Integer discommitId);
	
	
	
	/**
	 * @author Administratorsu
	 * 查询帖子评价的点赞数
	 * @param dispostId
	 * @return
	 */
	@Query(value="SELECT COUNT(*) FROM tb_disclazzlike WHERE discommit_id=?1 and disclazzlike_stuts=1",nativeQuery=true)
	public Integer selectCommitLikeCount(Integer discommitId);
	
	/**
	 * @author Administratorsu
	 * 查询帖子评价的点踩数
	 * @param dispostId
	 * @return
	 */
	@Query(value="SELECT COUNT(*) FROM tb_disclazzlike WHERE discommit_id=?1 and disclazzlike_stuts=2",nativeQuery=true)
	public Integer selectCommitDisLikeCount(Integer discommitId);
}
