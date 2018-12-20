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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 对学生考试的记录
 * @author dell
 *
 */
@Entity
@Table(name="studentexamsrecordtb")
public class StudentExamsRecord {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned comment '备注：学生考试记录主键' ")
	private Integer studentexamsrecordId;
	@Column(columnDefinition="varchar(225) NOT NULL comment '备注：记录学生考试问题' ")
	private String studentexamsrecordQuestion;
	@Column(columnDefinition="varchar(225) comment '备注：记录学生考试针对问题选择的答案' ")
	private String studentexamsrecordAnswer;
	@JsonFormat(locale="zh",timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
	@Column(columnDefinition="datetime comment '备注：学生考试记录创建时间' ")
	private Date studentexamsrecordCreateDateTime;
	@Column(columnDefinition="TIMESTAMP comment '备注：学生考试记录修改时间' ",nullable=false,updatable=false,insertable=false)
	private Timestamp studentexamsrecordLastUpdateTime;
	private Integer studentexamsrecordExt1;
	@Column(length=225)
	private String studentexamsrecordExt2;
	@Column(columnDefinition="int unsigned comment '备注：课程外键' ")
	private Integer studentexamsrecordCourseId;
	@Column(columnDefinition="int unsigned comment '备注：学生外键' ")
	private Integer studentexamsrecordStudentId;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	@JoinColumn(name = "studentexamsrecord_studentexamsId",nullable=false)
	private StudentExams studentExams;
	
	public Integer getStudentexamsrecordId() {
		return studentexamsrecordId;
	}
	public void setStudentexamsrecordId(Integer studentexamsrecordId) {
		this.studentexamsrecordId = studentexamsrecordId;
	}
	public String getStudentexamsrecordQuestion() {
		return studentexamsrecordQuestion;
	}
	public void setStudentexamsrecordQuestion(String studentexamsrecordQuestion) {
		this.studentexamsrecordQuestion = studentexamsrecordQuestion;
	}
	public String getStudentexamsrecordAnswer() {
		return studentexamsrecordAnswer;
	}
	public void setStudentexamsrecordAnswer(String studentexamsrecordAnswer) {
		this.studentexamsrecordAnswer = studentexamsrecordAnswer;
	}
	public Date getStudentexamsrecordCreateDateTime() {
		return studentexamsrecordCreateDateTime;
	}
	public void setStudentexamsrecordCreateDateTime(Date studentexamsrecordCreateDateTime) {
		this.studentexamsrecordCreateDateTime = studentexamsrecordCreateDateTime;
	}
	public Timestamp getStudentexamsrecordLastUpdateTime() {
		return studentexamsrecordLastUpdateTime;
	}
	public void setStudentexamsrecordLastUpdateTime(Timestamp studentexamsrecordLastUpdateTime) {
		this.studentexamsrecordLastUpdateTime = studentexamsrecordLastUpdateTime;
	}
	public Integer getStudentexamsrecordExt1() {
		return studentexamsrecordExt1;
	}
	public void setStudentexamsrecordExt1(Integer studentexamsrecordExt1) {
		this.studentexamsrecordExt1 = studentexamsrecordExt1;
	}
	public String getStudentexamsrecordExt2() {
		return studentexamsrecordExt2;
	}
	public void setStudentexamsrecordExt2(String studentexamsrecordExt2) {
		this.studentexamsrecordExt2 = studentexamsrecordExt2;
	}
	
}
