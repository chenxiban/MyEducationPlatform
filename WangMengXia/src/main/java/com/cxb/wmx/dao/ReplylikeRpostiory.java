package com.cxb.wmx.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.wmx.entity.Postreply;
import com.cxb.wmx.entity.Postreplylike;

/**
 * 回复点赞踩赞到层
 * @author 王梦霞
 *
 */
public interface ReplylikeRpostiory extends JpaRepository<Postreplylike, Integer>, JpaSpecificationExecutor<Postreplylike>{
	
	/**
	 * 根据评论查询点赞踩赞数据
	 * @param postcommit
	 * @return
	 */
	List<Postreplylike> findByPostreply(Postreply postreply);
	
	/**
	 * 用户给回复点赞
	 * @param 
	 * @return
	 */
	@Query(value="SELECT * FROM tb_postreplylike WHERE postreply_id IN (:list2) GROUP BY postreply_id ",nativeQuery=true)
	List<Postreplylike> findList(@Param("list2")List<Integer> list2);
	
	/**
	 * 用户给回复点赞
	 * @param 
	 * @return
	 */
	@Query(value="INSERT INTO tb_postreplylike (postreply_id,user_id,postreplylike_stuts) VALUES (:replyId,:userId,1) ",nativeQuery=true)
	@Modifying
	@Transactional
	int addReplylikeDz(@Param("replyId")Integer replyId,@Param("userId")Integer userId);
	
	/**
	 * 用户给回复踩赞
	 * @param 
	 * @return
	 */
	@Query(value="INSERT INTO tb_postreplylike (postreply_id,user_id,postreplylike_stuts) VALUES (:replyId,:userId,2)",nativeQuery=true)
	@Modifying
	@Transactional
	int addReplylikeCz(@Param("replyId")Integer replyId,@Param("userId")Integer userId);
	
	/**
	 * 用户给回复取消点赞
	 * @param 
	 * @return
	 */
	@Query(value="DELETE FROM tb_postreplylike WHERE postreply_id=:replyId AND user_id=:userId",nativeQuery=true)
	@Modifying
	@Transactional
	int deleteReplylikeDz(@Param("replyId")Integer replyId,@Param("userId")Integer userId);
	
	/**
	 * 用户给回复取消点赞
	 * @param 
	 * @return
	 */
	@Query(value="DELETE FROM tb_postreplylike WHERE postreply_id=:replyId AND user_id=:userId",nativeQuery=true)
	@Modifying
	@Transactional
	int deleteReplylikeCz(@Param("replyId")Integer replyId,@Param("userId")Integer userId);

	/**
	 * 用户给回复点赞后进行踩赞的操作
	 * @param 
	 * @return
	 */
	@Query(value="UPDATE tb_postreplylike SET postreplylike_stuts=2 WHERE postreply_id=:replyId AND user_id=:userId",nativeQuery=true)
	@Modifying
	@Transactional
	int updateReplylikeDz(@Param("replyId")Integer replyId,@Param("userId")Integer userId);
	
	/**
	 * 用户给回复踩赞后进行点赞的操作
	 * @param 
	 * @return
	 */
	@Query(value="UPDATE tb_postreplylike SET postreplylike_stuts=1 WHERE postreply_id=:replyId AND user_id=:userId",nativeQuery=true)
	@Modifying
	@Transactional
	int updateReplylikeCz(@Param("replyId")Integer replyId,@Param("userId")Integer userId);

	/**
	 * 删除根据回复id
	 * @param 
	 * @return
	 */
	@Query(value="DELETE FROM tb_postreplylike WHERE postreply_id=:hfId",nativeQuery=true)
	@Modifying
	@Transactional
	int deleteByHfid(@Param("hfId")Integer hfId);
	
}
