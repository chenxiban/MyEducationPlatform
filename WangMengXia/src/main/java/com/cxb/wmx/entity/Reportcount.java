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
 * @Description:   帖子内容举报实体类
 * @ClassName:     Reportcount.java
 * @author         王梦霞
 */

@Getter
@Setter
@AllArgsConstructor // 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Builder // 使用建造模型
@Entity
@Table(name = "tb_reportcount")
public class Reportcount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	@Column(columnDefinition = "int unsigned NOT NULL COMMENT '帖子举报内容主键'")
	private Integer reportcountId;
	@Column(columnDefinition = "varchar(200) NOT NULL COMMENT '管理员返还的举报内容'")
	private String reportcountContent;
	@Column(columnDefinition = "datetime COMMENT '创建时间' ")
	private Date reportcountCreatetime;
	@Column(columnDefinition = "timestamp COMMENT '最后一次修改时间'", nullable = false, updatable = false, insertable = false)
	private Timestamp reportcountUpdateTime; 
	
	@JsonIgnore
	@ManyToOne(targetEntity = Post.class)
	@JoinColumn(name="post_id")	//副表中的外键字段名称
	private Post post;
	
	@Column(columnDefinition = "int unsigned COMMENT '帖子举报用户id'")
	private Integer userId;
	
}
