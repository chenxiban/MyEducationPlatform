package com.cxb.cyj.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 学院/院系/专业实体类
 * @author 王传威 
 *18/12/8 下午 15:35
 */
@Getter
@Setter
@AllArgsConstructor // 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Builder // 使用建造模型
@Entity
@Table(name = "tb_college")
public class College implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy // 数据加载顺序
	@Column(columnDefinition = "int unsigned comment '学院/院系/专业ID'  ")
	private Integer collegeId;
	@Column(unique=true, columnDefinition = "varchar(60) comment '备注:学院/院系/专业名称'  ")
	private String collegeName;
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注:父模块编号'  ")
	private Integer collegeParentId;
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注:标注是 学院/系别/专业分别用0，1，2代表'  ")
	@JsonProperty(value = "text")
	private Integer collegeRmark;
	@Column(columnDefinition = "varchar(120) comment '备注:路径'  ")
	private String collegePath;
	@Column(columnDefinition = "int unsigned comment '备注:权重'  ")
	private Integer collegeWeight;
	@Column(columnDefinition = "datetime comment '备注:创建时间'  ")
	private Date collegeCreatTime;
	@Column(columnDefinition = "TIMESTAMP comment '备注:最后一次修改时间'  ", nullable = false, updatable = false, insertable = false)
	private Timestamp collegeUpdateTime;
	@Column(columnDefinition = "varchar(50) comment '备注:创建人'  ")
	private String collegeFounder;
	@Column(columnDefinition = "varchar(50) comment '备注:修改人'  ")
	private String collegeUpdateMan;
	
	@ManyToOne(targetEntity = Organization.class)
	@JoinColumn(name="college_organization_id")	//副表中的外键字段名称
	private Organization organization;
	
	@OneToMany(mappedBy="college",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Clazz> list = new ArrayList<>();
	
	@Transient
	private boolean checked;
	@Transient
	private Map<String, Object> attributes;

	@JsonInclude(Include.NON_NULL)
	// 如果该属性为null则不参与序列化
	@Transient
	private List<College> children;

	public Map<String, Object> getAttributes() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("url", this.collegePath);
		return map;
	}
	
}
