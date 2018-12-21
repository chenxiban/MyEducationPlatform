package com.cxb.cyj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

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
	 * 查询推荐总数
	 * @return
	 */
	Integer findByPostId();
	
}
