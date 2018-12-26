package com.cxb.lhc.entity;
 
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @Description:   学生点赞表
 * @ClassName:     stuGivePraise.java 
 * @author         Lihaichao 
 * @Date           2018-12-6 下午4:43:05   
 * @Email          1273822019@qq.com
 */
@Entity	// HQL 使用,默认类名 
@Table(name="stugivepraise")	//数据库原生SQL使用,默认
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StuGivePraise {
	@Id	//实体类的主键
	@GeneratedValue(strategy= GenerationType.IDENTITY)	//自动增长列
	@OrderBy	//数据加载顺序
	@Column(columnDefinition="int unsigned  comment '备注:学生点赞表自增ID'  ")
	private Integer givePraiseId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:学生ID'  ")
	private Integer studentId;
	//@Column(columnDefinition="int unsigned NOT NULL comment '备注:评价ID'  ")
	//private Integer commentId;
	@Column(columnDefinition="tinyint(0) NOT NULL comment '备注:对评价的点赞状态'  ")  //0代表false 1 代表true
	private Integer givePraiseState;
	@Column(columnDefinition="tinyint(0) NOT NULL comment '备注:对评价踩赞个状态'  ")	  //0代表false 1 代表true
	private Integer notPraiseState;
	@Transient
	private String  exel1;
	@Transient
	private String  exel2;
	@Transient
	private String  exel3;
	@JsonIgnore
	@ManyToOne(targetEntity = StuCourseComment.class)
	@JoinColumn(name="commentId")	//副表中的外键字段名称(即主表中的主键)
	private StuCourseComment stucoursecomment; 
	
	

}
