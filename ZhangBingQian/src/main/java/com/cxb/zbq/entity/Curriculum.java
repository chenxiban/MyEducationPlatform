package com.cxb.zbq.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
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
	@OrderBy
	private Integer curriculumId;//课程id
	private String curriculumName;//课程名称
	private Integer curriculumCategoryId;//类别id
	private Integer teacherId;//老师id
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")	//日期格式化为中国的时区 东8区
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")	//接受::字符串日期需要格式化为日期类型
	private Date creationTime=new Date();//创建时间
	@Column(columnDefinition="int unsigned DEFAULT 0")
	private Integer subscriptionNum;//订阅人数
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")	//日期格式化为中国的时区 东8区
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")	//接受::字符串日期需要格式化为日期类型
	private Date startTime;//开课时间
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")	//日期格式化为中国的时区 东8区
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")	//接受::字符串日期需要格式化为日期类型
	private Date endTime;//结束开课时间
	@Column(columnDefinition="varchar(1000) DEFAULT NULL")
	private String courseIntroduction;//课程介绍
	@Column(columnDefinition="int unsigned DEFAULT 0")
	private Integer whetherToIssue;//是否发布
	@Column(columnDefinition="timestamp")
	private Timestamp lastUpdateTime;//最后一次修改时间
	@Transient
	private String remarkParam;//临时参数
	
	
	

}
