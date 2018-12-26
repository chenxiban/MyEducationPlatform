package com.cxb.wmx.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.dao.PostreportRrpository;
import com.cxb.wmx.entity.Postreport;
import com.cxb.wmx.entity.Result;
import com.cxb.wmx.service.PostreportService;
import com.cxb.wmx.service.ReportcountService;
import com.cxb.wmx.util.IsEmptyUtils;

/**
 * 帖子举报内容表
 * @author 王梦霞
 *
 */
@RestController
@RequestMapping(value="/postreport")
public class PostreportController {
	
	@Autowired
	private PostreportService postreportService;
	
	@Autowired
	private ReportcountService reportcountService;
	
	@Autowired
	private PostreportRrpository postreportRrpository;
	
	private Date date = new Date();
	private Timestamp timestamp = new Timestamp(date.getTime());
	
	/**
	 * 查询所有贴吧分类
	 * http://localhost:3011/wangmengxia/WangMengXia/postreport/savePostreport
	 * http://localhost:3030/WangMengXia/bar/savePostreport
	 * @param bar
	 * @return
	 * 王梦霞
	 */
	@RequestMapping(value="/savePostreport",name="添加举报信息",method=RequestMethod.POST)
	public Object savePostreport(Postreport postreport,int postId) {
		Postreport p=postreportRrpository.findChongFu(postreport.getUserId(),postId);
		
		if (!IsEmptyUtils.isEmpty(p)) {
			return new Result(false,"举报失败,当前帖子的举报信息还未处理无法再次举报");
		} else {
			if (postreportService.savePostreport(postreport,postId)) {
				return new Result(true,"举报成功,等待管理员审核");
			} else {
				return new Result(false,"举报失败");
			}
		}
		
	}
	
	/**
	 * 修改举报信息
	 * http://localhost:3011/wangmengxia/WangMengXia/postreport/updPostreport
	 * @param bar
	 * @return
	 * 王梦霞
	 */
	@RequestMapping(value="/updPostreport",name="修改举报信息",method=RequestMethod.PUT)
	public Object updPostreport(Postreport postreport) {
		if (postreport.getPostreportStuts()==1) {
			if (postreportService.updPostreport(postreport)) {
				return new Result(true,"审核成功,该帖子已被封禁");
			} else {
				return new Result(false,"审核失败");
			}
		} else {
			if (postreportService.updPostreport(postreport)) {
				return new Result(true,"审核为不通过成功");
			} else {
				return new Result(false,"审核为不通过失败");
			}
		}
	}
	
	/**
	 * 查询所有贴吧分类
	 * http://localhost:3011/wangmengxia/WangMengXia/postreport/countPostreport
	 * @param bar
	 * @return
	 * 王梦霞
	 */
	@RequestMapping(value="/countPostreport",name="查询举报总数",method=RequestMethod.GET)
	public Object countPostreport(Integer postreportStuts) {
		if (postreportStuts==1) {
			return postreportService.countPostreport(postreportStuts);
		} else if (postreportStuts==2) {
			return postreportService.countPostreport(postreportStuts);
		} else {
			return postreportService.countPostreport(postreportStuts);
		}
		
	}
	
	/**
	 * 查询所有贴吧分类
	 * http://localhost:3011/wangmengxia/WangMengXia/postreport/findByPostreportStuts
	 * @param bar
	 * @return
	 * 王梦霞
	 */
	@RequestMapping(value="/findByPostreportStuts",name="根据审核状态查询举报信息",method=RequestMethod.GET)
	public Object findByPostreportStuts(Integer postreportStuts) {
		if (postreportStuts==0) {
			// 查询审核为待审核的0
			return postreportService.findByPostreportStuts(postreportStuts);
		} else if (postreportStuts==1) {
			// 查询审核为通过的1
			return postreportService.findByPostreportStuts(postreportStuts);
		} else {
			// 查询审核为不通过的2
			return postreportService.findByPostreportStuts(postreportStuts);
		}
		
	}
	
}
