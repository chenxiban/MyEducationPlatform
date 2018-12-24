package com.cxb.wmx.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @Description:   课程讨论举报表
 * @ClassName:     disreport.java
 * @author         刘森川
 */
@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor// 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Builder // 使用建造模型
@Entity
@Table(name = "tb_disreport")
public class Disreport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	@Column(columnDefinition = "int unsigned NOT NULL  COMMENT '评论举报主键'")
	private Integer disreportId;
	@Column(columnDefinition = "int  NOT NULL COMMENT '举报的用户id'")
	private Integer userId;
	@Column(columnDefinition = "varchar(200) NOT NULL COMMENT '举报内容'  ")
	private  String disreportContent;
	@Column(columnDefinition = "tinyint unsigned DEFAULT 0 COMMENT '举报信息审核状态' ")
	private Integer  disreportStuts;
	@Column(columnDefinition = "datetime COMMENT '发表时间' ")
	private Date disreportCreatetime;
	@Column(columnDefinition = "timestamp COMMENT '最后一次修改时间'", nullable = false, updatable = false, insertable = false)
	private Timestamp disreportUpdatetime;
	
	@JsonIgnore
	@ManyToOne(targetEntity = Dispost.class)
	@JoinColumn(name="dispost_id")	//副表中的外键字段名称
	private Dispost dispost;
	
}
