package com.cxb.lhc.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.lhc.entity.StuCourseComment;
import com.cxb.lhc.service.StuCourseCommentClient;
import com.cxb.lhc.service.StuCourseCommentService;
import com.cxb.lhc.service.StuGivePraiseService;
import com.cxb.lhc.util.Result;

/**
 * 
 * @Description: 学生对所选课程进行评价
 * @ClassName: StuCourseCommentController
 * @author liu
 * @Date 2018年12月10日 下午9:37:42
 * @Email 1273822019@qq.com
 */
@RestController
@RequestMapping("/stuCourseComment")
public class StuCourseCommentController {
	@Autowired
	private StuCourseCommentService stucoursecommentservice;
	@Autowired
	private StuGivePraiseService stugivepraiseservice;
	@Autowired
	private StuCourseCommentClient stucoursecommentclient;
	
	
	
	/**
	 * 根据课程id 
	 * 分页查询出该课程下所有的学生评价信息
	 * @param courseId
	 * @param page
	 * @param size
	 * @return
	 */
	// http://localhost:3011/lihaichao/LiHaiChao/stuCourseComment/getStuCourseCommentByPage?courseId=1&page=1&size=10
	@RequestMapping(value="/getStuCourseCommentByPage",method = RequestMethod.GET)
	Object getStuCourseCommentByPage(@RequestParam(value="courseId")Integer courseId, @RequestParam(value="page")Integer page, @RequestParam(value="size")Integer size) {
		System.out.println(courseId+""+page+""+size);
		Map<String, Object> map = new HashMap<String, Object>();
		Pageable pageable = PageRequest.of(page - 1, size);
		Page<StuCourseComment> sPage = stucoursecommentservice.findByCourseId(courseId, pageable);
				 
		List<StuCourseComment> rList = sPage.getContent();
		long count = sPage.getTotalElements();
		Integer commentId=0;
		Integer gnum=0;
		//遍历评价集合
		for (int i = 0; i < rList.size(); i++) {

			//获取每个评价id
			commentId=rList.get(i).getCommentId();
			System.out.println(commentId+"uuuuuuuuuuuuuuuuu");
			//根据评价id和点赞状态获取点赞数量
			gnum=stugivepraiseservice.queryPraiseNumByCommentId(commentId, 1);
			System.out.println(gnum+"ppppppppppppppppppppppp");
			//把点赞数量设置给评价实体类中的点赞数量属性
			rList.get(i).setGiveParaiseNum(gnum);
			//根据评价id和踩赞状态获取踩赞数量
			Integer cainum=stugivepraiseservice.queryFootPraiseNumByCommentId(commentId, 1);
			//把踩赞数量设置给评价实体类中的踩赞数量属性
			rList.get(i).setCaiParaiseNum(cainum);
			

			
		}
		
		
		map.put("total", count);
		map.put("rows", rList);
		return map;
	}

	/**
	 * 调用小米组的方法 
	 * 根据课程id查询出该门课的老师信息
	 * @param courseId
	 * @return
	 */
	// http://localhost:3011/lihaichao/LiHaiChao/stuCourseComment/queryTeacherByCourseId
	@RequestMapping(value="/queryTeacherByCourseId",method=RequestMethod.GET)
	Object queryTeacherByTeacherId(Integer teacherId) {
		return stucoursecommentclient.queryTeacherByTeacherId(teacherId);
	}


	/**
	 * 根据课程id 该课程的评价总条数
	 * 
	 * @param courseId
	 * @return
	 */
	// http://localhost:3011/lihaichao/LiHaiChao/stuCourseComment/queryCountNum?courseId=1
	@RequestMapping(value="/queryCountNum",method=RequestMethod.GET)
	Integer queryCountNum(Integer courseId) {
		return stucoursecommentservice.queryCountNum(courseId);
	}
	/**
	 * 根据课程id 查询出该课程的平均评价星级
	 * 
	 * @param courseId
	 * @return
	 */
	// http://localhost:3011/lihaichao/LiHaiChao/stuCourseComment/queryCommentStart?courseId=1
	@RequestMapping(value="/queryCommentStart",method=RequestMethod.GET)
	double queryCommentStart(Integer courseId) {
		double douu=stucoursecommentservice.queryCommentStart(courseId);
		douu = (double)Math.round(douu*100)/100;      
		return douu;
	}

	/**
	 * 学生对自己所选课程进行评价 向学生评价表中添加一条数据
	 * 
	 * @param commentContext
	 * @param commentStart
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	// http://localhost:3011/lihaichao/LiHaiChao/stuCourseComment/saveStuCourseComment?commentContext=你好呀&commentStart=3&commentTime=2018-11-06&courseId=1&studentId=3
	@RequestMapping(value="/saveStuCourseComment",method=RequestMethod.POST)
	Result saveStuCourseComment(String commentContext, Integer commentStart, Integer courseId,Integer studentId) {
		StuCourseComment stuCourseComment =new StuCourseComment();
		stuCourseComment.setCommentContext(commentContext);
		stuCourseComment.setCommentStart(commentStart);
		stuCourseComment.setCourseId(courseId);
		stuCourseComment.setStudentId(studentId);
		stuCourseComment.setCommentTime(new Date());
		StuCourseComment sComment=stucoursecommentservice.saveStuCourseComment(stuCourseComment);
		Result result = new Result();
		if (sComment!=null) {
			result.setState(1);
			result.setMsg("感谢你的评价成功");
		} else {
			result.setState(0);
			result.setMsg("评价失败");

		}
		return result;

	}

	/**
	 * 学生根据评价id(主键) 对其课程评价进行编辑
	 * 
	 * @param commentContext
	 * @param commentStart
	 * @param commentId
	 * @return
	 */
	// http://localhost:3011/lihaichao/LiHaiChao/stuCourseComment/upDateStuCourseComment?commentContext=你好呀&commentStart=3&commentId=3
	@RequestMapping(value="/upDateStuCourseComment",method=RequestMethod.PUT)
	Result upDateStuCourseComment(String commentContext, Integer commentStart, Integer commentId) {
		Integer nInteger = stucoursecommentservice.upDateStuCourseComment(commentContext, commentStart, commentId);
		Result result = new Result();
		if (nInteger > 0) {
			result.setState(1);
			result.setMsg("感谢你的评价成功");
		} else {
			result.setState(0);
			result.setMsg("评价失败");

		}
		return result;

	}

	/**
	 * 3.根据评价id(主键) 删除自己的评价
	 * 
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	// http://localhost:3011/lihaichao/LiHaiChao/stuCourseComment/delStuCourseComment?commentId=2
	@RequestMapping(value="/delStuCourseComment",method=RequestMethod.DELETE)
	Result delStuCourseComment(Integer commentId) {
		Result result = new Result();
		//根据评价id查询该评价下是否有点赞数
		Integer nInteger = stucoursecommentservice.queryCoursePraiseByCommentId(commentId);
		Integer nInteger3 = 0;
		if (nInteger > 0) {//该评价下有点赞数
			//有的话先删除点赞
			Integer nInteger2 = stucoursecommentservice.delCoursePraiseByCommentId(commentId);
			if (nInteger2 > 0) {
				//再删除评价
				nInteger3 = stucoursecommentservice.delStuCourseComment(commentId);
				if (nInteger3 > 0) {
					result.setState(1);
					result.setMsg("你的评价删除成功");
				} else {
					result.setState(0);
					result.setMsg("你的评价删除失败");
				}

			}
		} else {//该评价下没有有点赞数
			System.out.println("1111111111111");
			nInteger3 = stucoursecommentservice.delStuCourseComment(commentId);
			if (nInteger3 > 0) {
				result.setState(1);
				result.setMsg("你的删除评价成功");
			} else {
				result.setState(0);
				result.setMsg("你的评价删除失败");
			}

		}

		return result;
	};

}
