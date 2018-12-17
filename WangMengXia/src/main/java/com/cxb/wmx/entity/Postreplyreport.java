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

import com.cxb.wmx.entity.Postcommit.PostcommitBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @Description:   帖子回复举报
 * @ClassName:     Postcommit.java
 * @author         王梦霞
 */

@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor // 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Builder // 使用建造模型
@Entity
@Table(name = "tb_postreplyreport")
public class Postreplyreport {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	@Column(columnDefinition = "int unsigned NOT NULL COMMENT '回复举报id'")
	private Integer postreplyreportId;
	@Column(columnDefinition = "int  NOT NULL COMMENT '举报人id'")
	private Integer userId;
	@Column(columnDefinition = "varchar(100) NOT NULL COMMENT '举报内容'  ")
	private String postreplyreportContent;
	@Column(columnDefinition = "tinyint unsigned DEFAULT 0 COMMENT '举报信息审核状态' ")
	private Integer postreplyreportStuts;
	@Column(columnDefinition = "datetime COMMENT '创建时间' ")
	private Date postreplyreportCreatetime;
	@Column(columnDefinition = "timestamp COMMENT '最后一次修改时间'", nullable = false, updatable = false, insertable = false)
	private Timestamp postreplyreportUpdateTime;
	
	
	@JsonIgnore
	@ManyToOne(targetEntity = Postreply.class)
	@JoinColumn(name="postreply_id")	//副表中的外键字段名称
	private Postreply postreply;
	
	
}
