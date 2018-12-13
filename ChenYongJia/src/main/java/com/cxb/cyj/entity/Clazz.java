package com.cxb.cyj.entity;

import java.io.Serializable;
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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 班级实体类
 * @author 王传威
 *时间18/12/8 下午15:50
 */
@Getter
@Setter
@AllArgsConstructor // 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Builder // 使用建造模型
@Entity
@Table(name = "tb_clazz")
public class Clazz implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy // 数据加载顺序
	@Column(columnDefinition = "int unsigned comment '班级ID'  ")
	private Integer classId;
	@Column(columnDefinition = "int unsigned comment '班级编号'  ")
	private Integer classNumber;
	@Column(unique=true, columnDefinition = "varchar(20) comment '备注:班级名称'  ")
	private String className;
	@Column(columnDefinition = "datetime comment '备注:创建时间'  ")
	private Date classCreatTime;
	@Column(columnDefinition = "TIMESTAMP comment '备注:最后一次修改时间'  ", nullable = false, updatable = false, insertable = false)
	private Timestamp classUpdateTime;
	
	@ManyToOne(targetEntity = Organization.class)
	@JoinColumn(name="clazz_college_id")	//副表中的外键字段名称
	private College college;
	
	

}
