package com.cxb.wmx.service;

import java.util.List;

import com.cxb.wmx.entity.Dispost;

public interface ThemeDetailsService {

	public Dispost selectDispostById(Integer dispostId);
/*	public Dispost selectThemeDetailsByDispostId(int dispostId);
	public Discommit selectDiscommitByDispost(int dispost);
	public Discommit selectDispostreplyByDiscommit(int discommit);
	
	public Dispost selectAllPost(Integer pid);*/
	public boolean addPost(Dispost post);
	
	public List<Dispost> getAllPost();
	public Integer updateThemeByDispostId(String dispostTitle,String dispostCount,int dispostId);
	public Integer selectThemeByDispostId(Integer dispostId);
	public Integer selectDispostWhetherLike(Integer dispostId);
	public Integer deleteDislikeByDispostId(Integer dispost);
}
