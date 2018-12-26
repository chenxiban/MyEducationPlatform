package com.cxb.wmx.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.keyvalue.repository.config.QueryCreatorType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cxb.wmx.entity.Dispostreply;

public interface DispostreplyRepository extends JpaRepository<Dispostreply, Integer>,JpaSpecificationExecutor<Dispostreply>{
	/**
	 * @author sun
	 * 修改回复
	 * @param discommitCount
	 * @param discommitId
	 * @return
	 */
	@Query(value="update tb_dispostreply  set dispostreply_name = ?1  where dispostreply_id = ?2 ",nativeQuery=true)
	@Modifying
	@Transactional
	public Integer updateReplyByDispostreplyId(String dispostreplyName,int dispostreplyId);
	
	/**
	 * 查询所有回复根据评论Id
	 * @param discommitId
	 * @return
	 */
	@Query(value="SELECT dispostreply_id, dispostreply_createtime,  dispostreply_name, dispostreply_report, dispostreply_updatetime, user_id, discommit_id FROM tb_dispostreply where discommit_id=?1 limit  ?2,?3",nativeQuery=true)
	public List<Dispostreply> selectReplyByCommentId(Integer discommitId,int page,int rows);
	
	/**
	 * @author sun
	 * 删除回复
	 * @param dispostreplyId
	 * @param userId
	 * @return
	 */
	@Query(value="DELETE FROM tb_dispostreply WHERE dispostreply_id IN (:dispostreplyId) AND user_id=:userId",nativeQuery=true)
	@Modifying
	@Transactional
	public Integer deleteReplyByDispostreplyIdAndUserId(@RequestParam(value="dispostreplyId")List<Integer> dispostreplyId,@RequestParam(value="userId")Integer userId);
	
	
	/**
	 * @author sun
	 * 删除回复
	 * @param dispostreplyId
	 * @param userId
	 * @return
	 */
	@Query(value="DELETE FROM tb_dispostreply WHERE dispostreply_id IN (:dispostreplyId)",nativeQuery=true)
	@Modifying
	@Transactional
	public Integer deleteReplyByDispostreplyId(@RequestParam(value="dispostreplyId")List<Integer> dispostreplyId);
	
	/**
	 * @author sun
	 * 删除回复时查看该回复是否有点赞踩
	 * SELECT disreplylike_id, disreplylike_createtime, disreplylike_stuts, disreplylike_updatetime, user_id, dispostreply_id FROM tb_disreplylike
	 * @param dispostreplyId
	 * @return
	 */
	@Query(value="SELECT COUNT(*) FROM tb_disreplylike WHERE dispostreply_id in (:dispostreplyId)",nativeQuery=true)
	public Integer selectDisreplyWhetherLike(@RequestParam(value="dispostreplyId")List<Integer> dispostreplyId);
	
	/**
	 * 删除回复下的所有点赞
	 * @param dispostreplyId
	 * @return
	 */
	@Query(value="DELETE FROM tb_disreplylike WHERE dispostreply_id in (?1) ",nativeQuery=true)
	@Modifying
	@Transactional
	public Integer deleteDisreplyLike(List<Integer> dispostreplyId);
	
	/**
	 * @author sun
	 * 删除评论时查看该评论是否有回复
	 * @param dispostreplyId
	 * @return
	 */
	@Query(value="SELECT dispostreply_id, dispostreply_createtime, dispostreply_name, dispostreply_report, dispostreply_updatetime, user_id, discommit_id  FROM tb_dispostreply WHERE discommit_id=?1",nativeQuery=true)
	public List<Dispostreply> selectDiscommentWhetherReply(Integer discommentId);
	
	/**
	 * @author sun
	 * 删除查询到的回复
	 * @param list
	 * @return
	 */
	@Query(value="DELETE FROM tb_dispostreply WHERE dispostreply_id IN (:discommentId)",nativeQuery=true)
	@Modifying
	@Transactional
	public Integer deleteReplyByDiseplyIdList(@RequestParam(value="discommentId")List<Integer> discommentId);
}
