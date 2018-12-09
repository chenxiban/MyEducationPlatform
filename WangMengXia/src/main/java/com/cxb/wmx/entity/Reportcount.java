package com.cxb.wmx.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
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
 * @Description:   帖子内容举报实体类
 * @ClassName:     Reportcount.java
 * @author         王梦霞
 */

@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor // 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Builder // 使用建造模型
@Entity
@Table(name = "tb_reportcount")
public class Reportcount {

	/**
	 * reportcount_id字段,int类型,主键自增,非空,备注:帖子内容举报主键
postreport_id字段,int类型,,备注:帖子举报外键
reportcount_content字段,varchar类型长度200,备注:管理员返还的举报内容
reportcount_createtime字段,datetime类型,非空,备注:发表时间
reportcount_updatetime字段,时间戳,非空,备注:最后一次修改时间
	 */
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
	
	/*@JsonIgnore
	@OneToOne(optional = false, mappedBy = "reportcount", cascade = CascadeType.ALL, fetch = FetchType.EAGER)	//不建外键		//optional是否可以为空
	@JoinColumn(name="postreport_id",unique = true)	////副表中的外键字段名称 // unique=true确保了一对一关系	
	private Postreport postreport;*/
	
}
