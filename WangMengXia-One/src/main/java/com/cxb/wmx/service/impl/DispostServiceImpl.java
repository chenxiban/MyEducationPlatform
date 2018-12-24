package com.cxb.wmx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.wmx.dao.DisPostRepository;
import com.cxb.wmx.dao.DiscommitRepository;
import com.cxb.wmx.dao.DislikeRepository;
import com.cxb.wmx.entity.Discommit;
import com.cxb.wmx.entity.Dislike;
import com.cxb.wmx.entity.Dispost;
import com.cxb.wmx.service.DispostService;

@Service
public class DispostServiceImpl implements DispostService{

	@Autowired
	private DisPostRepository disPostRepository;
	@Autowired
	private DiscommitRepository discommitRepository;
	@Autowired
	private DislikeRepository dislikeRepository;
	@Override
	public List<Dispost> selectListDispostById(List<Integer> pid) {
		return disPostRepository.selectListDispostById(pid);
	}
	@Override
	public List<Dispost> queryPageTop(Integer page, Integer rows) {
		List<Discommit> list = discommitRepository.selectDisPostByTop();
		List<Integer> list2 = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			list2.add(list.get(i).getDispost().getDispostId());
		}
		List<Dispost> list3 = disPostRepository.queryByTopById(list2, (page-1), rows);
		return list3;
	}
	@Override
	public List<Dispost> selectPostListByTopD(Integer page, Integer rows) {
		List<Dislike> list = dislikeRepository.selectDisPostListByTopD();
		List<Integer> list2 = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			list2.add(list.get(i).getDispost().getDispostId());
		}
		List<Dispost> list3 = disPostRepository.queryByTopById(list2, (page-1), rows);
		return list3;
	}
	@Override
	public List<Dispost> selectPostListByTopC(Integer page, Integer rows) {
		List<Dislike> list = dislikeRepository.selectDisPostListByTopC();
		List<Integer> list2 = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			list2.add(list.get(i).getDispost().getDispostId());
		}
		List<Dispost> list3 = disPostRepository.queryByTopById(list2, (page-1), rows);
		return list3;
	}

}
