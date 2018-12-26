package com.cxb.wmx.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.wmx.entity.Postcommit;
import com.cxb.wmx.entity.Postreply;
public interface PostreplyRpository extends JpaRepository<Postreply, Integer>, JpaSpecificationExecutor<Postreply>{
	
	/**
	 * 根据postreplyId查询Postreply回复
	 * @param postreplyId
	 * @return
	 * @author 王梦霞
	 */
	Postreply  findByPostreplyId(Integer postreplyid);
	
	/**
	 * 根据postcommit查询List<Postreply>
	 * @param postcommit
	 * @return
	 */
	List<Postreply> findByPostcommit(Postcommit postcommit);
	
	/**
	 * 根据评论id查询当前评论下是否存在回d
	 * @return
	 */
	@Query(value="SELECT postreply_id,postcommit_id FROM tb_postreply WHERE postcommit_id=:postcommitId",nativeQuery=true)
	Postreply selectByPostcommitId(@Param(value="postcommitId")Integer postcommitId);
	
	/**
	 * 根据评论id查询当前评论下是否存在回复
	 * @param postcommitId
	 * @return
	 */
	@Query(value="SELECT * FROM tb_postreply WHERE postcommit_id IN (:postcommitId)",nativeQuery=true)
	List<Postreply> selectByListId(@Param(value="postcommitId")List<Integer> postcommitId);
	
	/**
	 * 通过管理员的审查后的删除
	 * @param barId
	 * @return
	 */
	@Query(value="DELETE FROM  tb_postreply WHERE postreply_report =1 AND postreply_id =:hfId",nativeQuery=true)
	@Modifying
	@Transactional
	int deletePostreplyById(@Param(value="hfId") Integer hfId);
	
	
	/**
	 * @author 王梦霞
	 * 用户删除自己的回复
	 * @param hfId
	 * @return
	 */
	@Query(value="DELETE FROM  tb_postreply WHERE postreply_id =:hfId",nativeQuery=true)
	@Modifying
	@Transactional
	int deleteUserPostreplyById(@Param(value="hfId") Integer hfId);
	
	
	/**
	 * 根据回复id查询回复的点赞总数
	 * @author 王梦霞
	 * @param hfId
	 * @return
	 */
	
	@Query(value="SELECT COUNT(*) AS replyLike FROM tb_postreplylike WHERE postreply_id=:hfId AND postreplylike_stuts=1",nativeQuery=true)
	int queryPostReplyLikeByhfIdDz(@Param("hfId") Integer hfId);
	
	/**
	 * 根据回复id查询回复的踩赞总数
	 * @author 王梦霞
	 * @param hfId
	 * @return
	 */
	@Query(value="SELECT COUNT(*) AS replyLike FROM tb_postreplylike WHERE postreply_id=:hfId AND postreplylike_stuts=2",nativeQuery=true)
	int queryPostReplyLikeByhfIdCz(@Param("hfId") Integer hfId);
	
	/**
	 * 删除回复
	 * @param postcommitId
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="DELETE FROM tb_postreply WHERE postreply_id=:postreplyId AND postreply_report =1",nativeQuery=true)
	@Modifying
	@Transactional
	int deletePostReplyByIds(@Param(value="postreplyId") Integer postreplyId);
	
	
	/**
	 * 查询发表总回复
	 * @param userId	
	 * @return 刘森川
	 */
	@Query(value = "SELECT COUNT(*) FROM tb_postreply WHERE user_id=?1", nativeQuery = true) 
	int selectPostReplyCount(Integer userId);
	
	/**
	 * 查询发表回复的时间,内容,帖子id
	 * @param userId
	 * @return 刘森川
	 */
	@Query(value="SELECT postreply_count,postreply_createtime,postcommit_id FROM tb_postreply WHERE user_id=?1",nativeQuery = true)
	List<Integer> selectPostReplyCtime(Integer userId);
	
	/**
	 * 根据评论id查询回复基于那条评论
	 * @param userId
	 * @return 刘森川
	 */
	@Query(value="SELECT postcommit_count FROM tb_postcommit WHERE postcommit_id=?1",nativeQuery = true)
	List<String> selectPostReplyPostCom(Integer postId);
}
