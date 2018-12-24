package com.cxb.zbq.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.zbq.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Integer>{
	//通过课程id找到对应的最新公告
	@Query(value="SELECT notice_id,announcement_content,creation_time,curriculum_id,teacher_id FROM notice_tb WHERE curriculum_id=?1 ORDER BY creation_time DESC LIMIT 1",nativeQuery=true)
	Notice getNewNoticeByCurrId(Integer currId);
	
	//修改公告信息
	@Query(value="UPDATE notice_tb notice SET notice.announcement_content=:#{#n.announcementContent} WHERE notice.notice_id=:#{#n.noticeId}",nativeQuery=true)
	@Transactional@Modifying
	int updateNotice(@Param("n")Notice notice);
	
	//删除公告信息
	@Query(value="DELETE FROM notice_tb WHERE notice_id=?1",nativeQuery=true)
	@Transactional@Modifying
	int deleteNotice(Integer noticeId);
	
	List<Notice> findByTeacherId(Integer teaId);//根据老师id查询所有公告信息

}
