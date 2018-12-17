package com.cxb.zbq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.zbq.entity.Notice;
import com.cxb.zbq.service.NoticeService;
import com.cxb.zbq.utils.Result;

@RestController
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="insertNotice",name="添加公告信息")
	public Object insertNotice(Notice notice) {
		if(noticeService.insertNotice(notice)!=null)
			return new Result("公告信息添加成功", 1);
		return new Result("公告信息添加失败", 0);
	}
	
	@RequestMapping(value="updateNotice",name="修改公告信息")
	public Object updateNotice(Notice notice) {
		if(noticeService.updateNotice(notice)>0)
			return new Result("公告信息修改成功", 1);
		return new Result("公告信息修改失败", 0);
	}
	
	@RequestMapping(value="deleteNotice",name="删除公告信息")
	public Object deleteNotice(Integer noticeId) {
		if(noticeService.deleteNotice(noticeId)>0)
			return new Result("公告信息删除成功", 1);
		return new Result("公告信息删除失败", 0);
	}

}
