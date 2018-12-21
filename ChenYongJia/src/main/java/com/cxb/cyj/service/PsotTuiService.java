package com.cxb.cyj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cxb.cyj.entity.PsotTui;

/**
 * 
 * @Description:   帖子推荐业务类
 * @ClassName:     PsotTuiService.java
 * @author         ChenYongJia
 * @Date           2018年12月04日 下午20:40:56
 * @Email          867647213@qq.com
 */
@Service
public interface PsotTuiService {
	
	/**
	 * 添加推荐帖子
	 * @param psotTui
	 * @return
	 */
	boolean savePostTui(PsotTui psotTui);
	
	/**
	 * 删除推荐帖子
	 * @param postId
	 * @return
	 */
	boolean delPsotTui(Integer postId);
	
	/**
	 * 查询推荐总数
	 * @return
	 */
	Integer countPostTui();
	
	/**
	 * 查询推荐帖子的id
	 * @return
	 */
	List<Integer> countPostTuiPostId();
	
}
