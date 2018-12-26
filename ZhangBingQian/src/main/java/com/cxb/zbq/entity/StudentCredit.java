package com.cxb.zbq.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="studentCreditTb")

public class StudentCredit {//学分表
	@Id
	@GeneratedValue
	private Integer studentCreditId;//学分表id
	private Integer studentId;//学生id
	private Integer curriculumId;//课程id
	private Double credit;//学分
	@Column(columnDefinition="timestamp")
	private Timestamp lastUpdateTime;//最后一次修改时间
	@Transient
	private String studentCreditParam;//临时参数
	public Integer getStudentCreditId() {
		return studentCreditId;
	}
	public void setStudentCreditId(Integer studentCreditId) {
		this.studentCreditId = studentCreditId;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Integer getCurriculumId() {
		return curriculumId;
	}
	public void setCurriculumId(Integer curriculumId) {
		this.curriculumId = curriculumId;
	}
	public Double getCredit() {
		return credit;
	}
	public void setCredit(Double credit) {
		this.credit = credit;
	}
	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getStudentCreditParam() {
		return studentCreditParam;
	}
	public void setStudentCreditParam(String studentCreditParam) {
		this.studentCreditParam = studentCreditParam;
	}
	@Override
	public String toString() {
		return "StudentCredit [studentCreditId=" + studentCreditId + ", studentId=" + studentId + ", curriculumId="
				+ curriculumId + ", credit=" + credit + ", lastUpdateTime=" + lastUpdateTime + ", studentCreditParam="
				+ studentCreditParam + "]";
	}
	public StudentCredit(Integer studentCreditId, Integer studentId, Integer curriculumId, Double credit,
			Timestamp lastUpdateTime, String studentCreditParam) {
		super();
		this.studentCreditId = studentCreditId;
		this.studentId = studentId;
		this.curriculumId = curriculumId;
		this.credit = credit;
		this.lastUpdateTime = lastUpdateTime;
		this.studentCreditParam = studentCreditParam;
	}
	public StudentCredit() {
		super();
	}

}
