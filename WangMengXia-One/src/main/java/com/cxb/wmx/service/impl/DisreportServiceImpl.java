package com.cxb.wmx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.wmx.dao.DisreportRepository;
import com.cxb.wmx.entity.Disreport;
import com.cxb.wmx.service.DisreportService;

@Service
public class DisreportServiceImpl implements DisreportService{

	@Autowired
	private DisreportRepository drRep;
	
	@Override
	public boolean InsertDisreport(Disreport disreport,Integer dispostId) {
		try {
			drRep.save(disreport);//添加一条举报数据
			drRep.updateDispostreport(dispostId);//修改帖子举报状态
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
