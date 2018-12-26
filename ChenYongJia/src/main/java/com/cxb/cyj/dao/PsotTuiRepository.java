package com.cxb.cyj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.cyj.entity.PsotTui;

/**
 * 
 * @Description: 推荐帖子Dao接口
 * @ClassName: PsotTuiRepository.java
 * @author Chenyongjia
 * @Date 2018年11月12日 下午22:01
 * @Email 867647213@qq.com
 */
public interface PsotTuiRepository extends JpaRepository<PsotTui, Integer>, JpaSpecificationExecutor<PsotTui>  {
	
	/**
	 * 删除推荐帖子信息
	 * 
	 * @param stuList
	 * @return
	 * @author Chenyongjia
	 */
	@Query(value = "DELETE FROM tb_posttui WHERE post_id=:postId", nativeQuery = true)
	@Modifying
	@Transactional
	Integer deleteBatch(@Param(value = "postId") Integer postId);
	
}
