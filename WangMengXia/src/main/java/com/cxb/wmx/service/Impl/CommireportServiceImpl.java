package com.cxb.wmx.service.Impl;

import java.util.Date;
import java.util.List;

import org.hibernate.boot.jaxb.hbm.spi.PluralAttributeInfoPrimitiveArrayAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.wmx.dao.ComReportRpository;
import com.cxb.wmx.dao.PostComRpository;
import com.cxb.wmx.entity.Commitreport;
import com.cxb.wmx.entity.Post;
import com.cxb.wmx.entity.Postcommit;
import com.cxb.wmx.entity.Postreport;
import com.cxb.wmx.entity.Reportcount;
import com.cxb.wmx.service.CommitrepostService;
import com.cxb.wmx.util.IsEmptyUtils;

@Service
public class CommireportServiceImpl implements CommitrepostService{

	@Autowired
	private PostComRpository postComRpository;
	@Autowired
	private ComReportRpository comReportRpository;
	@Override
	public boolean saveComreport(Commitreport c, int postcommitId) {
		try {
			Postcommit postcommit=postComRpository.findByPostcommitId(postcommitId);
			c.setPostcommit(postcommit);
			c.setCommitreportCreatetime(new Date());
			c.setCommitreportStuts(0);
			comReportRpository.save(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public Integer countCommitreport(Integer commitreportStuts) {
		return comReportRpository.queryByComStuts(commitreportStuts);
	}
	@Override
	public List<Commitreport> findByCommitreportStuts(Integer commitreportStuts) {
		return comReportRpository.findByCommitreportStuts(commitreportStuts);
	}
	@Override
	public boolean updCommitreport(Commitreport c) {
		try {
			Commitreport c2=comReportRpository.findByCommitreportId(c.getCommitreportId());
			c2.setCommitreportStuts(c.getCommitreportStuts());
			if (c.getCommitreportStuts()==1) {
				c2.getPostcommit().setPostcommitReport(1);
				comReportRpository.save(c2);
			} else {
				c2.getPostcommit().setPostcommitReport(2);
				comReportRpository.save(c2);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
