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

import com.cxb.wmx.entity.Postcommit.PostcommitBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @Description:   帖子回复表
 * @ClassName:     Postreply.java
 * @author         王梦霞
 */

@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor // 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Builder // 使用建造模型
@Entity
@Table(name = "tb_postreply")
public class Postreply {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	@Column(columnDefinition = "int unsigned NOT NULL COMMENT '帖子回复id'")
	private Integer postreplyId;
	@Column(columnDefinition = "int  NOT NULL COMMENT '回复人id'")
	private Integer userId;
	@Column(columnDefinition = "varchar(20)  NOT NULL COMMENT '回复人昵称'")
	private String userName;
	@Column(columnDefinition = "varchar(500) NOT NULL COMMENT '回复内容'  ")
	private String postreplyCount;
	@Column(columnDefinition = "tinyint unsigned DEFAULT 0 COMMENT '是否举报成功' ")
	private Integer postreplyReport;
	@Column(columnDefinition = "datetime COMMENT '创建时间' ")
	private Date postreplyCreatetime;
	@Column(columnDefinition = "timestamp COMMENT '最后一次修改时间'", nullable = false, updatable = false, insertable = false)
	private Timestamp postreplyUpdateTime;
	@Transient
	private Integer replyCount;
	@JsonIgnore
	@ManyToOne(targetEntity = Postcommit.class)
	@JoinColumn(name="postcommit_id")	//副表中的外键字段名称
	private Postcommit postcommit;
	
	@JsonIgnore
	@OneToMany(mappedBy="postreply",fetch=FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
	private List<Postreplyreport> list1 = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="postreply",fetch=FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
	private List<Postreplylike> list2 = new ArrayList<>();
	
}
