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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * 
 * @Description:   课程讨论分类表
 * @ClassName:     disbar.java
 * @author         刘森川
 */
@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor// 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Entity
@Table(name = "tb_disbar")
public class Disbar{

	/*disbar_id字段,int类型,主键自增,非空,备注:课程主键
	disbar_category字段,varchar(30)类型,非空,备注:课程讨论分类名字
	disbar_describe字段,varchar(30)类型,非空,备注:课程讨论分类描述
	disbar_createtime字段,datetime类型,非空,备注:评论时间
	disbar_updatetime字段,时间戳,非空,备注:修改时间*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	@Column(columnDefinition = "int unsigned NOT NULL  COMMENT '课程主键'")
	private Integer disbarId;
	@Column(columnDefinition = "varchar(30) NOT NULL COMMENT '课程讨论分类名字'  ")
	private  String disbarCategory;
	@Column(columnDefinition = "varchar(30) NOT NULL COMMENT '课程讨论分类描述'  ")
	private  String disbarDescribe;
	@Column(columnDefinition = "datetime COMMENT '评论时间' ")
	private Date disbarCreatetime;
	@Column(columnDefinition = "timestamp COMMENT '最后一次修改时间'", nullable = false, updatable = false, insertable = false)
	private Timestamp disbarUpdatetime;
	
	
	@OneToMany(mappedBy="disbar",fetch=FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
	private List<Dispost> list = new ArrayList<>();

}
