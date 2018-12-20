package com.cxb.yyc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 教师发起考试
 * @author dell
 *
 */
@Entity
@Table(name="teachercreateexamstb")
public class TeacherCreateExams {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned comment '备注：教师发起考试主键' ")
	private Integer teachercreateexamsId;
	@Column(columnDefinition="tinyint DEFAULT 1 comment '备注：教师发起考试的状态' ")
	private Boolean teachercreateexamsState;
	@Column(columnDefinition="varchar(50) comment '备注：教师发起考试名称' ")
	private String teachercreateexamsExamsname;
	@Column(columnDefinition="int unsigned comment '备注：教师发起考试的分数' ")
	private Integer teachercreateexamsScore;
	@Column(nullable=false,columnDefinition="varchar(225) comment '备注：教师发起考试说明' ")
	private String teachercreateexamsExplain;
	@JsonFormat(locale="zh",timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
	@Column(nullable=false,columnDefinition="datetime comment '备注：教师发起考试截止提交时间' ")
	private Date teachercreateexamsEndtime;
	@JsonFormat(locale="zh",timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
	@Column(columnDefinition="varchar(225) comment '备注：教师发起考试时间' ")
	private String teachercreateexamsExamstime;
	@Column(columnDefinition="varchar(10)  NOT NULL comment '备注：考试题目是否随机出现' ")
	private String teachercreateexamsRandom;
	@Column(columnDefinition="int unsigned comment '备注：选择题数量' ")
	private Integer teachercreateexamsChoicenum;
	@Column(columnDefinition="int unsigned comment '备注：判断题数量' ")
	private Integer teachercreateexamsTfngnum;
	@Column(columnDefinition="int unsigned comment '备注：填空题数量' ")
	private Integer teachercreateexamsGapfillingnum;
	private Integer teachercreateexamsExt1;
	@Column(length=225)
	private String teachercreateexamsExt2;
	@Column(columnDefinition="int unsigned comment '备注：课程外键' ")
	private Integer teachercreateexamsCourseId;
	@Column(columnDefinition="int unsigned comment '备注：教师外键' ")
	private Integer teachercreateexamsTeacherId;
	
	
	public Integer getTeachercreateexamsId() {
		return teachercreateexamsId;
	}
	public void setTeachercreateexamsId(Integer teachercreateexamsId) {
		this.teachercreateexamsId = teachercreateexamsId;
	}
	public Boolean getTeachercreateexamsState() {
		return teachercreateexamsState;
	}
	public void setTeachercreateexamsState(Boolean teachercreateexamsState) {
		this.teachercreateexamsState = teachercreateexamsState;
	}
	public String getTeachercreateexamsExamsname() {
		return teachercreateexamsExamsname;
	}
	public void setTeachercreateexamsExamsname(String teachercreateexamsExamsname) {
		this.teachercreateexamsExamsname = teachercreateexamsExamsname;
	}
	public Integer getTeachercreateexamsScore() {
		return teachercreateexamsScore;
	}
	public void setTeachercreateexamsScore(Integer teachercreateexamsScore) {
		this.teachercreateexamsScore = teachercreateexamsScore;
	}
	public String getTeachercreateexamsExplain() {
		return teachercreateexamsExplain;
	}
	public void setTeachercreateexamsExplain(String teachercreateexamsExplain) {
		this.teachercreateexamsExplain = teachercreateexamsExplain;
	}
	public Date getTeachercreateexamsEndtime() {
		return teachercreateexamsEndtime;
	}
	public void setTeachercreateexamsEndtime(Date teachercreateexamsEndtime) {
		this.teachercreateexamsEndtime = teachercreateexamsEndtime;
	}
	public String getTeachercreateexamsExamstime() {
		return teachercreateexamsExamstime;
	}
	public void setTeachercreateexamsExamstime(String teachercreateexamsExamstime) {
		this.teachercreateexamsExamstime = teachercreateexamsExamstime;
	}
	public String getTeachercreateexamsRandom() {
		return teachercreateexamsRandom;
	}
	public void setTeachercreateexamsRandom(String teachercreateexamsRandom) {
		this.teachercreateexamsRandom = teachercreateexamsRandom;
	}
	public Integer getTeachercreateexamsChoicenum() {
		return teachercreateexamsChoicenum;
	}
	public void setTeachercreateexamsChoicenum(Integer teachercreateexamsChoicenum) {
		this.teachercreateexamsChoicenum = teachercreateexamsChoicenum;
	}
	public Integer getTeachercreateexamsTfngnum() {
		return teachercreateexamsTfngnum;
	}
	public void setTeachercreateexamsTfngnum(Integer teachercreateexamsTfngnum) {
		this.teachercreateexamsTfngnum = teachercreateexamsTfngnum;
	}
	public Integer getTeachercreateexamsGapfillingnum() {
		return teachercreateexamsGapfillingnum;
	}
	public void setTeachercreateexamsGapfillingnum(Integer teachercreateexamsGapfillingnum) {
		this.teachercreateexamsGapfillingnum = teachercreateexamsGapfillingnum;
	}
	public Integer getTeachercreateexamsExt1() {
		return teachercreateexamsExt1;
	}
	public void setTeachercreateexamsExt1(Integer teachercreateexamsExt1) {
		this.teachercreateexamsExt1 = teachercreateexamsExt1;
	}
	public String getTeachercreateexamsExt2() {
		return teachercreateexamsExt2;
	}
	public void setTeachercreateexamsExt2(String teachercreateexamsExt2) {
		this.teachercreateexamsExt2 = teachercreateexamsExt2;
	}
	
	public Integer getTeachercreateexamsCourseId() {
		return teachercreateexamsCourseId;
	}
	public void setTeachercreateexamsCourseId(Integer teachercreateexamsCourseId) {
		this.teachercreateexamsCourseId = teachercreateexamsCourseId;
	}
	public Integer getTeachercreateexamsTeacherId() {
		return teachercreateexamsTeacherId;
	}
	public void setTeachercreateexamsTeacherId(Integer teachercreateexamsTeacherId) {
		this.teachercreateexamsTeacherId = teachercreateexamsTeacherId;
	}
	
}
