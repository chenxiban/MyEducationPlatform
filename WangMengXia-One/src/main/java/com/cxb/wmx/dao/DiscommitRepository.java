package com.cxb.wmx.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.wmx.entity.Discommit;
import com.cxb.wmx.entity.Dispost;

public interface DiscommitRepository extends JpaRepository<Discommit, Integer>, JpaSpecificationExecutor<Discommit> {

	/**
	 * @author sun 查询帖子评价数
	 * @param dispostId
	 * @return
	 */
	@Query(value = "SELECT COUNT(*) FROM tb_discommit WHERE dispost_id=?1 ", nativeQuery = true)
	public Integer selectCommentLikeCount(Integer dispostId);

	/**
	 * @author sun 给帖子添加一条评论
	 * @param discommitCount
	 * @param discommitName
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@Query(value = "insert into wangonepost.tb_discommit ( discommit_count, discommit_createtime, discommit_name, user_id, dispost_id ) values ( ?1, now(),?2, ?3 , ?4 )", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer insertCommentFromTheme(String discommitCount, String discommitName, Integer userId,
			Integer dispostId);

	/**
	 * @author sun 修改评论
	 * @param discommitCount
	 * @param discommitId
	 * @return
	 */
	@Query(value = "update tb_discommit  set discommit_count = ?1  where discommit_id = ?2 ", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer updateCommentByCommentId(String discommitCount, int discommitId);

	/**
	 * @author sun
	 * 
	 * @param discommitId
	 * @param page
	 * @param rows
	 * @return
	 */
	@Query(value = "SELECT discommit_id, discommit_count, discommit_createtime, discommit_name, discommit_report, discommit_updatetime, user_id, dispost_id, page, ROWS FROM  tb_discommit WHERE dispost_id=?1 ORDER BY discommit_createtime  DESC LIMIT ?2, ?3", nativeQuery = true)
	public List<Discommit> selectDiscommentByDispostIdOrderByDiscommitCreatetime(Integer discommitId, int page,
			int rows);

	/**
	 * @author sun 
	 * 查询评论最多的前十条帖子
	 * @return
	 */
	@Query(value = "SELECT discommit_id, discommit_count, discommit_createtime, discommit_name, discommit_report, discommit_updatetime, user_id, dispost_id,page,rows, COUNT(discommit_id) AS total FROM  tb_discommit  GROUP BY dispost_id ORDER BY total DESC", nativeQuery = true)
	public List<Discommit> selectDiscommentHot();
	
	/**
	 * @author sun
	 * 分页查询评论最多帖子根据上面查询的前十条帖子Id
	 * @param list
	 * @param page
	 * @param rows
	 * @return
	 */
	@Query(value="select * from tb_dispost where dispost_id in (:list) limit :page"+","+":rows",nativeQuery=true)
	public List<Dispost> seleteDispostByCommentIdPage(@Param(value="list")List<Integer> list,@Param(value="page")Integer page,@Param(value="rows")Integer rows);
	
	/**
	 * 评论最多的帖子desc
	 * @param postId
	 * @author 王梦霞
	 * @return
	 */
	@Query(value="SELECT discommit_id,discommit_count,discommit_createtime,discommit_name,discommit_report,discommit_updatetime,user_id,dispost_id,COUNT(dispost_id) AS number FROM tb_discommit GROUP BY dispost_id ORDER BY number DESC",nativeQuery=true)
	List<Discommit> selectDisPostByTop();
	
}
