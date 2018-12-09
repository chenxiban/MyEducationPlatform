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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 
 * @Description:   课程讨论
 * @ClassName:     dispost.java
 * @author         刘森川
 */
@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor// 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Builder // 使用建造模型
@Entity
@Table(name = "tb_dispost")
public class Dispost {


	/**
	 * dispost_id字段,int类型,非空,自增,主键,备注:课程帖子主键
disbar_id字段, int类型,外键,备注:课程分类外键
user_id字段,int类型,非空,备注:发帖人id需要个人中心提供数据
dispost_name字段,varchar(30)类型,非空,备注:发帖人姓名
chapter_id字段,int类型,非空,备注:章节id需老师和学生提供数据
dispost_title字段,varchar(100)类型,非空,备注:课程帖子标题
dispost_count字段,varchar类型,非空,备注:课程帖子内容
fightouts字段,int类型(默认为0),备注:投票数
dispost_report字段,tinyint(0否,1是),备注:是否举报成功
dispost_like字段,tinyint(0否,1是,2反对),备注:是否点赞
dispost_createtime字段,datetime类型,非空,备注:创建时间
dispost_updatetime字段,时间戳,非空,备注:修改时间
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	@Column(columnDefinition = "int unsigned NOT NULL  COMMENT '课程帖子主键'")
	private Integer dispostId;
	@Column(columnDefinition = "int  NOT NULL COMMENT '发帖人id需要个人中心提供数据'")
	private Integer userId;
	@Column(columnDefinition = "int  NOT NULL COMMENT '章节id需老师和学生提供数据'")
	private Integer dispostchaId;
	@Column(columnDefinition = "varchar(30) NOT NULL COMMENT '发帖人姓名'  ")
	private  String dispostName;
	@Column(columnDefinition = "varchar(100) NOT NULL COMMENT '课程帖子标题'  ")
	private  String dispostTitle;
	@Column(columnDefinition = "varchar(2000) NOT NULL COMMENT '课程帖子内容'  ")
	private  String dispostCount;
	@Column(columnDefinition = "int  NOT NULL COMMENT '投票数'")
	private Integer dispostFightouts;
	@Column(columnDefinition = "tinyint unsigned DEFAULT 0 COMMENT '是否举报成功'  ")
	private Integer dispostReport;
	@Column(columnDefinition = "datetime COMMENT '评论时间' ")
	private Date dispostCreatetime;
	@Column(columnDefinition = "timestamp COMMENT '最后一次修改时间'", nullable = false, updatable = false, insertable = false)
	private Timestamp dispostUpdatetime;
	
	
	@JsonIgnore
	@ManyToOne(targetEntity = Disbar.class)
	@JoinColumn(name="disbar_id")	//副表中的外键字段名称
	private Disbar disbar;
	
	@OneToMany(mappedBy="dispost",fetch=FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
	private List<Discommit> list = new ArrayList<>();
	
	@OneToMany(mappedBy="dispost",fetch=FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
	private List<Disreport> list1 = new ArrayList<>();
	
	@OneToMany(mappedBy="dispost",fetch=FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
	private List<Dislike> list2 = new ArrayList<>();
	
	
}
