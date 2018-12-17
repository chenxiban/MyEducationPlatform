package com.cxb.wmx.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cxb.wmx.dao.PostLikeRpository;
import com.cxb.wmx.entity.Postlike;
import com.cxb.wmx.entitysearch.BarSearch;
import com.cxb.wmx.service.PostLikeService;

@Service
public class PostLikeServiceImpl implements PostLikeService{

	@Autowired
	private PostLikeRpository postLikeRpository;
	@Override
	public List<Postlike> selectPostListByTopD() {
		return postLikeRpository.selectPostListByTopD();
	}

	@Override
	public List<Postlike> selectPostListByTopC() {
		return  postLikeRpository.selectPostListByTopC();
	}

	

}
