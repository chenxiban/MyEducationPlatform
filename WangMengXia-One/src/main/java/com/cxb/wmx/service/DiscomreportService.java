package com.cxb.wmx.service;

import com.cxb.wmx.entity.Discomreport;

public interface DiscomreportService {

	//举报添加一条数据到举报表
	public boolean InsertDiscomreport(Discomreport discomreport,Integer discommentId);
}
