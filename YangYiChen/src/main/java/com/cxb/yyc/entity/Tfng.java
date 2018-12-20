package com.cxb.yyc.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 判断题
 * @author dell
 *
 */
@Entity
@Table(name="tfngtb")
public class Tfng {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned comment '备注：判断题主键' ")
	private Integer tfngId;
	@Column(nullable=false,columnDefinition="varchar(225) comment '备注：判断题问题' ")
	private String tfngQuestion;
	@Column(columnDefinition="varchar(225) comment '备注：判断题图片' ")
	private String tfngImgurl;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：每道判断题分数' ")
	private Integer tfngScore;
	@JsonFormat(locale="zh",timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
	@Column(columnDefinition="datetime comment '备注：判断题构成时间' ")
	private Date tfngCreateDateTime;
	@Column(columnDefinition="TIMESTAMP comment '备注：判断题修改时间' ",nullable=false,updatable=false,insertable=false)
	private Timestamp tfngLastUpdateTime;
	private Integer tfngExt1;
	@Column(length=225)
	private String tfngExt2;
	@Column(columnDefinition="int unsigned comment '备注：课程外键' ")
	private Integer tfngCourseId;
	@Column(columnDefinition="int unsigned comment '备注：章节章节' ")
	private Integer tfngChapterId;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER,mappedBy="tfng")
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	private TfngAnswer tfngAnswer;

	public Integer getTfngId() {
		return tfngId;
	}

	public void setTfngId(Integer tfngId) {
		this.tfngId = tfngId;
	}

	public String getTfngQuestion() {
		return tfngQuestion;
	}

	public void setTfngQuestion(String tfngQuestion) {
		this.tfngQuestion = tfngQuestion;
	}

	public String getTfngImgurl() {
		return tfngImgurl;
	}

	public void setTfngImgurl(String tfngImgurl) {
		this.tfngImgurl = tfngImgurl;
	}

	public Integer getTfngScore() {
		return tfngScore;
	}

	public void setTfngScore(Integer tfngScore) {
		this.tfngScore = tfngScore;
	}

	public Date getTfngCreateDateTime() {
		return tfngCreateDateTime;
	}

	public void setTfngCreateDateTime(Date tfngCreateDateTime) {
		this.tfngCreateDateTime = tfngCreateDateTime;
	}

	public Timestamp getTfngLastUpdateTime() {
		return tfngLastUpdateTime;
	}

	public void setTfngLastUpdateTime(Timestamp tfngLastUpdateTime) {
		this.tfngLastUpdateTime = tfngLastUpdateTime;
	}

	public Integer getTfngExt1() {
		return tfngExt1;
	}

	public void setTfngExt1(Integer tfngExt1) {
		this.tfngExt1 = tfngExt1;
	}

	public String getTfngExt2() {
		return tfngExt2;
	}

	public void setTfngExt2(String tfngExt2) {
		this.tfngExt2 = tfngExt2;
	}

	public TfngAnswer getTfngAnswer() {
		return tfngAnswer;
	}

	public void setTfngAnswer(TfngAnswer tfngAnswer) {
		this.tfngAnswer = tfngAnswer;
	}

	public Integer getTfngCourseId() {
		return tfngCourseId;
	}

	public void setTfngCourseId(Integer tfngCourseId) {
		this.tfngCourseId = tfngCourseId;
	}

	public Integer getTfngChapterId() {
		return tfngChapterId;
	}

	public void setTfngChapterId(Integer tfngChapterId) {
		this.tfngChapterId = tfngChapterId;
	}

	
	
	
}
