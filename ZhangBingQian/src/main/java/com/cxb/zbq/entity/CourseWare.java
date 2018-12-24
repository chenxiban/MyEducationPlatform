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
@Table(name="courseWareTb")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseWare {//课件表
	@Id 
	private String courseWareId;
	@Column(columnDefinition="varchar(1000) DEFAULT NULL")
	private String coursewareDescription;//课件描述
	private Integer classHourId;//课时id
	private String coursewarePath;//课件路径
	private String coursewareType;//课件类型
	@Column(columnDefinition="int unsigned DEFAULT 0")
	private Integer coursewareDuration;//课件时长（秒）
	private String coursewareSize;//课件大小
	private Date coursewareCreationTime=new Date();//创建时间
	@Column(columnDefinition="timestamp")
	private Timestamp lastUpdateTime;//最后一次修改时间
	@Transient
	private String coursewareParam;//临时参数

}
