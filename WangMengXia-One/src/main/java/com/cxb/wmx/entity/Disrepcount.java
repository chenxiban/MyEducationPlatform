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
 * @Description:   课程讨论举报内容表
 * @ClassName:     disrepcount.java
 * @author         刘森川
 */
@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor// 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Builder // 使用建造模型
@Entity
@Table(name = "tb_disrepcount")
public class Disrepcount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	@Column(columnDefinition = "int unsigned NOT NULL  COMMENT '帖子举报主键'")
	private Integer disrepcountId;
	@Column(columnDefinition = "varchar(200) NOT NULL COMMENT 返还的举报内容'  ")
	private  String disrepcountContent;
	@Column(columnDefinition = "datetime COMMENT '发表时间' ")
	private Date disrepcountCreatetime;
	@Column(columnDefinition = "timestamp COMMENT '最后一次修改时间'", nullable = false, updatable = false, insertable = false)
	private Timestamp disreportUpdatetime;
	
	@JsonIgnore
	@ManyToOne(targetEntity = Disreport.class)
	@JoinColumn(name="disreport_id")	//副表中的外键字段名称
	private Disreport disreport;
}
