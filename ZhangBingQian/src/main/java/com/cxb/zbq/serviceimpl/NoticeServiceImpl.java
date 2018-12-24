package com.cxb.zbq.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.zbq.dao.NoticeRepository;
import com.cxb.zbq.entity.Notice;
import com.cxb.zbq.service.NoticeService;
@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeRepository noticeRepository;

	@Override
	public Notice getNewNoticeByCurrId(Integer currId) {
		return noticeRepository.getNewNoticeByCurrId(currId);
	}

	@Override
	public Notice insertNotice(Notice notice) {
		return noticeRepository.save(notice);
	}

	@Override
	public int updateNotice(Notice notice) {
		return noticeRepository.updateNotice(notice);
	}

	@Override
	public int deleteNotice(Integer noticeId) {
		return noticeRepository.deleteNotice(noticeId);
	}

	@Override
	public List<Notice> findByTeacherId(Integer teaId) {
		return noticeRepository.findByTeacherId(teaId);
	}

}
