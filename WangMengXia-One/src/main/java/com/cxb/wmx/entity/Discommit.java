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
import javax.persistence.Transient;

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

/*	discommit_id字段,int类型,主键自增,非空,备注:课程评论id主键
	dispost_id字段,int类型,非空,外键,备注:课程帖子外键
	user_id字段,int类型,非空,备注:评论人id
	discommit_name字段,varchar(30)类型,非空,备注:课程评论人姓名
	discommit_count字段,varchar类型,非空,备注:课程评论内容
	discommit_report字段,tinyint(0否,1是),备注:是否举报
	discommit_like字段,tinyint(0否,1是),备注:是否点赞
	discommit_createtime字段,datetime类型,非空,备注:创建时间
	discommit_updatetime字段,时间戳,非空,备注:修改时间*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	@Column(columnDefinition = "int unsigned NOT NULL COMMENT '帖子评论id'")
	private Integer discommitId;
	@Column(columnDefinition = "int  NOT NULL COMMENT '评论人id'")
	private Integer userId;
	@Column(columnDefinition = "varchar(50) NOT NULL COMMENT '评论人昵称'  ")
	private String discommitName;
	@Column(columnDefinition = "varchar(500) NOT NULL COMMENT '评论内容'  ")
	private String discommitCount;
	@Column(columnDefinition = "tinyint unsigned DEFAULT 0 COMMENT '是否举报成功' ")
	private Integer discommitReport;
	@Column(columnDefinition = "datetime COMMENT '创建时间' ")
	private Date discommitCreatetime;
	@Column(columnDefinition = "timestamp COMMENT '最后一次修改时间'", nullable = false, updatable = false, insertable = false)
	private Timestamp discommitUpdatetime; 
	
	@Transient
	private int page=0;
	@Transient
	private int rows=10;
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
