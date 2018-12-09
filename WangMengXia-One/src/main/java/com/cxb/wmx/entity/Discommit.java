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

import com.cxb.wmx.entity.Disbar.DisbarBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @Description:   课程讨论评论表
 * @ClassName:     Discommit.java
 * @author         刘森川
 */
@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor// 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Builder // 使用建造模型
@Entity
@Table(name = "tb_discommit")
public class Discommit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	@Column(columnDefinition = "int unsigned NOT NULL  COMMENT '课程评论id主键'")
	private Integer discommitId;
	@Column(columnDefinition = "int  NOT NULL COMMENT '评论人id'")
	private Integer userId;
	@Column(columnDefinition = "varchar(30) NOT NULL COMMENT '课程评论人姓名'  ")
	private  String discommitName;
	@Column(columnDefinition = "tinyint unsigned DEFAULT 0 COMMENT '是否举报成功'  ")
	private Integer discommitReport;
	@Column(columnDefinition = "varchar(200) NOT NULL COMMENT '课程评论内容'  ")
	private  String discommitCount;
	@Column(columnDefinition = "datetime COMMENT '创建时间 ")
	private Date discommitCreatetime;
	@Column(columnDefinition = "timestamp COMMENT '最后一次修改时间'", nullable = false, updatable = false, insertable = false)
	private Timestamp discommitUpdatetime;
	
	
	@JsonIgnore
	@ManyToOne(targetEntity = Dispost.class)
	@JoinColumn(name="dispost_id")	//副表中的外键字段名称
	private Dispost dispost;
	
	
	@OneToMany(mappedBy="discommit",fetch=FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
	private List<Dispostreply> list = new ArrayList<>();
	
	@OneToMany(mappedBy="discommit",fetch=FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
	private List<Discomreport> list1 = new ArrayList<>();
	
	@OneToMany(mappedBy="discommit",fetch=FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
	private List<Disclazzlike> list2 = new ArrayList<>();
}
