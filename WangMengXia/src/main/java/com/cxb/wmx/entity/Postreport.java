package com.cxb.wmx.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
 * @Description:   帖子举报实体类
 * @ClassName:     Postreport.java
 * @author         王梦霞
 */

@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor // 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Builder // 使用建造模型
@Entity
@Table(name = "tb_postreport")
public class Postreport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	@Column(columnDefinition = "int unsigned NOT NULL COMMENT '帖子举报主键'")
	private Integer postreportId;
	@Column(columnDefinition = "int  NOT NULL COMMENT '举报的用户'")
	private Integer userId;
	@Column(columnDefinition = "varchar(200) NOT NULL COMMENT '举报内容'")
	private String postreportContent;
	@Column(columnDefinition = "tinyint unsigned DEFAULT 0 COMMENT '举报信息审核状态' ")
	private Integer postreportStuts;
	@Column(columnDefinition = "datetime COMMENT '创建时间' ")
	private Date postreportCreatetime;
	@Column(columnDefinition = "timestamp COMMENT '最后一次修改时间'", nullable = false, updatable = false, insertable = false)
	private Timestamp postreportUpdateTime; 
	
	@Transient
	private String reportcountContent;
	
	@JsonIgnore
	@ManyToOne(targetEntity = Post.class)
	@JoinColumn(name="post_id")	//副表中的外键字段名称
	private Post post;
	
	@Transient
	private Integer postId;
	
}
