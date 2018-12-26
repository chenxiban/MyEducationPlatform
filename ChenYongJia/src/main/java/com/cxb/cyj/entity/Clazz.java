package com.cxb.cyj.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@JsonIgnore
	@ManyToOne(targetEntity = College.class)
	@JoinColumn(name="clazz_college_id")	//副表中的外键字段名称
	private College college;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER) // 指定多对多关系
	@Cascade(value = { CascadeType.ALL }) // 设置级联关系
	@JoinTable(name = "tb_userclazz", // 指定第三张中间表名称
			joinColumns = { @JoinColumn(name = "clazz_id") }, // 本表主键userId与第三张中间表user_role_tb的外键user_role_tb_user_id对应
			inverseJoinColumns = { @JoinColumn(name = "users_id") }) // 多对多关系另一张表与第三张中间表表的外键的对应关系
	@NotFound(action = NotFoundAction.IGNORE) // NotFound : 意思是找不到引用的外键数据时忽略，NotFound默认是exception
	private Set<User> userSet = new HashSet<User>();// 班级所拥有的老师用户
	
	@Transient
	private Integer collegeId;
	
	private int page = 0;
	private int rows = 10;

	@Transient
	private String collegeName;
	
	public String getCollegeName() {
		if(college != null) {
			System.out.println("贴吧分类的名称为");
			return college.getCollegeName();
		}else {
			return collegeName;
		}
		
	}
	
}
