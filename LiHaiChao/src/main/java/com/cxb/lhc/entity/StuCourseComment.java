package com.cxb.lhc.entity;
 
import java.sql.Timestamp; 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
 
/**
 * 
 * @author Administrator
 * @Description:   学生评价表
 * @ClassName:     stuCourseComment.java  
 * @author         Lihaichao 
 * @Date           2018-12-6 下午4:43:05  
 * @Email          1273822019@qq.com
 *
 */
@Entity	// HQL 使用,默认类名
@Table(name="stucoursecomment")	//数据库原生SQL使用,默认
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StuCourseComment {
	@Id	//实体类的主键
	@GeneratedValue(strategy= GenerationType.IDENTITY)//自动增长列
	@OrderBy	//数据加载顺序
	@Column(columnDefinition="int unsigned  comment '备注:学生评价表自增ID'  ")
	private Integer commentId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:课程ID'  ")
	private Integer courseId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:学生ID'  ")
	private	Integer studentId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:评价星级'  ")
	private Integer commentStart;
	@Column(columnDefinition="varchar(255) NOT NULL comment '备注:评价内容'  ")
	private String  commentContext;
	@Column(nullable=false,columnDefinition="date comment '备注:评价时间' ")	
	//private Date commentTime=new Date();
	private Date commentTime;
	@Column(columnDefinition="TIMESTAMP comment '备注:评价修改时间' ",nullable=false,updatable=false,insertable=false)	//自定义字段类型
	private Timestamp commentUpdateTime;
	@Column(columnDefinition="varchar(255) NOT NULL comment '备注:第几次开课'  ")
	private String  courseCount;
	@Transient 
	private String  exel1;
	
	@JsonIgnore
	@OneToMany(mappedBy="stucoursecomment",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<StuGivePraise> list = new ArrayList<>();
	
	

}
