package com.cxb.wmx.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @Description:   帖子评论举报表
 * @ClassName:     Discomreport.java
 * @author         刘森川
 */
@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor// 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Builder // 使用建造模型
@Entity
@Table(name = "tb_discomreport")
public class Discomreport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	@Column(columnDefinition = "int unsigned NOT NULL  COMMENT '评论举报主键'")
	private Integer discomreportId;
	@Column(columnDefinition = "int  NOT NULL COMMENT '举报的用户id'")
	private Integer userId;
	@Column(columnDefinition = "varchar(200) NOT NULL COMMENT '举报内容'  ")
	private  String discomreportContent;
	@Column(columnDefinition = "tinyint unsigned DEFAULT 0 COMMENT '举报信息审核状态' ")
	private Integer  discomreportStuts;
	@Column(columnDefinition = "datetime COMMENT '发表时间' ")
	private Date discomreportCreatetime;
	@Column(columnDefinition = "timestamp COMMENT '最后一次修改时间'", nullable = false, updatable = false, insertable = false)
	private Timestamp discomreportUpdatetime;
	
	
	@JsonIgnore
	@ManyToOne(targetEntity = Discommit.class)
	@JoinColumn(name="discommit_id")	//副表中的外键字段名称
	private Discommit discommit;
}
