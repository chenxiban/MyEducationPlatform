package com.cxb.wmx.service.Impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.wmx.dao.PostReplypostRpository;
import com.cxb.wmx.dao.PostreplyRpository;
import com.cxb.wmx.entity.Postreply;
import com.cxb.wmx.entity.Postreplyreport;
import com.cxb.wmx.service.RrplypostService;
/**
 * 回复举报
 * @author 王梦霞
 *
 */
@Service
public class ReplypostServiceImpl implements RrplypostService{

	@Autowired
	private PostreplyRpository postreplyRpository;
	@Autowired
	private PostReplypostRpository postReplypostRpository;
	@Override
	public boolean savePostreply(Postreplyreport p, int postreplyId) {
		
		try {
			Postreply postreply=postreplyRpository.findByPostreplyId(postreplyId);
			p.setPostreply(postreply);
			p.setPostreplyreportCreatetime(new Date());
			p.setPostreplyreportStuts(0);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public Integer countPostreplyreport(Integer postreplyreportStuts) {
		return postReplypostRpository.queryByReplyreportStuts(postreplyreportStuts);
	}
	@Override
	public List<Postreplyreport> findByPostreplyreportStuts(Integer postreplyreportStuts) {
		return postReplypostRpository.findByPostreplyreportStuts(postreplyreportStuts);
	}
	@Override
	public boolean updPostreplyreport(Postreplyreport p) {
		try {
			Postreplyreport p2=postReplypostRpository.findByPostreplyreportId(p.getPostreplyreportId());
			p2.setPostreplyreportStuts(p.getPostreplyreportStuts());
			if (p.getPostreplyreportStuts()==1) {
				p2.getPostreply().setPostreplyReport(1);
				postReplypostRpository.save(p2);
			} else {
				p2.getPostreply().setPostreplyReport(1);
				postReplypostRpository.save(p2);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

}
