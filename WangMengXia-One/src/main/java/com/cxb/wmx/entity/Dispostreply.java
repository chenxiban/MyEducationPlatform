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

import com.cxb.wmx.entity.Dispost.DispostBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @Description:   课程回复表
 * @ClassName:     Dispostreply.java
 * @author         刘森川
 */
@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor// 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Builder // 使用建造模型
@Entity
@Table(name = "tb_dispostreply")
public class Dispostreply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	@Column(columnDefinition = "int unsigned NOT NULL  COMMENT '课程回复主键'")
	private Integer dispostreplyId;
	@Column(columnDefinition = "int  NOT NULL COMMENT '回复人id需个人中心提供数据'")
	private Integer userId;
	@Column(columnDefinition = "varchar(2000) NOT NULL COMMENT '回复内容'  ")
	private  String dispostreplyName;
	@Column(columnDefinition = "tinyint unsigned DEFAULT 0 COMMENT '是否举报成功'  ")
	private Integer dispostreplyReport;
	@Column(columnDefinition = "datetime COMMENT '评论时间' ")
	private Date dispostreplyCreatetime;
	@Column(columnDefinition = "timestamp COMMENT '最后一次修改时间'", nullable = false, updatable = false, insertable = false)
	private Timestamp dispostreplyUpdatetime;
	
	@JsonIgnore
	@ManyToOne(targetEntity = Discommit.class)
	@JoinColumn(name="discommit_id")	//副表中的外键字段名称
	private Discommit discommit;
	
	@OneToMany(mappedBy="dispostreply",fetch=FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
	private List<Disreply> list = new ArrayList<>();
	
	@OneToMany(mappedBy="dispostreply",fetch=FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
	private List<Disreplylike> list1 = new ArrayList<>();
}
