package com.cxb.cyj.entity;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 机构实体类
 * @author 王传威 时间18/12/8下午15:00
 *
 */
@Getter
@Setter
@AllArgsConstructor // 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Builder // 使用建造模型
@Entity
@Table(name = "tb_organization")
public class Organization implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy // 数据加载顺序
	@Column(columnDefinition = "int unsigned comment '机构ID'  ")
	private Integer organizationId;
	@Column(unique=true, columnDefinition = "varchar(60) comment '备注:机构名称'  ")
	private String organizationSchool;
	@Column(columnDefinition = "varchar(10) comment '备注:机构负责人'  ")
	private String organizationHead;//机构负责人
	@Column(columnDefinition = "varchar(11) comment '备注:机构联系方式'  ")
	private String organizationMtel;//机构联系方式
	@Column(columnDefinition = "varchar(140) comment '备注:机构地址'  ")
	private String organizationAddress;//地址
	@Column(columnDefinition = "varchar(1000) comment '备注:机构简介'  ")
	private String organizationAbstract;//简介
	@Column(columnDefinition = "datetime comment '备注:用户创建时间'  ")
	private Date organizationCreatTime;//创建时间
	@Column(columnDefinition = "TIMESTAMP comment '备注:最后一次操作时间'  ", nullable = false, updatable = false, insertable = false)
	private Timestamp organizationUpdateTime;//最后一次操作时间   
	
	@OneToMany(mappedBy="organization",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<College> list = new ArrayList<>();

}
