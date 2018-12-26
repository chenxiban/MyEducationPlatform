package com.cxb.zbq.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="courseWareTb")

public class CourseWare {//课件表
	@Id 
	private String courseWareId;
	@Column(columnDefinition="varchar(1000) DEFAULT NULL")
	private String coursewareDescription;//课件描述
	private Integer classHourId;//课时id
	private String coursewarePath;//课件路径
	private String coursewareType;//课件类型
	@Column(columnDefinition="int unsigned DEFAULT 0")
	private Integer coursewareDuration;//课件时长（秒）
	private String coursewareSize;//课件大小
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")	//日期格式化为中国的时区 东8区
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")	//接受::字符串日期需要格式化为日期类型
	private Date coursewareCreationTime=new Date();//创建时间
	@Column(columnDefinition="timestamp")
	private Timestamp lastUpdateTime;//最后一次修改时间
	@Transient
	private String coursewareParam;//临时参数
	@Transient
	private String chapterName;
	public String getCourseWareId() {
		return courseWareId;
	}
	public void setCourseWareId(String courseWareId) {
		this.courseWareId = courseWareId;
	}
	public String getCoursewareDescription() {
		return coursewareDescription;
	}
	public void setCoursewareDescription(String coursewareDescription) {
		this.coursewareDescription = coursewareDescription;
	}
	public Integer getClassHourId() {
		return classHourId;
	}
	public void setClassHourId(Integer classHourId) {
		this.classHourId = classHourId;
	}
	public String getCoursewarePath() {
		return coursewarePath;
	}
	public void setCoursewarePath(String coursewarePath) {
		this.coursewarePath = coursewarePath;
	}
	public String getCoursewareType() {
		return coursewareType;
	}
	public void setCoursewareType(String coursewareType) {
		this.coursewareType = coursewareType;
	}
	public Integer getCoursewareDuration() {
		return coursewareDuration;
	}
	public void setCoursewareDuration(Integer coursewareDuration) {
		this.coursewareDuration = coursewareDuration;
	}
	public String getCoursewareSize() {
		return coursewareSize;
	}
	public void setCoursewareSize(String coursewareSize) {
		this.coursewareSize = coursewareSize;
	}
	public Date getCoursewareCreationTime() {
		return coursewareCreationTime;
	}
	public void setCoursewareCreationTime(Date coursewareCreationTime) {
		this.coursewareCreationTime = coursewareCreationTime;
	}
	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getCoursewareParam() {
		return coursewareParam;
	}
	public void setCoursewareParam(String coursewareParam) {
		this.coursewareParam = coursewareParam;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	@Override
	public String toString() {
		return "CourseWare [courseWareId=" + courseWareId + ", coursewareDescription=" + coursewareDescription
				+ ", classHourId=" + classHourId + ", coursewarePath=" + coursewarePath + ", coursewareType="
				+ coursewareType + ", coursewareDuration=" + coursewareDuration + ", coursewareSize=" + coursewareSize
				+ ", coursewareCreationTime=" + coursewareCreationTime + ", lastUpdateTime=" + lastUpdateTime
				+ ", coursewareParam=" + coursewareParam + ", chapterName=" + chapterName + "]";
	}
	public CourseWare(String courseWareId, String coursewareDescription, Integer classHourId, String coursewarePath,
			String coursewareType, Integer coursewareDuration, String coursewareSize, Date coursewareCreationTime,
			Timestamp lastUpdateTime, String coursewareParam, String chapterName) {
		super();
		this.courseWareId = courseWareId;
		this.coursewareDescription = coursewareDescription;
		this.classHourId = classHourId;
		this.coursewarePath = coursewarePath;
		this.coursewareType = coursewareType;
		this.coursewareDuration = coursewareDuration;
		this.coursewareSize = coursewareSize;
		this.coursewareCreationTime = coursewareCreationTime;
		this.lastUpdateTime = lastUpdateTime;
		this.coursewareParam = coursewareParam;
		this.chapterName = chapterName;
	}
	public CourseWare() {
		super();
	}

}
