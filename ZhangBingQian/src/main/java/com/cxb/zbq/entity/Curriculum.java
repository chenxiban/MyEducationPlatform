package com.cxb.zbq.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="curriculumTb")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Curriculum {//课程表
	@Id
	@GeneratedValue
	private Integer curriculumId;
	private String curriculumName;
	private String coursesCover;
	private Integer curriculumCategoryId;
	private Integer teacherId;
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")	//日期格式化为中国的时区 东8区
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")	//接受::字符串日期需要格式化为日期类型
	private Date creationTime;
	@Column(columnDefinition="int unsigned DEFAULT 0")
	private Integer subscriptionNum;
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")	//日期格式化为中国的时区 东8区
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")	//接受::字符串日期需要格式化为日期类型
	private Date startTime;
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")	//日期格式化为中国的时区 东8区
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")	//接受::字符串日期需要格式化为日期类型
	private Date endTime;
	@Column(columnDefinition="varchar(1000) DEFAULT NULL")
	private String courseIntroduction;
	@Column(columnDefinition="int unsigned DEFAULT 0")
	private Integer whetherToIssue;
	@Column(columnDefinition="timestamp")
	private Timestamp lastUpdateTime;
	@Transient
	private String remarkParam;//临时参数
	
	
	

}
