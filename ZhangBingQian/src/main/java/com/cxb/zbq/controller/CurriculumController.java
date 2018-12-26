package com.cxb.zbq.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.zbq.OtherEntity.College;
import com.cxb.zbq.OtherEntity.SelectCurriculum;
import com.cxb.zbq.OtherEntity.TeacherCurriculum;
import com.cxb.zbq.OtherEntity.Usersdetails;
import com.cxb.zbq.entity.CoverMap;
import com.cxb.zbq.entity.Curriculum;
import com.cxb.zbq.entity.Notice;
import com.cxb.zbq.entity.ScoringStandard;
import com.cxb.zbq.entityquery.CurriculumQuery;
import com.cxb.zbq.feign.ChenFeign;
import com.cxb.zbq.feign.MiFeign;
import com.cxb.zbq.service.ChapterService;
import com.cxb.zbq.service.CoverMapService;
import com.cxb.zbq.service.CurriculumService;
import com.cxb.zbq.service.NoticeService;
import com.cxb.zbq.service.ScoringStandardService;
import com.cxb.zbq.utils.DataGrid;
import com.cxb.zbq.utils.Result;

/**
 * 课程信息管理Controller
 * @author zhangbingqian
 *
 */
@CrossOrigin
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
	@Autowired
	private CoverMapService covermapService;
	@Autowired
	private ChenFeign chenFeign;
	@Autowired
	private MiFeign miFeign;
	
	//http://localhost:3050/ZhangBingQian/curriculum/queryCurriculumByPage?curriculumName=s
	@RequestMapping(value="queryCurriculumByPage",name="多条件检索课程" ,method=RequestMethod.GET)
	public Object queryCurriculumByPage(CurriculumQuery currQuery) {
		//List<College> list=chenFeign.getCollegeInfos();
		List<Curriculum> pages=curriculumService.getCurriculumByPage(currQuery);
		////List<Usersdetails> usersdetails=miFeign.queryTeacherIdAndName();
		//for (int i = 0; i < list.size(); i++) {
			///for (int j = 0; j < pages.size(); j++) {
				///for (int m = 0; m < usersdetails.size(); m++) {
					///if (pages.get(j).getCurriculumCategoryId()==list.get(i).getCollegeId()) {
					//	pages.get(j).setCurriculumName(list.get(i).getCollegeName());
					//}
					///if (pages.get(j).getTeacherId()==usersdetails.get(m).getUsersId()) {
					///	pages.get(j).setTeacherName(usersdetails.get(m).getUsersName());
					//}
				//}
			//}
		//}
		return pages;
	}
	
	// http://localhost:3050/ZhangBingQian/curriculum/insertCurriculum?curriculumName=111
	@RequestMapping(value = "insertCurriculum", name = "添加课程信息" ,method=RequestMethod.POST)
	public Object insertCurriculum(@RequestBody Curriculum curriculum) {
		System.out.println(curriculum);
		if (curriculumService.findByCurriculumName(curriculum.getCurriculumName()) != null)
			return new Result("课程名已存在,请勿重复添加", 0);
		if (curriculumService.insertCurriculum(curriculum) != null)
			return new Result("课程" + curriculum.getCurriculumName() + "添加成功", 1);
		return new Result("课程" + curriculum.getCurriculumName() + "添加失败,请稍后再试", 0);
	}

	@RequestMapping(value = "updateCurriculum", name = "修改课程信息",method=RequestMethod.PUT)
	public Object updateCurriculum(@RequestBody Curriculum curriculum) {
		System.out.println(">>>>>>>>>"+curriculum);
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
	@RequestMapping(value = "deleteCurriculum", name = "删除课程信息",method=RequestMethod.DELETE)
	public Object deleteCurriculum(Integer curriculumId) {
		Curriculum curr = curriculumService.findBycurriculumId(curriculumId);
		if (curr.getWhetherToIssue() == 1) {
			return new Result("很抱歉,该课程已发布不能进行删除,可先下架再行操作", 0);
		}
		if (chapterService.findByCurriculumId(curriculumId).size() != 0)
			return new Result("很抱歉,该课程下还存有章节信息,请逐步删除", 0);
		if (curriculumService.deleteCurriculum(curriculumId) > 0) {
			scService.deleteScStan(curriculumId);// 删除课程对应的评分标准
			return new Result("课程删除成功", 1);
		}
		return new Result("课程删除失败", 0);
	}

	/**
	 * 服务提供：添加课程订阅人数+1
	 * 
	 * @param currId 课程id
	 * @return 是否成功 布尔
	 */
	@RequestMapping(value = "addSubscriptionNum", name = "添加课程订阅人数")
	public boolean addSubscriptionNum(Integer currId) {
		if (curriculumService.updateSubscriptionNum(currId) > 0) {
			return true;
		}
		return false;
	}
	/**
	 * 服务提供：减少课程订阅人数-1
	 * 
	 * @param currId 课程id
	 * @return 是否成功 布尔
	 */
	@RequestMapping(value = "delSubscriptionNum", name = "减少课程订阅人数")
	public boolean delSubscriptionNum(Integer currId) {
		if (curriculumService.delSubscriptionNum(currId) > 0) {
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
	 * @throws ParseException 
	 */
	@RequestMapping(value = "updateIsReleaseToTrue", name = "发布课程" ,method=RequestMethod.PUT)
	public Object updateIsReleaseToTrue(Integer currId,String startTime,String endTime) throws ParseException {
		ScoringStandard standard=scService.findByCurriculumId(currId);
		if (standard==null) {
			return new Result("该课程还没有设置学分评分标准,点击确定前往设置", 2);
		}
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date startDate=sdf.parse(startTime);
		 Date enDate=sdf.parse(endTime);
		Result result = this.isTimeTrue(startDate, enDate);//判断时间是否符合格式
		if (result.getState() == 0)
			return result;
		if (curriculumService.updateIsReleaseToTrue(currId, startDate, enDate) > 0)
				return new Result("课程发布成功", 1);
		return new Result("课程发布失败,请稍后再试", 0);
	}
	
	@RequestMapping(value = "updateIsReleaseToFalse", name = "取消发布课程" ,method=RequestMethod.POST)
	public Object updateIsReleaseToFalse(Integer currId) {
		System.out.println(currId);
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
	//服务提供：获取所有课程信息及课程封面图
	@RequestMapping(value="getCurrAndCoverMap",name="获取所有课程信息及课程封面图")
	public Object getCurrAndCoverMap() {
		Map<String, Object> map = new HashMap<>();
		List<Curriculum> curriculums=curriculumService.getAllCurr();
		List<CoverMap> coverMaps=covermapService.getAllCovermap();
		map.put("curriculums", curriculums);
		map.put("coverMaps", coverMaps);
		return map;
	}
    
	//服务提供：根据订阅人数获取前20条课程信息
	@RequestMapping(value="getCurrIdBySubscriptionNum",name="根据订阅人数获取前20条课程数据")
	public Map<String, Object> getCurrIdBySubscriptionNum(){
		List<Curriculum> list=curriculumService.getCurrIdBySubscriptionNum();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("total", list.size());
		map.put("rows", list);
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
	@RequestMapping(value="queryCurriculumByteacherId",name="杨毅晨需要的方法，课程和章节")
	public Object queryCurriculumByteacherId() {
		Integer teacherIds=4;
		List<TeacherCurriculum> tList=curriculumService.queryByTeacherId(teacherIds);
		for (int i = 0; i < tList.size(); i++) {
			tList.get(i).setChildren(chapterService.findChapterById(tList.get(i).getCurriculumId()));
		}
		return tList;
	}
	@RequestMapping(value="queryAllIdAndName",name="用于课程的下拉列表")
	public Object queryAllIdAndName() {
		 Integer teacherId=4;
		 List<SelectCurriculum> list=curriculumService.queryAllIdAndName(teacherId);
		 return list;
	}
}
