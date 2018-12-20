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
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 学生测试
 * @author dell
 *
 */
@Entity
@Table(name="studenttesttb")
public class StudentTest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned comment '备注：学生测试主键' ")
	private Integer studenttestId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：学生测试分数' ")
	private Integer studenttestScore;
	@JsonFormat(locale="zh",timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")//后台到前台的时间格式的转换
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//前台到后台的时间格式的转换	@Column(nullable=false,columnDefinition="datetime comment '备注：学生测试截止时间' ")
	private Date studenttestDeadlineTime;
	@JsonFormat(locale="zh",timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
	@Column(nullable=false,columnDefinition="datetime comment '备注：创建该表测试时间' ")
	private Date studenttestCreateDateTime;
	@Column(columnDefinition="TIMESTAMP comment '备注：修改该表测试时间' ",nullable=false,updatable=false,insertable=false)
	private Timestamp studenttestLastUpdateTime;
	@Column(columnDefinition="int unsigned DEFAULT 0 comment '备注：学生已经测试的次数' ")
	private Integer studenttestNumber;
	private Integer studenttestExt1;
	@Column(length=225)
	private String studenttestExt2;
	@Column(columnDefinition="int unsigned  comment '备注：章节外键' ")
	private Integer studenttestChapterId;
	@Column(columnDefinition="int unsigned comment '备注：学生外键' ")
	private Integer studenttestStudentId;

	
	public Integer getStudenttestId() {
		return studenttestId;
	}
	public void setStudenttestId(Integer studenttestId) {
		this.studenttestId = studenttestId;
	}
	public Integer getStudenttestScore() {
		return studenttestScore;
	}
	public void setStudenttestScore(Integer studenttestScore) {
		this.studenttestScore = studenttestScore;
	}
	public Date getStudenttestDeadlineTime() {
		return studenttestDeadlineTime;
	}
	public void setStudenttestDeadlineTime(Date studenttestDeadlineTime) {
		this.studenttestDeadlineTime = studenttestDeadlineTime;
	}
	public Date getStudenttestCreateDateTime() {
		return studenttestCreateDateTime;
	}
	public void setStudenttestCreateDateTime(Date studenttestCreateDateTime) {
		this.studenttestCreateDateTime = studenttestCreateDateTime;
	}
	public Timestamp getStudenttestLastUpdateTime() {
		return studenttestLastUpdateTime;
	}
	public void setStudenttestLastUpdateTime(Timestamp studenttestLastUpdateTime) {
		this.studenttestLastUpdateTime = studenttestLastUpdateTime;
	}
	public Integer getStudenttestNumber() {
		return studenttestNumber;
	}
	public void setStudenttestNumber(Integer studenttestNumber) {
		this.studenttestNumber = studenttestNumber;
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
	public Integer getStudenttestChapterId() {
		return studenttestChapterId;
	}
	public void setStudenttestChapterId(Integer studenttestChapterId) {
		this.studenttestChapterId = studenttestChapterId;
	}
	public Integer getStudenttestStudentId() {
		return studenttestStudentId;
	}
	public void setStudenttestStudentId(Integer studenttestStudentId) {
		this.studenttestStudentId = studenttestStudentId;
	}
	
	

}
