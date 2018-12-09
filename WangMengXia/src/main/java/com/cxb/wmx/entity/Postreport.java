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
/**
 * postreport_id字段,int类型,主键自增,非空,备注:帖子举报主键
post_id字段,int类型,非空,外键,备注:帖子外键
user_id字段,int类型,非空,外键,备注:举报的用户id
postreport_content字段,varchar类型长度200,备注:举报内容
postreport_stuts字段,,tinyint(0否,1是),默认为0,备注:举报信息审核状态
postreport_createtime字段,datetime类型备注:发表时间
postreport_updatetime字段,时间戳,非空,备注:最后一次修改时间
 */
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
	
	@JsonIgnore
	@ManyToOne(targetEntity = Post.class)
	@JoinColumn(name="post_id")	//副表中的外键字段名称
	private Post post;
	
	
	
	/*@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)		// 默认值optional = true表示是否可以为空
	@JoinColumn(name="reportcount_id",unique = true)	////副表中的外键字段名称 // unique=true确保了一对一关系	
	private Reportcount reportcount;*/
}
