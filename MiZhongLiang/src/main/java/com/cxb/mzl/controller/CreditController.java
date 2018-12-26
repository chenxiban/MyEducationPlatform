package com.cxb.mzl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.mzl.service.CreditService;

/**
*@author 作者 E-mail 谢立博 13837051752@163.com
*@version 创建时间:2018年12月21日下午3:54:24
*类说明
*/

@RestController
@RequestMapping(value = "/credit", name = "学分及所有课程模块")
public class CreditController {
	@Autowired
	private CreditService creditService;
	/**
	 * http://locahost:3011/mizhongliang/MiZhongLiang/credit/getStudentCredit
	 * */
	@RequestMapping("/getStudentCredit") 
	public double getStudentCredit(Integer studentId) {
		return creditService.getStudentCredit(studentId);
	}
	/**
	 * http://locahost:3011/mizhongliang/MiZhongLiang/credit/getStudentCreditByCurrId
	 * */
	@RequestMapping("/getStudentCreditByCurrId") 
	public double getStudentCreditByCurrId(@RequestParam("currId")Integer currId,@RequestParam("studentId")Integer studentId){
		return creditService.getStudentCreditByCurrId(currId, studentId);
	}
	/**
	 * http://locahost:3011/mizhongliang/MiZhongLiang/credit/getCurrAndCoverMap
	 * */
	@RequestMapping("/getCurrAndCoverMap") 
	public Object getCurrAndCoverMap() {
		return creditService.getCurrAndCoverMap();
	}
}
