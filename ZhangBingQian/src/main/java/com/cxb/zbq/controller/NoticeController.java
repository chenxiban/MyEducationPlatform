package com.cxb.zbq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.zbq.entity.Notice;
import com.cxb.zbq.service.CurriculumService;
import com.cxb.zbq.service.NoticeService;
import com.cxb.zbq.utils.Result;
@CrossOrigin
@RestController
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private CurriculumService currService;

	@RequestMapping(value = "getAllNotice", name = "查询所有公告信息",method=RequestMethod.GET)
	public Object getAllNotice(Integer teaId) {
		System.out.println(teaId);
		List<Notice> list = noticeService.findByTeacherId(teaId);
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				int currId = list.get(i).getCurriculumId();
				System.out.println(">>>>"+currId);
				String currName = currService.getCurrNameByCurrId(currId);
				list.get(i).setCurriculumName(currName);
			}
		}
		return list;
	}

	@RequestMapping(value = "insertNotice", name = "添加公告信息")
	public Object insertNotice(Notice notice) {
		if (noticeService.insertNotice(notice) != null)
			return new Result("公告信息添加成功", 1);
		return new Result("公告信息添加失败", 0);
	}

	@RequestMapping(value = "updateNotice", name = "修改公告信息")
	public Object updateNotice(Notice notice) {
		if (noticeService.updateNotice(notice) > 0)
			return new Result("公告信息修改成功", 1);
		return new Result("公告信息修改失败", 0);
	}

	@RequestMapping(value = "deleteNotice", name = "删除公告信息",method=RequestMethod.DELETE)
	public Object deleteNotice(Integer noticeId) {
		if (noticeService.deleteNotice(noticeId) > 0)
			return new Result("公告信息删除成功", 1);
		return new Result("公告信息删除失败", 0);
	}

	@RequestMapping(value = "isNewOfNotice", name = "判断当前要修改的是不是最新公告",method=RequestMethod.GET)
	public boolean isNewOfNotice(Integer noticeId, Integer curriculumId) {
		Notice notice = noticeService.getNewNoticeByCurrId(curriculumId);
		int nId = notice.getNoticeId();
		if (noticeId != nId) {
			return false;
		}
		return true;
	}

}
