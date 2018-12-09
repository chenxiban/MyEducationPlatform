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

import com.cxb.wmx.entity.Post.PostBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @Description:   评论
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
@Table(name = "tb_postcommit")
public class Postcommit {

	/**
	 * postcommit_id字段,int类型,主键,自增,非空,备注:帖子评论主键
post_id字段,int类型,非空,外键,备注:帖子外键
user_id字段,int类型,非空,备注:评论人id,需个人中心提供数据
user_touurl字段,varchar(100)类型,备注:用户头像路经
postcommit_字段,varchar(20)类型,非空,备注:评论人昵称
postcommit_count字段,varchar类型,非空,备注:评论内容
postcommit_report字段,,tinyint(0否,1是),备注:是否举报成功
postcommit_createtime字段,datetime类型,非空,备注:评论时间
postcommit_updatetime字段,时间戳,非空,备注:修改时间
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	@Column(columnDefinition = "int unsigned NOT NULL COMMENT '帖子评论id'")
	private Integer postcommitId;
	@Column(columnDefinition = "int  NOT NULL COMMENT '评论人id'")
	private Integer userId;
	@Column(columnDefinition = "varchar(200)  NULL COMMENT '用户头像路经'  ")
	private String userTouurl;
	@Column(columnDefinition = "varchar(50) NOT NULL COMMENT '评论人昵称'  ")
	private String postcommitName;
	@Column(columnDefinition = "varchar(500) NOT NULL COMMENT '评论内容'  ")
	private String postcommitCount;
	@Column(columnDefinition = "tinyint unsigned DEFAULT 0 COMMENT '是否举报成功' ")
	private Integer postcommitReport;
	@Column(columnDefinition = "datetime COMMENT '创建时间' ")
	private Date postcommitCreatetime;
	@Column(columnDefinition = "timestamp COMMENT '最后一次修改时间'", nullable = false, updatable = false, insertable = false)
	private Timestamp postcommitUpdateTime; 
	
	@JsonIgnore
	@ManyToOne(targetEntity = Post.class)
	@JoinColumn(name="post_id")	//副表中的外键字段名称
	private Post post;
	
	@OneToMany(mappedBy="postcommit",fetch=FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
	private List<Commitreport> list1 = new ArrayList<>();
	
	@OneToMany(mappedBy="postcommit",fetch=FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
	private List<Commitlike> list2 = new ArrayList<>();
	
	@OneToMany(mappedBy="postcommit",fetch=FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
	private List<Postreply> list3 = new ArrayList<>();
	
}
