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
 * 填空题问题
 * @author dell
 *
 */
@Entity
@Table(name="gapfillingtb")
public class Gapfilling {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned comment '备注：填空题主键' ")
	private Integer gapfillingId;
	@Column(nullable=false,columnDefinition="varchar(225) comment '备注：填空题问题'  ")
	private String gapfillingQuestion;
	@Column(columnDefinition="varchar(225) comment '备注：填空题图片'  ")
	private String gapfillingImgurl;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：每道填空题分数'  ")
	private Integer gapfillingScore;
	@JsonFormat(locale="zh",timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
	@Column(columnDefinition="datetime comment '备注：填空题构成时间' ")
	private Date gapfillingCreateDateTime;
	@Column(columnDefinition="TIMESTAMP comment '备注：填空题修改时间' ",nullable=false,updatable=false,insertable=false)
	private Timestamp gapfillingLastUpdateTime;
	private Integer gapfillingExt1;
	@Column(length=225)
	private String gapfillingExt2;
	@Column(columnDefinition="int unsigned comment '备注：课程外键' ")
	private Integer gapfillingCourseId;
	@Column(columnDefinition="int unsigned comment '备注：章节外键' ")
	private Integer gapfillingChapterId;
	@JsonIgnore
	@OneToOne(fetch=FetchType.EAGER,mappedBy="gapfilling")
	@Cascade(value= {CascadeType.SAVE_UPDATE})
	@NotFound(action=NotFoundAction.IGNORE)
	private GapfillingAnswer gapfillingAnswer;

	public Integer getGapfillingId() {
		return gapfillingId;
	}

	public void setGapfillingId(Integer gapfillingId) {
		this.gapfillingId = gapfillingId;
	}

	public String getGapfillingQuestion() {
		return gapfillingQuestion;
	}

	public void setGapfillingQuestion(String gapfillingQuestion) {
		this.gapfillingQuestion = gapfillingQuestion;
	}

	public String getGapfillingImgurl() {
		return gapfillingImgurl;
	}

	public void setGapfillingImgurl(String gapfillingImgurl) {
		this.gapfillingImgurl = gapfillingImgurl;
	}

	public Integer getGapfillingScore() {
		return gapfillingScore;
	}

	public void setGapfillingScore(Integer gapfillingScore) {
		this.gapfillingScore = gapfillingScore;
	}

	public Date getGapfillingCreateDateTime() {
		return gapfillingCreateDateTime;
	}

	public void setGapfillingCreateDateTime(Date gapfillingCreateDateTime) {
		this.gapfillingCreateDateTime = gapfillingCreateDateTime;
	}

	public Timestamp getGapfillingLastUpdateTime() {
		return gapfillingLastUpdateTime;
	}

	public void setGapfillingLastUpdateTime(Timestamp gapfillingLastUpdateTime) {
		this.gapfillingLastUpdateTime = gapfillingLastUpdateTime;
	}

	public Integer getGapfillingExt1() {
		return gapfillingExt1;
	}

	public void setGapfillingExt1(Integer gapfillingExt1) {
		this.gapfillingExt1 = gapfillingExt1;
	}

	public String getGapfillingExt2() {
		return gapfillingExt2;
	}

	public void setGapfillingExt2(String gapfillingExt2) {
		this.gapfillingExt2 = gapfillingExt2;
	}

	public GapfillingAnswer getGapfillingAnswer() {
		return gapfillingAnswer;
	}

	public void setGapfillingAnswer(GapfillingAnswer gapfillingAnswer) {
		this.gapfillingAnswer = gapfillingAnswer;
	}

	public Integer getGapfillingCourseId() {
		return gapfillingCourseId;
	}

	public void setGapfillingCourseId(Integer gapfillingCourseId) {
		this.gapfillingCourseId = gapfillingCourseId;
	}

	public Integer getGapfillingChapterId() {
		return gapfillingChapterId;
	}

	public void setGapfillingChapterId(Integer gapfillingChapterId) {
		this.gapfillingChapterId = gapfillingChapterId;
	}

	
	
	
}
