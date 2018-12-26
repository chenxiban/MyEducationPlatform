package com.cxb.cyj.entity;

import java.sql.Timestamp;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Curriculum {//课程表
	
	private Integer curriculumId;//课程id
	private String curriculumName;//课程名称
	private Integer curriculumCategoryId;//类别id
	private Integer teacherId;//老师id
	private Date creationTime=new Date();//创建时间
	private Integer subscriptionNum;//订阅人数
	private Date startTime;//开课时间
	private Date endTime;//结束开课时间
	private String courseIntroduction;//课程介绍
	private Integer whetherToIssue;//是否发布
	private Timestamp lastUpdateTime;//最后一次修改时间
	private String remarkParam;//临时参数
	
}
