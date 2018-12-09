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

import com.cxb.wmx.entity.Disbar.DisbarBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @Description:   课程讨论点赞表
 * @ClassName:     Dislike.java
 * @author         刘森川
 */
@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor// 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Builder // 使用建造模型
@Entity
@Table(name = "tb_dislike")
public class Dislike {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	@Column(columnDefinition = "int unsigned NOT NULL  COMMENT '课程点赞主键'")
	private Integer dislikeId;
	@Column(columnDefinition = "int  NOT NULL COMMENT '点/反的用户的id'")
	private Integer userId;
	@Column(columnDefinition = "tinyint unsigned DEFAULT 0 COMMENT '状态'  ")
	private Integer dislikeStuts;
	@Column(columnDefinition = "datetime COMMENT '创建时间' ")
	private Date dislikeCreatetime;
	@Column(columnDefinition = "timestamp COMMENT '最后一次修改时间'", nullable = false, updatable = false, insertable = false)
	private Timestamp dislikeUpdatetime;
	
	
	@JsonIgnore
	@ManyToOne(targetEntity = Dispost.class)
	@JoinColumn(name="dispost_id")	//副表中的外键字段名称
	private Dispost dispost;
}
