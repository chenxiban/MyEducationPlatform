package com.cxb.wmx.controller;

import java.util.Date;

import org.junit.runner.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.entity.Disreport;
import com.cxb.wmx.service.DisreportService;

@RestController
@RequestMapping(value = "/disreport")
public class DisreportController {

	@Autowired
	private DisreportService drSer;

	/**
	 * @author sun
	 *         http://localhost:3011/wangmengxia-one/WangMengXia-One/disreport/insertDisreport?dispostId=1
	 *         http://localhost:3031/WangMengXia-One/disreport/insertDisreport?userId=1&dispostId=1
	 * @param disreport
	 * @return
	 */
	@RequestMapping(value = "/insertDisreport")
	public Object insertDisreport(Disreport disreport,Integer dispostId) {
		
		return drSer.InsertDisreport(disreport,dispostId);
		
	}
}
