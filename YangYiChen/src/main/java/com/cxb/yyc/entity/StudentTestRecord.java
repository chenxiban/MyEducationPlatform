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
 * 对学生测试的记录
 * @author dell
 *
 */
@Entity
@Table(name="studenttestrecordtb")
public class StudentTestRecord {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned comment '备注：学生测试记录主键'")
	private Integer studenttestrecordId;
	@Column(columnDefinition="varchar(225) NOT NULL comment '备注：学生测试的问题' ")
	private String studenttestrecordQuestions;
	@Column(columnDefinition="varchar(225) comment '备注：学生填写测试的答案' ")
	private String studenttestrecordAnswers;
	@JsonFormat(locale="zh",timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
	@Column(columnDefinition="datetime comment '备注：创建学生测试记录表的时间' ")
	private Date studenttestrecordCreateDateTime;
	@Column(columnDefinition="TIMESTAMP comment '备注：最后一次修改学生测试记录表的时间' ",nullable=false,updatable=false,insertable=false)
	private Timestamp studenttestrecordLastUpdateTime;
	private Integer studenttestrecordExt1;
	@Column(length=225)
	private String studenttestrecordExt2;
	@Column(columnDefinition="int unsigned comment '备注：课程外键' ")
	private Integer studenttestrecordCourseId;
	@Column(columnDefinition="int unsigned comment '备注：章节外键' ")
	private Integer studenttestrecordChapterId;
	@Column(columnDefinition="int unsigned comment '备注：学生外键' ")
	private Integer studenttestrecordStudentId;
	@Column(columnDefinition="int unsigned comment '备注：学生测试外键' ")
	private Integer studenttestrecordStudenttestId;
	
	
	
	public Integer getStudenttestrecordCourseId() {
		return studenttestrecordCourseId;
	}
	public void setStudenttestrecordCourseId(Integer studenttestrecordCourseId) {
		this.studenttestrecordCourseId = studenttestrecordCourseId;
	}
	public Integer getStudenttestrecordChapterId() {
		return studenttestrecordChapterId;
	}
	public void setStudenttestrecordChapterId(Integer studenttestrecordChapterId) {
		this.studenttestrecordChapterId = studenttestrecordChapterId;
	}
	public Integer getStudenttestrecordStudentId() {
		return studenttestrecordStudentId;
	}
	public void setStudenttestrecordStudentId(Integer studenttestrecordStudentId) {
		this.studenttestrecordStudentId = studenttestrecordStudentId;
	}
	public Integer getStudenttestrecordId() {
		return studenttestrecordId;
	}
	public void setStudenttestrecordId(Integer studenttestrecordId) {
		this.studenttestrecordId = studenttestrecordId;
	}
	public String getStudenttestrecordQuestions() {
		return studenttestrecordQuestions;
	}
	public void setStudenttestrecordQuestions(String studenttestrecordQuestions) {
		this.studenttestrecordQuestions = studenttestrecordQuestions;
	}
	public String getStudenttestrecordAnswers() {
		return studenttestrecordAnswers;
	}
	public void setStudenttestrecordAnswers(String studenttestrecordAnswers) {
		this.studenttestrecordAnswers = studenttestrecordAnswers;
	}
	public Date getStudenttestrecordCreateDateTime() {
		return studenttestrecordCreateDateTime;
	}
	public void setStudenttestrecordCreateDateTime(Date studenttestrecordCreateDateTime) {
		this.studenttestrecordCreateDateTime = studenttestrecordCreateDateTime;
	}
	public Timestamp getStudenttestrecordLastUpdateTime() {
		return studenttestrecordLastUpdateTime;
	}
	public void setStudenttestrecordLastUpdateTime(Timestamp studenttestrecordLastUpdateTime) {
		this.studenttestrecordLastUpdateTime = studenttestrecordLastUpdateTime;
	}
	public Integer getStudenttestrecordExt1() {
		return studenttestrecordExt1;
	}
	public void setStudenttestrecordExt1(Integer studenttestrecordExt1) {
		this.studenttestrecordExt1 = studenttestrecordExt1;
	}
	public String getStudenttestrecordExt2() {
		return studenttestrecordExt2;
	}
	public void setStudenttestrecordExt2(String studenttestrecordExt2) {
		this.studenttestrecordExt2 = studenttestrecordExt2;
	}
	public Integer getStudenttestrecordStudenttestId() {
		return studenttestrecordStudenttestId;
	}
	public void setStudenttestrecordStudenttestId(Integer studenttestrecordStudenttestId) {
		this.studenttestrecordStudenttestId = studenttestrecordStudenttestId;
	}
	
	
}
