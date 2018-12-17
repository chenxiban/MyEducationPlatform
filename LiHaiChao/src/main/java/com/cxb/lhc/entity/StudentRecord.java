package com.cxb.lhc.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Entity	//  HQL 使用,默认类名
@Table(name="studentrecord")	//数据库原生SQL使用,默认
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRecord {
	@Id	//实体类的主键
	@GeneratedValue(strategy= GenerationType.IDENTITY)	//自动增长列
	@OrderBy	//数据加载顺序
	@Column(columnDefinition="int unsigned  comment '备注:学生学习表自增ID'  ")
	private Integer scholeStudentingId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:学生ID'  ")
	private Integer studentId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:章节课时ID'  ")
	private Integer unitCourseId;
	@Column(columnDefinition="int  DEFAULT 0 NOT NULL comment '备注:视频学习时长'  ")
	private int videoStudentingTime;
	@Column(columnDefinition="int  DEFAULT 0 NOT NULL comment '备注:视频退出时间'  ")
	private int videoExitTime;
	@Column(columnDefinition="int DEFAULT 0 NOT NULL comment '备注:视频学习状态'  ")
	private int studentState;
	@Transient 
	private String  exel1;
	@Transient 
	private String  exel2;

}
