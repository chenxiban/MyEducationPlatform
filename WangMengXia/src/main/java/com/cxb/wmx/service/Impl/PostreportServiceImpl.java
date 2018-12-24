package com.cxb.wmx.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.wmx.dao.PostRpository;
import com.cxb.wmx.dao.PostreportRrpository;
import com.cxb.wmx.dao.ReportcountRpository;
import com.cxb.wmx.entity.Post;
import com.cxb.wmx.entity.Postreport;
import com.cxb.wmx.entity.Reportcount;
import com.cxb.wmx.service.PostreportService;
import com.cxb.wmx.service.ReportcountService;
import com.cxb.wmx.util.IsEmptyUtils;

@Service
public class PostreportServiceImpl implements PostreportService {

	@Autowired
	private PostreportRrpository postreportRrpository;
	
	@Autowired
	private PostRpository postRpository;
	
	@Autowired
	private ReportcountRpository reportcountRpository;
	
	/**
	 * 添加举报信息
	 * @param p
	 * @return
	 */
	@Override
	public boolean savePostreport(Postreport p,int postId) {
		try {
			Post post=postRpository.findByPostId(postId);
			p.setPost(post);
			p.setPostreportCreatetime(new Date());
			p.setPostreportStuts(0);
			
			postreportRrpository.save(p);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 根据状态查询举报
	 * @param postreportStuts
	 * @return
	 */
	@Override
	public Integer countPostreport(Integer postreportStuts) {
		return postreportRrpository.queryByStuts(postreportStuts);
	}
	
	/**
	 * 修改举报信息
	 * @param p
	 * @return
	 */
	@Override
	public boolean updPostreport(Postreport p) {
		try {
			Postreport p2=postreportRrpository.findByPostreportId(p.getPostreportId());
			p2.setPostreportStuts(p.getPostreportStuts());
			p2.getPost().setPostReport(1);
			postreportRrpository.save(p2);
			
			System.out.println(p2.getPost().getPostId());
			Post post=postRpository.findByPostId(p2.getPost().getPostId());
			if (!IsEmptyUtils.isEmpty(p.getReportcountContent())) {
				Reportcount reportcount=new Reportcount();
				reportcount.setPost(post);
				reportcount.setReportcountContent(p.getReportcountContent());
				reportcount.setReportcountCreatetime(new Date());
				reportcount.setUserId(p2.getUserId());
				
				reportcountRpository.save(reportcount);
			}else {
				Reportcount reportcount=new Reportcount();
				reportcount.setReportcountContent("您的帖子因为含有不良信息举报审核通过已被封禁");
				reportcount.setReportcountCreatetime(new Date());
				reportcount.setUserId(p2.getUserId());
				reportcount.setPost(post);
				
				reportcountRpository.save(reportcount);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 根据状态查询举报
	 * @param postreportStuts
	 * @return
	 */
	@Override
	public List<Postreport> findByPostreportStuts(Integer postreportStuts) {
		return postreportRrpository.findByPostreportStuts(postreportStuts);
	}
	
}
