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
@Table(name="curriculumTb")

public class Curriculum {//课程表
	@Id
	@GeneratedValue
	@OrderBy
	private Integer curriculumId;//课程id
	private String curriculumName;//课程名称
	private Integer curriculumCategoryId;//类别id
	private Integer teacherId;//老师id
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")	//日期格式化为中国的时区 东8区
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")	//接受::字符串日期需要格式化为日期类型
	private Date creationTime=new Date();//创建时间
	@Column(columnDefinition="int unsigned DEFAULT 0")
	private Integer subscriptionNum;//订阅人数
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")	//日期格式化为中国的时区 东8区
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")	//接受::字符串日期需要格式化为日期类型
	private Date startTime;//开课时间
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")	//日期格式化为中国的时区 东8区
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")	//接受::字符串日期需要格式化为日期类型
	private Date endTime;//结束开课时间
	@Column(columnDefinition="varchar(1000) DEFAULT NULL")
	private String courseIntroduction;//课程介绍
	@Column(columnDefinition="int unsigned DEFAULT 0")
	private Integer whetherToIssue;//是否发布
	@Column(columnDefinition="timestamp")
	private Timestamp lastUpdateTime;//最后一次修改时间
	@Transient
	private String categoryName;//临时参数(类别名称)
	@Transient
	private String teacherName;//临时参数(名称)
	public Integer getCurriculumId() {
		return curriculumId;
	}
	public void setCurriculumId(Integer curriculumId) {
		this.curriculumId = curriculumId;
	}
	public String getCurriculumName() {
		return curriculumName;
	}
	public void setCurriculumName(String curriculumName) {
		this.curriculumName = curriculumName;
	}
	public Integer getCurriculumCategoryId() {
		return curriculumCategoryId;
	}
	public void setCurriculumCategoryId(Integer curriculumCategoryId) {
		this.curriculumCategoryId = curriculumCategoryId;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public Integer getSubscriptionNum() {
		return subscriptionNum;
	}
	public void setSubscriptionNum(Integer subscriptionNum) {
		this.subscriptionNum = subscriptionNum;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getCourseIntroduction() {
		return courseIntroduction;
	}
	public void setCourseIntroduction(String courseIntroduction) {
		this.courseIntroduction = courseIntroduction;
	}
	public Integer getWhetherToIssue() {
		return whetherToIssue;
	}
	public void setWhetherToIssue(Integer whetherToIssue) {
		this.whetherToIssue = whetherToIssue;
	}
	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	@Override
	public String toString() {
		return "Curriculum [curriculumId=" + curriculumId + ", curriculumName=" + curriculumName
				+ ", curriculumCategoryId=" + curriculumCategoryId + ", teacherId=" + teacherId + ", creationTime="
				+ creationTime + ", subscriptionNum=" + subscriptionNum + ", startTime=" + startTime + ", endTime="
				+ endTime + ", courseIntroduction=" + courseIntroduction + ", whetherToIssue=" + whetherToIssue
				+ ", lastUpdateTime=" + lastUpdateTime + ", categoryName=" + categoryName + ", teacherName="
				+ teacherName + "]";
	}
	public Curriculum(Integer curriculumId, String curriculumName, Integer curriculumCategoryId, Integer teacherId,
			Date creationTime, Integer subscriptionNum, Date startTime, Date endTime, String courseIntroduction,
			Integer whetherToIssue, Timestamp lastUpdateTime, String categoryName, String teacherName) {
		super();
		this.curriculumId = curriculumId;
		this.curriculumName = curriculumName;
		this.curriculumCategoryId = curriculumCategoryId;
		this.teacherId = teacherId;
		this.creationTime = creationTime;
		this.subscriptionNum = subscriptionNum;
		this.startTime = startTime;
		this.endTime = endTime;
		this.courseIntroduction = courseIntroduction;
		this.whetherToIssue = whetherToIssue;
		this.lastUpdateTime = lastUpdateTime;
		this.categoryName = categoryName;
		this.teacherName = teacherName;
	}
	public Curriculum() {
		super();
	}
	
	
	

}
