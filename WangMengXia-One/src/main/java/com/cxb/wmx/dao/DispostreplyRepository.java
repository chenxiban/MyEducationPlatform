package com.cxb.wmx.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

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
}
