package com.cxb.cyj.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.cyj.dao.PsotTuiRepository;
import com.cxb.cyj.entity.PsotTui;
import com.cxb.cyj.service.PsotTuiService;

/**
 * 
 * @Description: 帖子推荐业务实现类
 * @ClassName: PsotTuiServiceImpl.java
 * @author ChenYongJia
 * @Date 2018年12月04日 下午20:40:56
 * @Email 867647213@qq.com
 */
@Service
public class PsotTuiServiceImpl implements PsotTuiService {

	@Autowired
	private PsotTuiRepository psotTuiRepository;

	/**
	 * 添加推荐帖子
	 * 
	 * @param psotTui
	 * @return
	 */
	@Override
	public boolean savePostTui(PsotTui psotTui) {
		return psotTuiRepository.save(psotTui) == null ? false : true;
	}

	/**
	 * 删除推荐帖子
	 * 
	 * @param postId
	 * @return
	 */
	@Override
	public boolean delPsotTui(Integer postId) {
		return psotTuiRepository.deleteBatch(postId) > 0 ? true : false;
	}

	/**
	 * 查询推荐总数
	 * 
	 * @return
	 */
	@Override
	public Integer countPostTui() {
		return psotTuiRepository.findAll().size();
	}

	/**
	 * 查询推荐帖子的id
	 * 
	 * @return
	 */
	@Override
	public List<Integer> countPostTuiPostId() {
		List<PsotTui> list = psotTuiRepository.findAll();
		List<Integer> list2 = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			list2.add(list.get(i).getPostId());
		}
		return list2;
	}

}
