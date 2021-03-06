package com.cxb.wmx.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

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

import com.cxb.wmx.entity.Post.PostBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @Description:   贴子点赞
 * @ClassName:     Postlike.java
 * @author         王梦霞
 */

@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor // 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Builder // 使用建造模型
@Entity
@Table(name = "tb_postlike")
public class Postlike {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	@Column(columnDefinition = "int unsigned NOT NULL COMMENT '帖子点赞id'")
	private Integer postlikeId;
	@Column(columnDefinition = "int  NOT NULL COMMENT '点/反的用户的id'")
	private Integer userId;
	@Column(columnDefinition = "tinyint unsigned DEFAULT 0 COMMENT '点赞,反对,状态' ")
	private Integer postlikeStuts;
	@Column(columnDefinition = "datetime COMMENT '创建时间' ")
	private Date postlikeCreatetime;
	@Column(columnDefinition = "timestamp COMMENT '最后一次修改时间'", nullable = false, updatable = false, insertable = false)
	private Timestamp postlikeUpdateTime; 
	
	
	@JsonIgnore
	@ManyToOne(targetEntity = Post.class)
	@JoinColumn(name="post_id")	//副表中的外键字段名称
	private Post post;
	
	@Transient
	private Integer number;
	@Transient
	private Integer page;
	@Transient
	private Integer rows;
	@Transient
	private Integer postLike;
	@Transient
	private Integer postDisLike;
}
