package com.cxb.wmx.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.wmx.entity.Postreply;
import com.cxb.wmx.entity.Postreplyreport;

/**
 * 回复举报dao
 * 
 * @author 王梦霞
 *
 */
public interface PostReplypostRpository
		extends JpaRepository<Postreplyreport, Integer>, JpaSpecificationExecutor<Postreplyreport> {

	/**
	 * 根据id查询Postreport
	 * @author 王梦霞
	 * @param postreportId
	 * @return
	 */
	Postreplyreport findByPostreplyreportId(Integer postreportId);

	/**
	 * 根据状态查询评论举报总数
	 * @author 王梦霞
	 * @param commitreportStuts
	 * @return
	 */
	@Query(value = "SELECT COUNT(postreply_id) FROM tb_postreplyreport WHERE postreplyreport_stuts =:postreplyreportStuts ", nativeQuery = true)
	Integer queryByReplyreportStuts(@Param(value = "postreplyreportStuts") Integer postreplyreportStuts);

	/**
	 * 根据状态查询举报信息
	 * @author 王梦霞
	 * @param commitreportStuts
	 * @return
	 */
	List<Postreplyreport> findByPostreplyreportStuts(Integer postreplyreportStuts);

	List<Postreplyreport> findByPostreply(Postreply postreply);
	
	@Query(value = "SELECT * FROM tb_postreplyreport WHERE postreply_Id IN(:postreplyId)", nativeQuery = true)
	List<Postreplyreport> findPostreply(@Param("postreplyId")List<Integer> postreplyId);

	/**
	 * 根据评论id删除举报信息
	 * 
	 * @param
	 * @return
	 */
	@Query(value = "DELETE FROM tb_postreplyreport WHERE postreply_id IN(:postreplyId)", nativeQuery = true)
	@Modifying
	@Transactional
	int deleteByLsitPostreplyId(@Param("postreplyId") List<Integer> postreplyId);
	
	/**
	 * 根据评论id删除举报信息
	 * 
	 * @param
	 * @return
	 */
	@Query(value = "DELETE FROM tb_postreplyreport WHERE postreply_id =:postreplyId", nativeQuery = true)
	@Modifying
	@Transactional
	int deleteByPostreplyId(@Param("postreplyId") Integer postreplyId);

}
