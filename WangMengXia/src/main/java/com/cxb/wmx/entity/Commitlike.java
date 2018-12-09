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
 * @Description:   帖子评论点赞表
 * @ClassName:     Commitlike.java
 * @author         王梦霞
 */

@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor // 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Builder // 使用建造模型
@Entity
@Table(name = "tb_commitlike")
public class Commitlike {
	/**
	 * commitlike_id字段,int类型,主键自增,非空,备注:帖子评论点赞主键
postcommit_id字段,int类型,非空,外键,备注:帖子评论外键
commitlike_stuts字段,tinyint(0否,1是),默认为0,备注:状态
user_id字段,int类型,非空,备注:点/反的用户的id
commitlike_createtime字段,datetime类型,备注:创建时间
commitlike_updatetime字段,时间戳,备注:最后一次修改时间
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	@Column(columnDefinition = "int unsigned NOT NULL COMMENT '帖子评论点赞id'")
	private Integer commitlikeId;
	@Column(columnDefinition = "int  NOT NULL COMMENT '帖子评论点赞id'")
	private Integer userId;
	@Column(columnDefinition = "tinyint unsigned DEFAULT 0 COMMENT '帖子评论点赞状态' ")
	private Integer commitlikeStuts;
	@Column(columnDefinition = "datetime COMMENT '创建时间' ")
	private Date commitlikeCreatetime;
	@Column(columnDefinition = "timestamp COMMENT '最后一次修改时间'", nullable = false, updatable = false, insertable = false)
	private Timestamp commitlikeUpdateTime;
	
	@JsonIgnore
	@ManyToOne(targetEntity = Postcommit.class)
	@JoinColumn(name="postcommit_id")	//副表中的外键字段名称
	private Postcommit postcommit;
	
	
	
}
