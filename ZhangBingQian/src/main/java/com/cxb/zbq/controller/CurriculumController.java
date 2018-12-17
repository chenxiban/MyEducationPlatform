package com.cxb.zbq.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.zbq.entity.Curriculum;
import com.cxb.zbq.entity.Notice;
import com.cxb.zbq.entity.ScoringStandard;
import com.cxb.zbq.entityquery.CurriculumQuery;
import com.cxb.zbq.service.ChapterService;
import com.cxb.zbq.service.CurriculumService;
import com.cxb.zbq.service.NoticeService;
import com.cxb.zbq.service.ScoringStandardService;
import com.cxb.zbq.utils.DataGrid;
import com.cxb.zbq.utils.Result;

@RestController
@RequestMapping("/curriculum")
public class CurriculumController {
	@Autowired
	private CurriculumService curriculumService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private ChapterService chapterService;
	@Autowired
	private ScoringStandardService scService;
	
	//http://localhost:3050/ZhangBingQian/curriculum/queryCurriculumByPage?curriculumName=s
	@RequestMapping(value="queryCurriculumByPage",name="多条件检索课程")
	public Object queryCurriculumByPage(CurriculumQuery currQuery) {
		List<Curriculum> pages=curriculumService.getCurriculumByPage(currQuery);
		return pages;
	}
	
	/*@RequestMapping(value="queryCurriculumByPage",name="多条件分页检索课程")
	public Object queryCurriculumByPage(CurriculumQuery currQuery) {
		Pageable pageable = PageRequest.of(currQuery.getPage() - 1, currQuery.getRows(), Sort.Direction.ASC,
				"curriculumId");
		Page<Curriculum> pages=null;
		pages=curriculumService.queryCurriculumByPage(currQuery, pageable);
		long total=pages.getTotalElements();
		List<Curriculum> list=pages.getContent();
		return new DataGrid(total, list);
	}*/
	

	// http://localhost:3050/ZhangBingQian/curriculum/insertCurriculum?curriculumName=111
	@RequestMapping(value = "insertCurriculum", name = "添加课程信息")
	public Object insertCurriculum(Curriculum curriculum) {
		if (curriculumService.findByCurriculumName(curriculum.getCurriculumName()) != null)
			return new Result("课程名已存在,请勿重复添加", 0);
		if (curriculumService.insertCurriculum(curriculum) != null)
			return new Result("课程" + curriculum.getCurriculumName() + "添加成功", 1);
		return new Result("课程" + curriculum.getCurriculumName() + "添加失败,请稍后再试", 0);
	}

	@RequestMapping(value = "updateCurriculum", name = "修改课程信息")
	public Object updateCurriculum(Curriculum curriculum) {
		Result result = this.isTimeTrue(curriculum.getStartTime(), curriculum.getEndTime());
		if (result.getState() == 0)
			return result;
		if (curriculumService.findByCurriculumName(curriculum.getCurriculumName()) != null)
			return new Result("课程名已存在,请更换重试", 0);
		if (curriculumService.updateCurriculum(curriculum) > 0)
			return new Result("课程" + curriculum.getCurriculumName() + "修改成功", 1);
		return new Result("课程" + curriculum.getCurriculumName() + "修改失败", 0);
	}

	// http://localhost:3050/ZhangBingQian/curriculum/deleteCurriculum?curriculumId=1
	@RequestMapping(value = "deleteCurriculum", name = "删除课程信息")
	public Object deleteCurriculum(Integer curriculumId) {
		Curriculum curr = curriculumService.findBycurriculumId(curriculumId);
		if (curr.getWhetherToIssue() == 1) {
			return new Result("很抱歉,该课程已发布不能进行删除,可先下架再行操作", 0);
		}
		if (chapterService.getChapterListByCurriculumId(curriculumId).size() != 0)
			return new Result("很抱歉,该课程下还存有章节信息,请逐步删除", 0);
		if (curriculumService.deleteCurriculum(curriculumId) > 0) {
			scService.deleteScStan(curriculumId);// 删除课程对应的评分标准
			return new Result("课程删除成功", 1);
		}
		return new Result("课程删除失败", 0);
	}

	/**
	 * 服务提供：添加课程订阅人数
	 * 
	 * @param currId 课程id
	 * @return 是否成功 布尔
	 */
	@RequestMapping(value = "updateSubscriptionNum", name = "添加课程订阅人数")
	public boolean updateSubscriptionNum(Integer currId) {
		if (curriculumService.updateSubscriptionNum(currId) > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 发布课程
	 * @param currId
	 * @param startTime 开课时间
	 * @param endTime 结束时间
	 * @return 0：失败  1：成功  2：没有设置评分标准
	 */
	@RequestMapping(value = "updateIsReleaseToTrue", name = "发布课程")
	public Object updateIsReleaseToTrue(Integer currId,Date startTime,Date endTime) {
		ScoringStandard standard=scService.findByCurriculumId(currId);
		if (standard==null) {
			return new Result("该课程还没有设置学分评分标准,点击确定前往设置", 2);
		}
		Result result = this.isTimeTrue(startTime, endTime);//判断时间是否符合格式
		if (result.getState() == 0)
			return result;
		if (curriculumService.updateIsReleaseToTrue(currId, startTime, endTime) > 0)
				return new Result("课程发布成功", 1);
		return new Result("课程发布失败,请稍后再试", 0);
	}
	
	@RequestMapping(value = "updateIsReleaseToFalse", name = "取消发布课程")
	public Object updateIsReleaseToFalse(Integer currId) {
		if (curriculumService.updateIsReleaseToFalse(currId) > 0)
				return new Result("课程取消发布成功", 1);
		return new Result("课程取消发布失败,请稍后再试", 0);
	}

	/**
	 * 服务提供：根据课程id获取课程对应信息(课程相关及公告)
	 * http://localhost:3050/ZhangBingQian/curriculum/getCurrAndNoticeByCurrId?curriculumId=1
	 */
	@RequestMapping(value = "getCurrAndNoticeByCurrId", name = "根据课程id获取课程对应信息(课程相关及学习页公告)")
	public Object getCurrAndNoticeByCurrId(Integer curriculumId) {
		Map<String, Object> map = new HashMap<>();
		Curriculum curriculum = curriculumService.findBycurriculumId(curriculumId);
		Notice notice = noticeService.getNewNoticeByCurrId(curriculumId);// 获取课程学习页相关公告
		map.put("curriculum", curriculum);
		map.put("notice", notice);
		return map;
	}

	/**
	 * 判断时间是否符合标准
	 */
	public Result isTimeTrue(Date beginTime, Date endTime) {
		Date now = new Date();
		if (beginTime != null && beginTime.before(now))
			return new Result("开课时间不能早于当前时间", 0);
		if (beginTime != null && endTime != null && beginTime.after(endTime))
			return new Result("结束开课时间不能早于开课时间", 0);
		return new Result(" ", 1);
	}
}
