package com.cxb.cyj.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Entity
@Table(name = "tb_coursetui")
public class CourseTui implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	@Column(columnDefinition = "int unsigned  COMMENT '推荐课程主键'")
	private Integer tuiId;
	@Column(columnDefinition = "int unsigned COMMENT '推荐课程id'")
	private Integer courseId;
	
	@Transient
	private int page=0;
	@Transient
	private int rows=10;
	@Transient
	private int p;
	@Transient
	private String token;
	
}

