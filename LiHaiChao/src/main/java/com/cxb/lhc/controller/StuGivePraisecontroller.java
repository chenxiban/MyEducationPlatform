package com.cxb.lhc.controller;
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.lhc.entity.StuGivePraise;
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
	
	/**
	 *  给课程评价进行点/取消赞 
	 *  向点赞表中添加一条数据
	 *  修改点赞状态为0
	 * @param commentId
	 * @param givePraiseState
	 * @param studentId
	 * @return
	 */
	//http://localhost:3011/LiHaiChao/stuGivePraise/saveStuGivePraise?studentId=1&commentId=1&givePraiseState=0
	@RequestMapping("/saveStuGivePraise")
	Result saveStuGivePraise(Integer studentId, Integer commentId) {
		Result result=new Result();
		StuGivePraise pcount=stugivepraiseservice.queryGiveParisByStuIdAndCommId(commentId, studentId);
		if(pcount!=null) {
			if(pcount.getGivePraiseState()==0) {
				Integer givecount=stugivepraiseservice.updGivePariseState(studentId, commentId, 1);
				if(givecount>0) {
					result.setState(1);
					result.setMsg("点赞成功哦");
				}
			}else if(pcount.getGivePraiseState()==1){
				Integer updcount=stugivepraiseservice.updPariseState(studentId, commentId,0);
				if(updcount>0) {
					result.setState(1);
					result.setMsg("你的赞取消成功");
				}
			}
			
			
		}else {
			Integer inscount=stugivepraiseservice.saveStuGivePraise(1, studentId, commentId);
		if(inscount>0) 
			result.setState(1);;
			result.setMsg("点赞成功哦");
		}
		return result;
}
	/**
	 * 给课程评价进行踩/取消踩赞 
	 * @param studentId
	 * @param commentId
	 * @return
	 */
	//http://localhost:3011/LiHaiChao/stuGivePraise/updStuNoPraise?studentId=1&commentId=1
		@RequestMapping("/updStuNoPraise")
		Result updStuNoPraise(Integer studentId, Integer commentId) {
			Result result=new Result();
			StuGivePraise pcount=stugivepraiseservice.queryGiveParisByStuIdAndCommId(commentId, studentId);
			if(pcount!=null) {
				if(pcount.getNotPraiseState()==0) {
					Integer givecount=stugivepraiseservice.updNoPariseState(studentId, commentId, 1);
					if(givecount>0) {
						result.setState(1);
						result.setMsg("踩赞成功哦");
					}
				}else if(pcount.getGivePraiseState()==1){
					Integer updcount=stugivepraiseservice.updNoState(studentId, commentId,0);
					if(updcount>0) {
						result.setState(1);
						result.setMsg("你的踩赞取消成功");
					}
				}
				
				
			}
			return result;
	}
		
	
	
}
