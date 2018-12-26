package com.cxb.wmx.service;

import com.cxb.wmx.entity.Disreport;

public interface DisreportService {

	//举报添加一条数据到举报表
	public boolean InsertDisreport(Disreport disreport,Integer dispostId);
	//public int updateDispostreport(Integer dispostId);
}
