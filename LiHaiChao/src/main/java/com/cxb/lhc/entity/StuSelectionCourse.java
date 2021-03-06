package com.cxb.lhc.entity;
 
import java.sql.Timestamp;  

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

/**
 * 
 * @author Administrator
 * @Description:   学生选课表
 * @ClassName:     stuSelectionCourse.java  
 * @author         Lihaichao 
 * @Date           2018-12-6 下午4:43:05  
 * @Email          1273822019@qq.com
 */
@Entity	// HQL 使用,默认类名  
@Table(name="stuselectioncourse")	//数据库原生SQL使用,默认表名
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StuSelectionCourse {
	@Id	//实体类的主键
	@GeneratedValue(strategy= GenerationType.IDENTITY)	//自动增长列
	@OrderBy	//数据加载顺序
	@Column(columnDefinition="int unsigned  comment '备注:学生选课表自增ID'  ")
	private Integer stuSelectionCourseId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:课程ID'  ")
	private Integer courseId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:学生ID'  ")
	private Integer studentId;
	@Column(columnDefinition="timestamp  NOT NULL comment '备注:选课时间'  ")
	private Timestamp selectionCourseTime;
	@Transient
	private String  exel1;
	@Transient
	private String exel2;
	@Transient
	private String  exel3;
	
	
	
	
}
