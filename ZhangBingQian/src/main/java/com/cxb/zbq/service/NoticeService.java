package com.cxb.zbq.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.zbq.entity.Notice;

public interface NoticeService {
	Notice getNewNoticeByCurrId(Integer currId);//通过课程id找到对应的最新公告
	
	@Transactional@Modifying
	Notice insertNotice(Notice notice);//添加公告信息
	
	int updateNotice(Notice notice);//修改公告信息
	
	int deleteNotice(Integer noticeId);//删除公告信息
}
