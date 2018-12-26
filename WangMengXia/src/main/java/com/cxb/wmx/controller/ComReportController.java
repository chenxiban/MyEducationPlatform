package com.cxb.wmx.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.dao.PostComRpository;
import com.cxb.wmx.entity.Commitreport;
import com.cxb.wmx.entity.Postcommit;
import com.cxb.wmx.entity.Postreport;
import com.cxb.wmx.entity.Result;
import com.cxb.wmx.service.CommitrepostService;
import com.netflix.discovery.converters.Auto;

/**
 * 评论举报控制层
 * @author 王梦霞
 *
 */
@RestController
@RequestMapping(value="/comReport")
public class ComReportController {

	@Autowired
	private CommitrepostService commitrepostService;
	@Autowired
	private PostComRpository postComRpository;
	
	private Date date = new Date();
	private Timestamp timestamp = new Timestamp(date.getTime());
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/comReport/saveComreport
	 * @author 王梦霞
	 * @param c
	 * @param postcommitId
	 * @return
	 */
	@RequestMapping(value="/saveComreport",name="添加评论举报信息",method=RequestMethod.POST)
	public Object saveComreport(Commitreport c, int postcommitId) {
		if (commitrepostService.saveComreport(c, postcommitId)) {
			return new Result(true,"举报成功,等待管理员审核");
		} else {
			return new Result(false,"举报失败");
		}
	}
	
	/**
	 * 修改举报信息
	 * http://localhost:3011/wangmengxia/WangMengXia/comReport/updPostCommitreport
	 * @param bar
	 * @return
	 * 王梦霞
	 */
	@RequestMapping(value="/updPostCommitreport",name="修改举报信息",method=RequestMethod.PUT)
	public Object updPostCommitreport(Commitreport commitreport) {
		if (commitreport.getCommitreportStuts()==1) {
			if (commitrepostService.updCommitreport(commitreport)) {
				return new Result(true,"审核成功,该评论已删除");
			} else {
				return new Result(false,"审核失败");
			}
		} else {
			if (commitrepostService.updCommitreport(commitreport)) {
				return new Result(true,"审核为不通过成功");
			} else {
				return new Result(false,"审核为不通过失败");
			}
		}
	}
	
	/**
	 * 查询所有贴吧分类
	 * http://localhost:3011/wangmengxia/WangMengXia/comReport/countPostCommitreport
	 * @param bar
	 * @return
	 * 王梦霞
	 */
	@RequestMapping(value="/countPostCommitreport",name="查询举报总数",method=RequestMethod.GET)
	public Object countPostCommitreport(Integer commitreportStuts) {
		if (commitreportStuts==1) {
			return commitrepostService.countCommitreport(commitreportStuts);
		} else if (commitreportStuts==2) {
			return commitrepostService.countCommitreport(commitreportStuts);
		} else {
			return commitrepostService.countCommitreport(commitreportStuts);
		}
		
	}
	
	/**
	 * 查询所有贴吧分类
	 * http://localhost:3011/wangmengxia/WangMengXia/comReport/findByPostComreportStuts
	 * @param bar
	 * @return
	 * 王梦霞
	 */
	@RequestMapping(value="/findByPostComreportStuts",name="根据审核状态查询举报信息",method=RequestMethod.GET)
	public Object findByPostComreportStuts(Integer commitreportStuts) {
		if (commitreportStuts==0) {
			// 查询审核为待审核的0
			return commitrepostService.findByCommitreportStuts(commitreportStuts);
		} else if (commitreportStuts==1) {
			// 查询审核为通过的1
			return commitrepostService.findByCommitreportStuts(commitreportStuts);
		} else {
			// 查询审核为不通过的2
			return commitrepostService.findByCommitreportStuts(commitreportStuts);
		}
		
	}
}
