package com.cxb.lhc.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
/**
 * 
 * @Description:   学生对所选课程评价进行点/踩赞
 * @ClassName:     StuGivePraiseServiceImpl
 * @author         liu
 * @Date           2018年12月10日 下午9:37:42
 * @Email          1273822019@qq.com
 */
import org.springframework.stereotype.Service;

import com.cxb.lhc.entity.StuCourseComment;
import com.cxb.lhc.entity.StuGivePraise;
import com.cxb.lhc.repository.StuGivePraiseRepository;
import com.cxb.lhc.service.StuGivePraiseService;
@Service
public class StuGivePraiseServiceImpl implements StuGivePraiseService{
@Autowired
private StuGivePraiseRepository stuGivePraiseRepository;


/**
 * 根据评价id和点赞状态为1
 * 查询出该评价的点赞数量
 * @param commentId
 * @param givePraiseState
 * @return
 */

public Integer queryPraiseNumByCommentId(Integer commentId,Integer givePraiseState) {
	return stuGivePraiseRepository.queryPraiseNumByCommentId(commentId, givePraiseState);
};

/**
 * 根据评价id和踩赞状态为1
 * 查询出该评价的踩赞数量
 * @param commentId
 * @param givePraiseState
 * @return
 */

public Integer queryFootPraiseNumByCommentId(Integer commentId,Integer notPraiseState) {
	return stuGivePraiseRepository.queryFootPraiseNumByCommentId(commentId, notPraiseState);
};




/**
 * 点/取消赞或踩/取消赞
 * 都要先根据学生id和评价id判断该学生对该评价
 * 是否点过赞踩过赞
 * @param commentId
 * @param StudentId
 * @return
 */
@Override
public StuGivePraise queryGiveParisByStuIdAndCommId(Integer commentId, Integer studentId) {
	
	return stuGivePraiseRepository.queryGiveParisByStuIdAndCommId(commentId, studentId);
}
/**
 *  给课程评价进行点赞 
 *  向点赞表中添加一条数据
 * @param commentId
 * @param givePraiseState
 * @param studentId
 * @return
 */
@Override
public Integer saveStuGivePraise(Integer givePraiseState, Integer studentId, Integer commentId) {
		return stuGivePraiseRepository.saveStuGivePraise(givePraiseState, studentId, commentId);
}


/**
 *根据学生id和评价id
* 取消对该评价的点赞(修改点赞状态)
* @param studentId
* @param commentId
* @param givePraiseState
* @return
*/
@Override
public Integer updPariseState(Integer studentId,Integer commentId,Integer givePraiseState){
	
	return stuGivePraiseRepository.updPariseState(studentId, commentId,givePraiseState);
}

 
/**
 * 根据学生id和评价id
 * 对该评价进行点赞(修改点赞状态)
 * @param studentId
 * @param commentId
 * @param givePraiseState
 * @return
 */
@Override
public Integer updGivePariseState(Integer studentId,Integer commentId,Integer givePraiseState){
	
	return stuGivePraiseRepository.updGivePariseState(studentId, commentId,givePraiseState);
}
/**
 *根据学生id和评价id
* 取消对该评价的踩赞(修改踩赞状态)
* @param studentId
* @param commentId
* @param givePraiseState
* @return
*/
@Override
public Integer updNoState(Integer studentId, Integer commentId, Integer notPraiseState) {
	
	return stuGivePraiseRepository.updNoPariseState(studentId, commentId, notPraiseState);
}
/**
 * 根据学生id和评价id
 * 对该评价进行踩赞(修改踩赞状态)
 * @param studentId
 * @param commentId
 * @param givePraiseState
 * @return
 */
@Override
public Integer updNoPariseState(Integer studentId, Integer commentId, Integer notPraiseState) {
	
	return stuGivePraiseRepository.updNoPariseState(studentId, commentId, notPraiseState);
}



}
