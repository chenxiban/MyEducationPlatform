package com.cxb.mzl.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
*@author 作者 E-mail 谢立博 13837051752@163.com
*@version 创建时间:2018年12月21日下午3:44:54
*类说明   查询学生总学分 根据课程查询学生学分 ---》个人中心
*		获取所有课程信息及课程封面图(首页)----》首页
*		调用张冰倩组服务
*/



@FeignClient("zhangbingqian")
public interface CreditService {
	
	@RequestMapping("/ZhangBingQian/studentCredit/getStudentCredit")
	public double getStudentCredit(Integer studentId);
	
	@RequestMapping("/ZhangBingQian/studentCredit/getStudentCreditByCurrId")
	public double getStudentCreditByCurrId(@RequestParam("currId")Integer currId,@RequestParam("studentId")Integer studentId);
	
	@RequestMapping("/ZhangBingQian/curriculum/getCurrAndCoverMap")
	public Object getCurrAndCoverMap();
}
