package com.cxb.lhc.repository;
 
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.lhc.entity.StuCourseComment;
import com.cxb.lhc.entity.StuGivePraise;

/**
 * 
 * @Description:   学生对所选课程评价进行点/踩赞
 * @ClassName:     StuGivePraiseRepository
 * @author         liu
 * @Date           2018年12月10日 下午9:37:42
 * @Email          1273822019@qq.com
 */
public interface StuGivePraiseRepository extends JpaRepository<StuGivePraise, Integer>{
	/**
	 * 根据评价id和点赞状态为1
	 * 查询出该评价的点赞数量
	 * @param commentId
	 * @param givePraiseState
	 * @return
	 */
	@Query(value="SELECT COUNT(*) FROM stugivepraise WHERE comment_id =?1 AND give_praise_state=?2",nativeQuery=true)
	Integer queryPraiseNumByCommentId(Integer commentId,Integer givePraiseState);
	
	/**
	 * 根据评价id和踩赞状态为1
	 * 查询出该评价的踩赞数量
	 * @param commentId
	 * @param givePraiseState
	 * @return
	 */
	@Query(value="SELECT COUNT(*) FROM stugivepraise WHERE comment_id =?1 AND not_praise_state=?2",nativeQuery=true)
	Integer queryFootPraiseNumByCommentId(Integer commentId,Integer notPraiseState);
	
	/**
	 * 点/取消赞或踩/取消赞
	 * 都要先根据学生id和评价id判断该学生对该评价
	 * 是否点过赞踩过赞
	 * @param commentId
	 * @param StudentId
	 * @return
	 */
	@Query(value="SELECT * FROM stugivepraise WHERE comment_id=?1 AND student_id=?2",nativeQuery=true)
	StuGivePraise queryGiveParisByStuIdAndCommId(Integer commentId,Integer studentId);

	/**
	 *  给课程评价进行点赞 
	 *  向点赞表中添加一条数据
	 * @param commentId
	 * @param givePraiseState
	 * @param notPraiseState
	 * @param studentId
	 * @param stucoursecomment_stugivepraise_id
	 * @return
	 */
	@Query(value="INSERT INTO stugivepraise (give_praise_state,student_id,comment_id) VALUES(?1,?2,?3)",nativeQuery=true)
	@Modifying
	 Integer saveStuGivePraise(Integer givePraiseState,Integer studentId,Integer commentId);
	/**
	  *根据学生id和评价id
	 * 取消对该评价的点赞(修改点赞状态)
	 * @param studentId
	 * @param commentId
	 * @param givePraiseState
	 * @return
	 */
	@Query(value="UPDATE stugivepraise SET give_praise_state=?3 WHERE student_id=?1 and comment_id=?2",nativeQuery=true)
	@Modifying
	Integer updPariseState(Integer studentId,Integer commentId,Integer givePraiseState);
	
	/**
	 * 根据学生id和评价id
	 * 对该评价进行点赞(修改点赞状态)
	 * @param studentId
	 * @param commentId
	 * @param givePraiseState
	 * @return
	 */
	@Query(value="UPDATE stugivepraise SET give_praise_state=?3 WHERE student_id=?1 and comment_id=?2",nativeQuery=true)
	@Modifying
	Integer updGivePariseState(Integer studentId,Integer commentId,Integer givePraiseState);
	
	
	
	/**
	  *根据学生id和评价id
	 * 取消对该评价的踩赞(修改踩赞状态)
	 * @param studentId
	 * @param commentId
	 * @param givePraiseState
	 * @return
	 */
	@Query(value="UPDATE stugivepraise SET not_praise_state=?3 WHERE student_id=?1 and comment_id=?2",nativeQuery=true)
	@Modifying
	Integer updNoState(Integer studentId,Integer commentId,Integer notPraiseState);
	
	/**
	 * 根据学生id和评价id
	 * 对该评价进行踩赞(修改踩赞状态)
	 * @param studentId
	 * @param commentId
	 * @param givePraiseState
	 * @return
	 */
	@Query(value="UPDATE stugivepraise SET not_praise_state=?3 WHERE student_id=?1 and comment_id=?2",nativeQuery=true)
	@Modifying
	Integer updNoPariseState(Integer studentId,Integer commentId,Integer notPraiseState);
	
	
	
	
	 
	
	
	
	
	
	
	
}