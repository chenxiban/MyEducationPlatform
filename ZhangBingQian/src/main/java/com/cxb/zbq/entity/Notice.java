package com.cxb.zbq.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="noticeTb")

public class Notice {//公告表
	@Id
	@GeneratedValue
	private Integer noticeId;//公告id
	private Integer curriculumId;//课程id
	private Integer teacherId;//老师id
	private String noticeTitle;//公告标题
	@Column(columnDefinition="varchar(1000) DEFAULT NULL")
	private String announcementContent;//公告内容
	@OrderBy(value="DESC")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")	//日期格式化为中国的时区 东8区
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")	//接受::字符串日期需要格式化为日期类型
	private Date creationTime=new Date();//创建时间
	@Column(columnDefinition="timestamp")
	private Timestamp lastUpdateTime;//最后一次修改时间
	@Transient
	private String curriculumName;//临时参数(课程名称)
	public Integer getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}
	public Integer getCurriculumId() {
		return curriculumId;
	}
	public void setCurriculumId(Integer curriculumId) {
		this.curriculumId = curriculumId;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getAnnouncementContent() {
		return announcementContent;
	}
	public void setAnnouncementContent(String announcementContent) {
		this.announcementContent = announcementContent;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getCurriculumName() {
		return curriculumName;
	}
	public void setCurriculumName(String curriculumName) {
		this.curriculumName = curriculumName;
	}
	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", curriculumId=" + curriculumId + ", teacherId=" + teacherId
				+ ", noticeTitle=" + noticeTitle + ", announcementContent=" + announcementContent + ", creationTime="
				+ creationTime + ", lastUpdateTime=" + lastUpdateTime + ", curriculumName=" + curriculumName + "]";
	}
	public Notice(Integer noticeId, Integer curriculumId, Integer teacherId, String noticeTitle,
			String announcementContent, Date creationTime, Timestamp lastUpdateTime, String curriculumName) {
		super();
		this.noticeId = noticeId;
		this.curriculumId = curriculumId;
		this.teacherId = teacherId;
		this.noticeTitle = noticeTitle;
		this.announcementContent = announcementContent;
		this.creationTime = creationTime;
		this.lastUpdateTime = lastUpdateTime;
		this.curriculumName = curriculumName;
	}
	public Notice() {
		super();
	}
	
}
