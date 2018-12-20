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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 选择题对应的选项
 * @author dell
 *
 */
@Entity
@Table(name="optiontb")
public class Option {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned comment '备注：选项主键' ")
	private Integer optionId;
	@Column(nullable=false,columnDefinition="varchar(50) comment '备注：选项' ")
	private String optionA;
	@Column(nullable=false,columnDefinition="varchar(50) comment '备注：选项' ")
	private String optionB;
	@Column(nullable=false,columnDefinition="varchar(50) comment '备注：选项' ")
	private String optionC;
	@Column(nullable=false,columnDefinition="varchar(50) comment '备注：选项' ")
	private String optionD;
	@JsonFormat(locale="zh",timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
	@Column(columnDefinition="datetime comment '备注：选项构成时间' ")
	private Date optionCreateDateTime;
	@Column(columnDefinition="TIMESTAMP comment '备注：选项修改时间' ",nullable=false,updatable=false,insertable=false)
	private Timestamp optionLastUpdateTime;
	private Integer optionExt1 ;
	@Column(length=225)
	private String optionExt2;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="option_choicequestionId",nullable=false)
	private ChoiceQuestion choiceQuestion;

	public Integer getOptionId() {
		return optionId;
	}

	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public Date getOptionCreateDateTime() {
		return optionCreateDateTime;
	}

	public void setOptionCreateDateTime(Date optionCreateDateTime) {
		this.optionCreateDateTime = optionCreateDateTime;
	}

	public Timestamp getOptionLastUpdateTime() {
		return optionLastUpdateTime;
	}

	public void setOptionLastUpdateTime(Timestamp optionLastUpdateTime) {
		this.optionLastUpdateTime = optionLastUpdateTime;
	}

	public Integer getOptionExt1() {
		return optionExt1;
	}

	public void setOptionExt1(Integer optionExt1) {
		this.optionExt1 = optionExt1;
	}

	public String getOptionExt2() {
		return optionExt2;
	}

	public void setOptionExt2(String optionExt2) {
		this.optionExt2 = optionExt2;
	}

	public ChoiceQuestion getChoiceQuestion() {
		return choiceQuestion;
	}

	public void setChoiceQuestion(ChoiceQuestion choiceQuestion) {
		this.choiceQuestion = choiceQuestion;
	}

	

}
