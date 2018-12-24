package com.cxb.wmx.service;

import org.springframework.stereotype.Service;

import com.cxb.wmx.entity.Reportcount;

@Service
public interface ReportcountService {
	
	/**
	 * 添加举报回复内容
	 * @param reportcount
	 * @return
	 */
	boolean saveReportcount(Reportcount reportcount);
	
	/**
	 * 根据Id删除举报回复内容
	 * @param reportcountId
	 * @return
	 */
	boolean delReportcount(Integer reportcountId);
	
}
