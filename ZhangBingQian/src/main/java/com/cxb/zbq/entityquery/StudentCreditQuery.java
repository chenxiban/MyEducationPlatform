package com.cxb.zbq.entityquery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class StudentCreditQuery {
	private Integer studentId;
	private Integer minCredit;
	private Integer maxCredit;
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Integer getMinCredit() {
		return minCredit;
	}
	public void setMinCredit(Integer minCredit) {
		this.minCredit = minCredit;
	}
	public Integer getMaxCredit() {
		return maxCredit;
	}
	public void setMaxCredit(Integer maxCredit) {
		this.maxCredit = maxCredit;
	}
	@Override
	public String toString() {
		return "StudentCreditQuery [studentId=" + studentId + ", minCredit=" + minCredit + ", maxCredit=" + maxCredit
				+ "]";
	}
	public StudentCreditQuery(Integer studentId, Integer minCredit, Integer maxCredit) {
		super();
		this.studentId = studentId;
		this.minCredit = minCredit;
		this.maxCredit = maxCredit;
	}
	public StudentCreditQuery() {
		super();
	}
	
}
