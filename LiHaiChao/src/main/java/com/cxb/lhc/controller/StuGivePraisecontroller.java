package com.cxb.lhc.controller;
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.lhc.entity.StuCourseComment;
import com.cxb.lhc.entity.StuGivePraise;
import com.cxb.lhc.service.StuCourseCommentService;
import com.cxb.lhc.service.StuGivePraiseService;
import com.cxb.lhc.util.Result;
/**
 * 
 * @Description:   学生对所选课程评价进行点/踩赞
 * @ClassName:     StuGivePraisecontroller
 * @author         liu
 * @Date           2018年12月10日 下午9:37:42
 * @Email          1273822019@qq.com
 */
@RestController
@RequestMapping("/stuGivePraise")
public class StuGivePraisecontroller {
	@Autowired
	private StuGivePraiseService stugivepraiseservice;
	
	@Autowired
	private StuCourseCommentService stucoursecommentservice;
	
	
	/**
	 *  给课程评价进行点/取消赞 
	 *  向点赞表中添加一条数据
	 *  修改点赞状态为0
	 * @param commentId
	 * @param givePraiseState
	 * @param studentId
	 * @return
	 */
	//http://localhost:3011/lihaichao/LiHaiChao/stuGivePraise/saveStuGivePraise?studentId=1&commentId=1&givePraiseState=0
	@RequestMapping(value="/saveStuGivePraise",method=RequestMethod.POST)
	Result saveStuGivePraise(Integer studentId, Integer commentId) {
		Result result=new Result();
		
		StuGivePraise pcount=stugivepraiseservice.queryGiveParisByStuIdAndCommId(commentId, studentId);
		
		System.out.println("111111111111111");
		if(pcount!=null) {
			if(pcount.getGivePraiseState()==0) {
				Integer givecount=stugivepraiseservice.updGivePariseState(studentId, commentId, 1);
				System.out.println("22222222222222222222222");
				
				if(givecount>0) {
					//点赞成功后让该评价的点赞数量加1
					StuCourseComment comment=stucoursecommentservice.queryStuCourseCommentByCommentId(commentId);
					Integer  gnum=stugivepraiseservice.queryPraiseNumByCommentId(commentId, 1);
					comment.setGiveParaiseNum(gnum+1);
					result.setState(1);
					result.setMsg("点赞成功哦");
				}
				
			}else if(pcount.getGivePraiseState()==1){
				Integer updcount=stugivepraiseservice.updPariseState(studentId, commentId,0);
				System.out.println("3333333333333333333");
				if(updcount>0) {
					//取消赞成功后让该评价的点赞数量减1
					StuCourseComment comment=stucoursecommentservice.queryStuCourseCommentByCommentId(commentId);
					Integer  gnum=stugivepraiseservice.queryPraiseNumByCommentId(commentId, 1);
					comment.setGiveParaiseNum(gnum-1);
					result.setState(1);
					result.setMsg("你的赞取消成功");
				}
				
			}
			
			
		}else {
			Integer inscount=stugivepraiseservice.saveStuGivePraise(1, studentId, commentId);
		System.out.println("444444444444444444444444444");
			if(inscount>0) {
				//点赞成功后让该评价的点赞数量加1
				StuCourseComment comment=stucoursecommentservice.queryStuCourseCommentByCommentId(commentId);
				Integer  gnum=stugivepraiseservice.queryPraiseNumByCommentId(commentId, 1);
				comment.setGiveParaiseNum(gnum+1);
			result.setState(1);;
			result.setMsg("点赞成功哦");
		}
	}
		return result;
}
	/**
	 * 给课程评价进行踩/取消踩赞 
	 * @param studentId
	 * @param commentId
	 * @return
	 */
	//http://localhost:3011/lihaichao/LiHaiChao/stuGivePraise/updStuNoPraise?studentId=1&commentId=1
		@RequestMapping(value="/updStuNoPraise",method=RequestMethod.PUT)
		Result updStuNoPraise(Integer studentId, Integer commentId) {
			Result result=new Result();
			StuGivePraise pcount=stugivepraiseservice.queryGiveParisByStuIdAndCommId(commentId, studentId);
			System.out.println("6666666666666666666666");
			if(pcount!=null) {
				if(pcount.getNotPraiseState()==0) {
					System.out.println("7777777777777777777");
					Integer givecount=stugivepraiseservice.updNoPariseState(studentId, commentId, 1);
					if(givecount>0) {
						//踩赞成功后让该评价的踩赞数量加1
						StuCourseComment comment=stucoursecommentservice.queryStuCourseCommentByCommentId(commentId);
						Integer  cainum=stugivepraiseservice.queryFootPraiseNumByCommentId(commentId, 1);
						comment.setCaiParaiseNum(cainum+1);
						result.setState(1);
						result.setMsg("踩赞成功哦");
					}
				}else if(pcount.getNotPraiseState()==1){
					System.out.println("8888888888888888888");
					Integer updcount=stugivepraiseservice.updNoState(studentId, commentId,0);
					if(updcount>0) {
						//取消踩赞成功后让该评价的踩赞数量减1
						StuCourseComment comment=stucoursecommentservice.queryStuCourseCommentByCommentId(commentId);
						Integer  cainum=stugivepraiseservice.queryFootPraiseNumByCommentId(commentId, 1);
						comment.setCaiParaiseNum(cainum-1);
						result.setState(1);
						result.setMsg("你的踩赞取消成功");
					}
				}
				
				
			}
			return result;
	}
		
	
	
}
