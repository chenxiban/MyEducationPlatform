package com.cxb.wmx.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.wmx.dao.ReportcountRpository;
import com.cxb.wmx.entity.Reportcount;
import com.cxb.wmx.service.ReportcountService;

@Service
public class ReportcountServiceImpl implements ReportcountService {
	
	@Autowired
	private ReportcountRpository reportcountRpository;

	/**
	 * 添加举报回复内容
	 * @param reportcount
	 * @return
	 */
	@Override
	public boolean saveReportcount(Reportcount reportcount) {
		try {
			reportcountRpository.save(reportcount);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	/**
	 * 根据Id删除举报回复内容
	 * @param reportcountId
	 * @return
	 */
	@Override
	public boolean delReportcount(Integer reportcountId) {
		try {
			reportcountRpository.deleteById(reportcountId);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
}
