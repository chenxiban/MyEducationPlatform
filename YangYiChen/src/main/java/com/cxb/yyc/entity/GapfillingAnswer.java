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
 * 填空题问题的正确答案
 * @author dell
 *
 */
@Entity
@Table(name="gapfillinganswertb")
public class GapfillingAnswer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned comment '备注：填空题正确答案主键' ")
	private Integer gapfillinganswerId;
	@Column(nullable=false,columnDefinition="varchar(225) comment '备注：填空题正确答案' ")
	private String gapfillinganswerAnswer;
	@JsonFormat(locale="zh",timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
	@Column(columnDefinition="datetime comment '备注：填空题正确答案构成时间' ")
	private Date gapfillinganswerCreateDateTime;
	@Column(columnDefinition="TIMESTAMP comment '备注：填空题正确答案修改时间' ",nullable=false,updatable=false,insertable=false)
	private Timestamp gapfillinganswerLastUpdateTime;
	private Integer gapfillinganswerExt1;
	@Column(length=225)
	private String gapfillinganswerExt2;
	
	@JsonIgnore
	@OneToOne(fetch=FetchType.EAGER)
	@Cascade(value= {CascadeType.SAVE_UPDATE})
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="gapfillinganswer_gapfillingId",nullable=false)
	private Gapfilling gapfilling;

	public Integer getGapfillinganswerId() {
		return gapfillinganswerId;
	}

	public void setGapfillinganswerId(Integer gapfillinganswerId) {
		this.gapfillinganswerId = gapfillinganswerId;
	}

	public String getGapfillinganswerAnswer() {
		return gapfillinganswerAnswer;
	}

	public void setGapfillinganswerAnswer(String gapfillinganswerAnswer) {
		this.gapfillinganswerAnswer = gapfillinganswerAnswer;
	}

	public Date getGapfillinganswerCreateDateTime() {
		return gapfillinganswerCreateDateTime;
	}

	public void setGapfillinganswerCreateDateTime(Date gapfillinganswerCreateDateTime) {
		this.gapfillinganswerCreateDateTime = gapfillinganswerCreateDateTime;
	}

	public Timestamp getGapfillinganswerLastUpdateTime() {
		return gapfillinganswerLastUpdateTime;
	}

	public void setGapfillinganswerLastUpdateTime(Timestamp gapfillinganswerLastUpdateTime) {
		this.gapfillinganswerLastUpdateTime = gapfillinganswerLastUpdateTime;
	}

	public Integer getGapfillinganswerExt1() {
		return gapfillinganswerExt1;
	}

	public void setGapfillinganswerExt1(Integer gapfillinganswerExt1) {
		this.gapfillinganswerExt1 = gapfillinganswerExt1;
	}

	public String getGapfillinganswerExt2() {
		return gapfillinganswerExt2;
	}

	public void setGapfillinganswerExt2(String gapfillinganswerExt2) {
		this.gapfillinganswerExt2 = gapfillinganswerExt2;
	}

	public Gapfilling getGapfilling() {
		return gapfilling;
	}

	public void setGapfilling(Gapfilling gapfilling) {
		this.gapfilling = gapfilling;
	}

	@Override
	public String toString() {
		return "GapfillingAnswer [gapfillinganswerId=" + gapfillinganswerId + ", gapfillinganswerAnswer="
				+ gapfillinganswerAnswer + ", gapfillinganswerCreateDateTime=" + gapfillinganswerCreateDateTime
				+ ", gapfillinganswerLastUpdateTime=" + gapfillinganswerLastUpdateTime + ", gapfillinganswerExt1="
				+ gapfillinganswerExt1 + ", gapfillinganswerExt2=" + gapfillinganswerExt2 + ", gapfilling=" + gapfilling
				+ ", getGapfillinganswerId()=" + getGapfillinganswerId() + ", getGapfillinganswerAnswer()="
				+ getGapfillinganswerAnswer() + ", getGapfillinganswerCreateDateTime()="
				+ getGapfillinganswerCreateDateTime() + ", getGapfillinganswerLastUpdateTime()="
				+ getGapfillinganswerLastUpdateTime() + ", getGapfillinganswerExt1()=" + getGapfillinganswerExt1()
				+ ", getGapfillinganswerExt2()=" + getGapfillinganswerExt2() + ", getGapfilling()=" + getGapfilling()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	

}
