package com.cxb.wmx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.wmx.dao.ThemeDetailsRepository;
import com.cxb.wmx.entity.Discommit;
import com.cxb.wmx.entity.Dispost;
import com.cxb.wmx.service.ThemeDetailsService;

@Service
public class ThemeDetailsImpl implements ThemeDetailsService{
	@Autowired
	private ThemeDetailsRepository tdRep;
	/**
	 * 作者:孙可欣
	 * 查询指定的帖子详情
	 * @param dispostId
	 * @return
	 */
	@Override
	public Dispost selectDispostById(Integer dispostId) {
		//return tdRep.getOne(dispostId);
		return tdRep.selectThemeDetailsByDispostId(dispostId);
	}
	/**
	 * 作者:孙可欣
	 * 查询指定帖子评论
	 * @param dispost
	 * @return
	 */
/*	@Override
	public Discommit selectDiscommitByDispost(int dispost) {
		return tdRep.selectDiscommitByDispost(dispost);
	}*/
	/**
	 * 作者:孙可欣
	 * 查询指定帖子中评论的回复
	 * @param discommit
	 * @return
	 */
/*	@Override
	public Discommit selectDispostreplyByDiscommit(int discommit) {
		return tdRep.selectDispostreplyByDiscommit(discommit);
	}
	@Override
	public Dispost selectAllPost(Integer pid) {
		return tdRep.getOne(pid);
	}
*/
	@Override
	public boolean addPost(Dispost post) {
		try {
			 tdRep.save(post);
			 return true;
		} catch (Exception e) {
			return false;
		}
	}
	public List<Dispost> getAllPost(){
		return tdRep.findAll();
	}
	@Override
	public Integer updateThemeByDispostId(String dispostTitle,String dispostCount, int dispostId) {
		// TODO Auto-generated method stub
		return tdRep.updateThemeByDispostId(dispostTitle,dispostCount, dispostId);
	}

}
