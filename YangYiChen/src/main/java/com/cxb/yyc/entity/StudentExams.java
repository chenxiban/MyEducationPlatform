package com.cxb.yyc.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 学生考试
 * @author dell
 *
 */
@Entity
@Table(name="studentexamstb")
public class StudentExams {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned comment '备注：学生考试主键' ")
	private Integer studentexamsId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：学生考试分数' ")
	private Integer studentexamsScore;
	@JsonFormat(locale="zh",timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
	@Column(nullable=false,columnDefinition="datetime comment '备注：学生考试开始时间' ")
	private Date studentexamsCreateDateTime;
	@JsonFormat(locale="zh",timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
	@Column(nullable=false,columnDefinition="datetime comment '备注：学生考试截止时间' ")
	private Date studentexamsDeadlineTime;
	@Column(columnDefinition="TIMESTAMP comment '备注：修改时间' ",nullable=false,updatable=false,insertable=false)
	private Timestamp studentexamsLastUpdateTime;
	private Integer studenttestExt1;
	@Column(length=225)
	private String studenttestExt2;
	
	@Column(columnDefinition="int unsigned comment '备注：课程外键' ")
	private Integer studenttestCourseId;
	@Column(columnDefinition="int unsigned comment '备注：学生外键' ")
	private Integer studenttestStudentId;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER,mappedBy="studentExams")
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	private StudentExamsRecord studentExamsRecord;
	
	
	
	public Integer getStudenttestCourseId() {
		return studenttestCourseId;
	}
	public void setStudenttestCourseId(Integer studenttestCourseId) {
		this.studenttestCourseId = studenttestCourseId;
	}
	public Integer getStudenttestStudentId() {
		return studenttestStudentId;
	}
	public void setStudenttestStudentId(Integer studenttestStudentId) {
		this.studenttestStudentId = studenttestStudentId;
	}
	public Integer getStudentexamsId() {
		return studentexamsId;
	}
	public void setStudentexamsId(Integer studentexamsId) {
		this.studentexamsId = studentexamsId;
	}
	public Integer getStudentexamsScore() {
		return studentexamsScore;
	}
	public void setStudentexamsScore(Integer studentexamsScore) {
		this.studentexamsScore = studentexamsScore;
	}
	public Date getStudentexamsCreateDateTime() {
		return studentexamsCreateDateTime;
	}
	public void setStudentexamsCreateDateTime(Date studentexamsCreateDateTime) {
		this.studentexamsCreateDateTime = studentexamsCreateDateTime;
	}
	public Date getStudentexamsDeadlineTime() {
		return studentexamsDeadlineTime;
	}
	public void setStudentexamsDeadlineTime(Date studentexamsDeadlineTime) {
		this.studentexamsDeadlineTime = studentexamsDeadlineTime;
	}
	public Timestamp getStudentexamsLastUpdateTime() {
		return studentexamsLastUpdateTime;
	}
	public void setStudentexamsLastUpdateTime(Timestamp studentexamsLastUpdateTime) {
		this.studentexamsLastUpdateTime = studentexamsLastUpdateTime;
	}
	public Integer getStudenttestExt1() {
		return studenttestExt1;
	}
	public void setStudenttestExt1(Integer studenttestExt1) {
		this.studenttestExt1 = studenttestExt1;
	}
	public String getStudenttestExt2() {
		return studenttestExt2;
	}
	public void setStudenttestExt2(String studenttestExt2) {
		this.studenttestExt2 = studenttestExt2;
	}
	
}
