package com.cxb.lhc.controller;
 
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.lhc.entity.StuCourseComment;
import com.cxb.lhc.entity.queryCountAndAvgState;
import com.cxb.lhc.service.StuCourseCommentService;
import com.cxb.lhc.util.Result;

/**
 * 
 * @Description:   学生对所选课程进行评价
 * @ClassName:     StuCourseCommentController
 * @author         liu
 * @Date           2018年12月10日 下午9:37:42
 * @Email          1273822019@qq.com
 */
@RestController
@RequestMapping("/stuCourseComment")
public class StuCourseCommentController {
	@Autowired
	private StuCourseCommentService stucoursecommentservice;
	/**
	 * 根据课程id
	 * 分页查询出该课程下所有的学生评价信息
	 * @param courseId
	 * @param page
	 * @param size
	 * @return
	 */
	//http://localhost:3011/LiHaiChao/stuCourseComment/getStuCourseCommentByPage?courseId=1&page=1&size=10
	@RequestMapping("/getStuCourseCommentByPage")
	Object getStuCourseCommentByPage(Integer courseId,Integer page,Integer size){
		 Map<String,Object> map=new HashMap<String,Object>();
		 Pageable pageable = PageRequest.of(page-1, size);
		// Page<StuCourseComment> sPage=stucoursecommentservice.getStuCourseCommentByPage(courseId, (page-1), size);
		 Page<StuCourseComment> sPage=stucoursecommentservice.findByCourseId(courseId, pageable);
		 List<StuCourseComment> rList=sPage.getContent();
		  long count=sPage.getTotalElements();
		  map.put("total", count);
		  map.put("rows", rList);
		  return map;
	}
	
	
	/**
	 * 根据课程id
	 * 该课程的评价总条数
	 * @param courseId
	 * @return
	 */
	//http://localhost:3011/LiHaiChao/stuCourseComment/queryCountNum?courseId=1
	@RequestMapping("/queryCountNum")
	Integer queryCountNum(Integer courseId) {
	 return stucoursecommentservice.queryCountNum(courseId);
 }
	/**
	 * 根据课程id 
	 * 查询出该课程的平均评价星级
	 * @param courseId
	 * @return
	 */
	//http://localhost:3011/LiHaiChao/stuCourseComment/queryCommentStart?courseId=1
	@RequestMapping("/queryCommentStart")
	double queryCommentStart(Integer courseId) {
		return stucoursecommentservice.queryCommentStart(courseId);
}

	/**学生对自己所选课程进行评价
	 * 向学生评价表中添加一条数据
	 * @param commentContext
	 * @param commentStart
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	//http://localhost:3011/LiHaiChao/stuCourseComment/saveStuCourseComment?commentContext=你好呀&commentStart=3&commentTime=2018-11-06&courseId=1&studentId=3
	@RequestMapping("/saveStuCourseComment")
	Result saveStuCourseComment(String commentContext,Integer commentStart,Integer courseId,Date commentTime,Integer studentId) {
		Integer nInteger=stucoursecommentservice.saveStuCourseComment(commentContext, commentStart,commentTime, courseId, studentId);
		Result result=new Result();
		if(nInteger>0) {
	    	result.setState(1);
	    	result.setMsg("感谢你的评价成功");
	    }else {
	    	result.setState(0);
	    	result.setMsg("评价失败");

	    }
		return result;
		
		
		
	}
	/**
	 * 学生根据评价id(主键)
	 * 对其课程评价进行编辑
	 * @param commentContext
	 * @param commentStart
	 * @param commentId
	 * @return
	 */
	//http://localhost:3011/LiHaiChao/stuCourseComment/upDateStuCourseComment?commentContext=你好呀&commentStart=3&commentId=3
	@RequestMapping("/upDateStuCourseComment")
	Result upDateStuCourseComment(String commentContext,Integer commentStart,Integer commentId) {	
		Integer nInteger=stucoursecommentservice.upDateStuCourseComment(commentContext, commentStart,commentId);
		Result result=new Result();
		if(nInteger>0) {
	    	result.setState(1);
	    	result.setMsg("感谢你的评价成功");
	    }else {
	    	result.setState(0);
	    	result.setMsg("评价失败");

	    }
		return result;
		
	}
	/**3.根据评价id(主键)
	 * 删除自己的评价 
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	//http://localhost:3011/LiHaiChao/stuCourseComment/delStuCourseComment?commentId=2
	@RequestMapping("/delStuCourseComment")
Result delStuCourseComment(Integer commentId) {
	Result result=new Result();
	Integer nInteger=stucoursecommentservice.queryCoursePraiseByCommentId(commentId);
	Integer nInteger3=0;
	if (nInteger>0) {
		Integer nInteger2=stucoursecommentservice.delCoursePraiseByCommentId(commentId);
		if(nInteger2>0) {
			nInteger3=stucoursecommentservice.delStuCourseComment(commentId);
			if(nInteger3>0) {
				result.setState(1);
		    	result.setMsg("你的评价删除成功");
			}else {
				result.setState(0);
		    	result.setMsg("你的评价删除失败");
			}
			
		}
	}else {
		nInteger3=stucoursecommentservice.delStuCourseComment(commentId);
		if(nInteger3>0) {
			result.setState(1);
	    	result.setMsg("你的删除评价成功");
		}else {
			result.setState(0);
	    	result.setMsg("你的评价删除失败");
		}
		
		
	}
	
	return result;	
	};
	

}
