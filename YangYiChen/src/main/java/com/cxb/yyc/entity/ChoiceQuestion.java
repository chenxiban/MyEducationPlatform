package com.cxb.yyc.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 选择题问题
 * @author dell
 *
 */
@Entity
@Table(name = "choicequestiontb")
public class ChoiceQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int unsigned comment '备注：选择题主键' ")
	private Integer choicequestionId;
	@Column(nullable = false, columnDefinition = "varchar(225) comment '备注：选择题问题' ")
	private String choicequestionQuestion;
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注：每道选择题分数' ")
	private Integer choicequestionScore;
	@Column(columnDefinition = "tinyint DEFAULT 0 NOT NULL comment '备注：选择题类型' ")
	private Integer choicequestiontbIssingleselection;
	@Column(columnDefinition = "varchar(225) comment '备注：选择题图片' ")
	private String choicequestionImgurl;
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(columnDefinition = "datetime comment '备注：选择题构成时间' ")
	private Date choicequestionCreateDateTime;
	@Column(columnDefinition = "TIMESTAMP comment '备注：选择题修改时间' ", nullable = false, updatable = false, insertable = false)
	private Timestamp choicequestionLastUpdateTime;
	private Integer choicequestionExt1;
	@Column(length = 225)
	private String choicequestionExt2;
	@Column(columnDefinition="int unsigned comment '备注：课程外键' ")
	private Integer choicequestionCourseId;
	@Column(columnDefinition="int unsigned comment '备注：章节外键' ")
	private Integer choicequestionChapterId;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="choiceQuestion")
	private List<Option> list;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="choiceQuestion")
	private List<ChoiceQuestionAnswer> list2;
	public Integer getChoicequestionId() {
		return choicequestionId;
	}
	public void setChoicequestionId(Integer choicequestionId) {
		this.choicequestionId = choicequestionId;
	}
	public String getChoicequestionQuestion() {
		return choicequestionQuestion;
	}
	public void setChoicequestionQuestion(String choicequestionQuestion) {
		this.choicequestionQuestion = choicequestionQuestion;
	}
	public Integer getChoicequestionScore() {
		return choicequestionScore;
	}
	public void setChoicequestionScore(Integer choicequestionScore) {
		this.choicequestionScore = choicequestionScore;
	}
	
	public Integer getChoicequestiontbIssingleselection() {
		return choicequestiontbIssingleselection;
	}
	public void setChoicequestiontbIssingleselection(Integer choicequestiontbIssingleselection) {
		this.choicequestiontbIssingleselection = choicequestiontbIssingleselection;
	}
	public String getChoicequestionImgurl() {
		return choicequestionImgurl;
	}
	public void setChoicequestionImgurl(String choicequestionImgurl) {
		this.choicequestionImgurl = choicequestionImgurl;
	}
	public Date getChoicequestionCreateDateTime() {
		return choicequestionCreateDateTime;
	}
	public void setChoicequestionCreateDateTime(Date choicequestionCreateDateTime) {
		this.choicequestionCreateDateTime = choicequestionCreateDateTime;
	}
	public Timestamp getChoicequestionLastUpdateTime() {
		return choicequestionLastUpdateTime;
	}
	public void setChoicequestionLastUpdateTime(Timestamp choicequestionLastUpdateTime) {
		this.choicequestionLastUpdateTime = choicequestionLastUpdateTime;
	}
	public Integer getChoicequestionExt1() {
		return choicequestionExt1;
	}
	public void setChoicequestionExt1(Integer choicequestionExt1) {
		this.choicequestionExt1 = choicequestionExt1;
	}
	public String getChoicequestionExt2() {
		return choicequestionExt2;
	}
	public void setChoicequestionExt2(String choicequestionExt2) {
		this.choicequestionExt2 = choicequestionExt2;
	}
	public List<Option> getList() {
		return list;
	}
	public void setList(List<Option> list) {
		this.list = list;
	}
	public List<ChoiceQuestionAnswer> getList2() {
		return list2;
	}
	public void setList2(List<ChoiceQuestionAnswer> list2) {
		this.list2 = list2;
	}
	
	
	
	public Integer getChoicequestionCourseId() {
		return choicequestionCourseId;
	}
	public void setChoicequestionCourseId(Integer choicequestionCourseId) {
		this.choicequestionCourseId = choicequestionCourseId;
	}
	public Integer getChoicequestionChapterId() {
		return choicequestionChapterId;
	}
	public void setChoicequestionChapterId(Integer choicequestionChapterId) {
		this.choicequestionChapterId = choicequestionChapterId;
	}
	@Override
	public String toString() {
		return "ChoiceQuestion [choicequestionId=" + choicequestionId + ", choicequestionQuestion="
				+ choicequestionQuestion + ", choicequestionScore=" + choicequestionScore
				+ ", choicequestiontbIssingleselection=" + choicequestiontbIssingleselection + "]";
	}
	
	

}
