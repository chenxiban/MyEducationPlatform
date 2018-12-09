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

import com.cxb.wmx.entity.Postcommit.PostcommitBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @Description:   帖子评论举报表
 * @ClassName:     Commitreport.java
 * @author         王梦霞
 */

@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor // 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Builder // 使用建造模型
@Entity
@Table(name = "tb_commitreport")
public class Commitreport {

	/**
	 * commitreport_id字段,int类型,主键自增,非空,备注:评论举报主键
postcommit_id字段,int类型,非空,外键,备注:评论外键
user_id字段,int类型,非空,外键,备注:举报的用户id
commitreport_content字段,varchar类型长度200,备注:举报内容
commitreport_stuts字段,,tinyint(0否,1是),非空,默认为0,备注:举报信息审核状态
postcommit_createtime字段,datetime类型,非空,备注:发表时间
postcommit_updatetime字段,时间戳,非空,备注:最后一次修改时间
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	@Column(columnDefinition = "int unsigned NOT NULL COMMENT '评论举报id'")
	private Integer commitreportId;
	@Column(columnDefinition = "int  NOT NULL COMMENT '评论举报人id'")
	private Integer userId;
	@Column(columnDefinition = "varchar(100) NOT NULL COMMENT '评论举报内容'  ")
	private String commitreportContent;
	@Column(columnDefinition = "tinyint unsigned DEFAULT 0 COMMENT '举报信息审核状态' ")
	private Integer commitreportStuts;
	@Column(columnDefinition = "datetime COMMENT '创建时间' ")
	private Date commitreportCreatetime;
	@Column(columnDefinition = "timestamp COMMENT '最后一次修改时间'", nullable = false, updatable = false, insertable = false)
	private Timestamp commitreportUpdateTime; 
	
	@JsonIgnore
	@ManyToOne(targetEntity = Postcommit.class)
	@JoinColumn(name="postcommit_id")	//副表中的外键字段名称
	private Postcommit postcommit;
	
	
}
