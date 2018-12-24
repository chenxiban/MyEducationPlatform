package com.cxb.wmx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.wmx.dao.DisBarRepository;
import com.cxb.wmx.entity.Disbar;
import com.cxb.wmx.entity.Dispost;
import com.cxb.wmx.service.DisbarService;

@Service
public class DisbarServiceImpl implements DisbarService{

	@Autowired
	private DisBarRepository disBarRepository;

	@Override
	public List<Disbar> selectAll() {
		return disBarRepository.findAll();
	}
	
	
}
