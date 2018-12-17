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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

}
