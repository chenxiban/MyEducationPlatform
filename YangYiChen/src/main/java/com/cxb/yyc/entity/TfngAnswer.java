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
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 判断题正确答案
 * @author dell
 *
 */
@Entity
@Table(name = "tfnganswertb")
public class TfngAnswer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int unsigned comment '备注：判断题正确答案主键' ")
	private Integer tfnganswerId;
	@Column(columnDefinition = "tinyint(4) comment '备注：判断题正确答案(0:错误 1：正确)' ")
	private Integer tfnganswerAnswer;
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(columnDefinition = "datetime comment '备注：创建判断题正确答案时间' ")
	private Date tfnganswerCreateDateTime;
	@Column(columnDefinition = "TIMESTAMP comment '备注：修改判断题正确答案时间' ", nullable = false, updatable = false, insertable = false)
	private Timestamp tfnganswerLastUpdateTime;
	private Integer tfnganswerExt1;
	@Column(length = 225)
	private String tfnganswerExt2;

	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	@JoinColumn(name = "tfnganswer_tfngId",nullable=false)
	private Tfng tfng;

	public Integer getTfnganswerId() {
		return tfnganswerId;
	}

	public void setTfnganswerId(Integer tfnganswerId) {
		this.tfnganswerId = tfnganswerId;
	}

	

	public Integer getTfnganswerAnswer() {
		return tfnganswerAnswer;
	}

	public void setTfnganswerAnswer(Integer tfnganswerAnswer) {
		this.tfnganswerAnswer = tfnganswerAnswer;
	}

	public Date getTfnganswerCreateDateTime() {
		return tfnganswerCreateDateTime;
	}

	public void setTfnganswerCreateDateTime(Date tfnganswerCreateDateTime) {
		this.tfnganswerCreateDateTime = tfnganswerCreateDateTime;
	}

	public Timestamp getTfnganswerLastUpdateTime() {
		return tfnganswerLastUpdateTime;
	}

	public void setTfnganswerLastUpdateTime(Timestamp tfnganswerLastUpdateTime) {
		this.tfnganswerLastUpdateTime = tfnganswerLastUpdateTime;
	}

	public Integer getTfnganswerExt1() {
		return tfnganswerExt1;
	}

	public void setTfnganswerExt1(Integer tfnganswerExt1) {
		this.tfnganswerExt1 = tfnganswerExt1;
	}

	public String getTfnganswerExt2() {
		return tfnganswerExt2;
	}

	public void setTfnganswerExt2(String tfnganswerExt2) {
		this.tfnganswerExt2 = tfnganswerExt2;
	}

	public Tfng getTfng() {
		return tfng;
	}

	public void setTfng(Tfng tfng) {
		this.tfng = tfng;
	}

	
}
