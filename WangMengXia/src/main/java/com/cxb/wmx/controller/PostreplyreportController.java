package com.cxb.wmx.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.entity.Commitreport;
import com.cxb.wmx.entity.Postreplyreport;
import com.cxb.wmx.entity.Result;
import com.cxb.wmx.service.RrplypostService;

/**
 * 回复举报
 * @author 王梦霞
 *
 */
@RestController
@RequestMapping(value="/replyReport")
public class PostreplyreportController {

	@Autowired
	private RrplypostService replypostService;
	
	private Date date = new Date();
	private Timestamp timestamp = new Timestamp(date.getTime());
	
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/replyReport/savePostreply
	 * @author 王梦霞
	 * @param p
	 * @param postreplyId
	 * @return
	 */
	@RequestMapping(value="/savePostreply",name="添加回复举报",method=RequestMethod.POST)
	public Object savePostreply(Postreplyreport p,int postreplyId) {
		if (replypostService.savePostreply(p, postreplyId)) {
			return new Result(true,"举报成功,等待管理员的审核");
		} else {
			return new Result(false,"举报失败");
		}
	}
	
	/**
	 * 修改举报信息
	 * http://localhost:3011/wangmengxia/WangMengXia/replyReport/updPostReplyreport
	 * @param bar
	 * @return
	 * 王梦霞
	 */
	@RequestMapping(value="/updPostReplyreport",name="修改举报信息",method=RequestMethod.PUT)
	public Object updPostReplyreport(Postreplyreport postreplyreport) {
		if (postreplyreport.getPostreplyreportStuts()==1) {
			if (replypostService.updPostreplyreport(postreplyreport)) {
				return new Result(true,"审核成功,该回复已删除");
			} else {
				return new Result(false,"审核失败");
			}
		} else {
			if (replypostService.updPostreplyreport(postreplyreport)) {
				return new Result(true,"审核为不通过成功");
			} else {
				return new Result(false,"审核为不通过失败");
			}
		}
	}
	
	/**
	 * 查询所有贴吧分类
	 * http://localhost:3011/wangmengxia/WangMengXia/replyReport/countPostReplyreport
	 * @param bar
	 * @return
	 * 王梦霞
	 */
	@RequestMapping(value="/countPostReplyreport",name="查询举报总数",method=RequestMethod.GET)
	public Object countPostReplyreport(Integer postreplyreportStuts) {
		if (postreplyreportStuts==1) {
			return replypostService.countPostreplyreport(postreplyreportStuts);
		} else if (postreplyreportStuts==2) {
			return replypostService.countPostreplyreport(postreplyreportStuts);
		} else {
			return replypostService.countPostreplyreport(postreplyreportStuts);
		}
		
	}
	
	/**
	 * 查询所有贴吧分类
	 * http://localhost:3011/wangmengxia/WangMengXia/replyReport/findByPostReplyreportStuts
	 * @param bar
	 * @return
	 * 王梦霞
	 */
	@RequestMapping(value="/findByPostReplyreportStuts",name="根据审核状态查询举报信息",method=RequestMethod.GET)
	public Object findByPostReplyreportStuts(Integer postreplyreportStuts) {
		if (postreplyreportStuts==0) {
			// 查询审核为待审核的0
			return replypostService.findByPostreplyreportStuts(postreplyreportStuts);
		} else if (postreplyreportStuts==1) {
			// 查询审核为通过的1
			return replypostService.findByPostreplyreportStuts(postreplyreportStuts);
		} else {
			// 查询审核为不通过的2
			return replypostService.findByPostreplyreportStuts(postreplyreportStuts);
		}
		
	}
}
