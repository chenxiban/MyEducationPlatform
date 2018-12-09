package com.cxb.wmx.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @Description:   用户实体类
 * @ClassName:     Users.java
 * @author         王梦霞
 */
@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor // 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Builder // 使用建造模型
@Entity
@Table(name = "tb_users")
public class Users implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	@Column(columnDefinition = "int unsigned NOT NULL  COMMENT '用户id'")
	private Integer userId;
	@Column(columnDefinition = "varchar(50) NOT NULL COMMENT '用户姓名'  ")
	private  String userName;
	@Column(columnDefinition = "varchar(50) NOT NULL COMMENT '用户密码'  ")
	private  String userPwd;
	@Column(columnDefinition = "varchar(200)  NULL COMMENT '用户头像路经'  ")
	private String userTouurl;
	@Column(columnDefinition = "datetime COMMENT '创建时间' ")
	private Date userCreatetime;
	@Column(columnDefinition = "timestamp COMMENT '最后一次修改时间'", nullable = false, updatable = false, insertable = false)
	private Timestamp userUpdateTime;
	
	
}
