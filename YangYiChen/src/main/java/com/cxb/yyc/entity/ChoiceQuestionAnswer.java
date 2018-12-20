package com.cxb.yyc.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 选择题问题的正确答案
 * @author dell
 *
 */
@Entity
@Table(name="choicequestionanswertb")
public class ChoiceQuestionAnswer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned comment '备注：选择题正确答案主键' ")
	private Integer choicequestionanswerId;
	@Column(nullable=false,columnDefinition="varchar(225) comment '备注：选择题正确答案' ")
	private String choicequestionanswerAnswer;
	@JsonFormat(locale="zh",timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
	@Column(columnDefinition="datetime comment '备注：选择题答案构成时间' ")
	private Date choicequestionanswerCreateDateTime;
	@Column(columnDefinition="TIMESTAMP comment '备注：选择题答案修改时间' ",nullable=false,updatable=false,insertable=false)
	private Timestamp choicequestionanswerLastUpdateTime;
	private Integer choicequestionanswerExt1;
	@Column(length=225)
	private String choicequestionanswerExt2;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="choicequestionanswer_choicequestionId",nullable=false)
	private ChoiceQuestion choiceQuestion;

	public Integer getChoicequestionanswerId() {
		return choicequestionanswerId;
	}

	public void setChoicequestionanswerId(Integer choicequestionanswerId) {
		this.choicequestionanswerId = choicequestionanswerId;
	}

	public String getChoicequestionanswerAnswer() {
		return choicequestionanswerAnswer;
	}

	public void setChoicequestionanswerAnswer(String choicequestionanswerAnswer) {
		this.choicequestionanswerAnswer = choicequestionanswerAnswer;
	}

	public Date getChoicequestionanswerCreateDateTime() {
		return choicequestionanswerCreateDateTime;
	}

	public void setChoicequestionanswerCreateDateTime(Date choicequestionanswerCreateDateTime) {
		this.choicequestionanswerCreateDateTime = choicequestionanswerCreateDateTime;
	}

	public Timestamp getChoicequestionanswerLastUpdateTime() {
		return choicequestionanswerLastUpdateTime;
	}

	public void setChoicequestionanswerLastUpdateTime(Timestamp choicequestionanswerLastUpdateTime) {
		this.choicequestionanswerLastUpdateTime = choicequestionanswerLastUpdateTime;
	}

	public Integer getChoicequestionanswerExt1() {
		return choicequestionanswerExt1;
	}

	public void setChoicequestionanswerExt1(Integer choicequestionanswerExt1) {
		this.choicequestionanswerExt1 = choicequestionanswerExt1;
	}

	public String getChoicequestionanswerExt2() {
		return choicequestionanswerExt2;
	}

	public void setChoicequestionanswerExt2(String choicequestionanswerExt2) {
		this.choicequestionanswerExt2 = choicequestionanswerExt2;
	}

	public ChoiceQuestion getChoiceQuestion() {
		return choiceQuestion;
	}

	public void setChoiceQuestion(ChoiceQuestion choiceQuestion) {
		this.choiceQuestion = choiceQuestion;
	}
	
	
	

}
