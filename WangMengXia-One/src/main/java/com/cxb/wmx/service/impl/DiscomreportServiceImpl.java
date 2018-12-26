package com.cxb.wmx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cxb.wmx.dao.DiscomreportRepository;
import com.cxb.wmx.entity.Discomreport;
import com.cxb.wmx.service.DiscomreportService;

public class DiscomreportServiceImpl implements DiscomreportService{

	@Autowired
	private DiscomreportRepository dcRep;
	

	@Override
	public boolean InsertDiscomreport(Discomreport discomreport, Integer discommentId) {
		try {
			dcRep.save(discomreport);//添加一条举报数据
			dcRep.updateDiscomreport(discommentId);//修改帖子举报状态
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
