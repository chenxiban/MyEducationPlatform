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
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @Description:   贴子实体类
 * @ClassName:     Post.java
 * @author         王梦霞
 */

@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor // 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Builder // 使用建造模型
@Entity
@Table(name = "tb_post")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	@Column(columnDefinition = "int unsigned NOT NULL COMMENT '帖子id'")
	private Integer postId;
	@Column(columnDefinition = "int  NOT NULL COMMENT '发帖人id'")
	private Integer userId;
	@Column(columnDefinition = "varchar(200)  NULL COMMENT '用户头像路经'  ")
	private String userTouurl;
	@Column(columnDefinition = "varchar(50) NOT NULL COMMENT '发帖人昵称'  ")
	private String postName;
	@Column(columnDefinition = "varchar(100) NOT NULL COMMENT '帖子标题'  ")
	private String postTitle;
	@Column(columnDefinition = "varchar(2000) NOT NULL COMMENT '帖子内容'  ")
	private String postContent;
	@Column(columnDefinition = "tinyint unsigned DEFAULT 0 COMMENT '是否置顶' ")
	private Integer  postTop;
	@Column(columnDefinition = "tinyint unsigned DEFAULT 0 COMMENT '是否举报成功'  ")
	private Integer postReport;
	@Column(columnDefinition = "datetime COMMENT '创建时间' ")
	private Date postCreatetime;
	@Column(columnDefinition = "timestamp COMMENT '最后一次修改时间'", nullable = false, updatable = false, insertable = false)
	private Timestamp postUpdateTime; 
	
	@JsonIgnore
	@ManyToOne(targetEntity = Bar.class)
	@JoinColumn(name="bar_id")	//副表中的外键字段名称
	private Bar bar;
	
	@OneToMany(mappedBy="post",fetch=FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
	private List<Postreport> list1 = new ArrayList<>();
	
	@OneToMany(mappedBy="post",fetch=FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
	private List<Postlike> list2 = new ArrayList<>();
	
	@OneToMany(mappedBy="post",fetch=FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
	private List<Postcommit> list3= new ArrayList<>();
	
	@Transient
	private String barCategory;
	
	
}
