package com.cxb.cyj.entity;

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
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @Description:   用户实体类
 * @ClassName:     User.java
 * @author         ChenYongJia
 * @Date           2018年12月04日 下午20:40:56
 * @Email          867647213@qq.com
 */
@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor // 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Builder // 使用建造模型
@Entity
@Table(name = "tb_token")
public class MyToken implements Serializable {
	
	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	@Column(columnDefinition = "int unsigned  COMMENT 'token存储表id'")
	private Integer tokenId;
	
	@Column(columnDefinition = "int unsigned  COMMENT '用户id'")
	private Integer userId;
	
	@Column(columnDefinition = "varchar(120) COMMENT 'token存储'  ")
	private String tokenAcc;
	
	@Column(columnDefinition = "datetime COMMENT 'token存储创建时间' ")
	private Date tokenCreatTime;
	@Column(columnDefinition = "timestamp COMMENT 'token存储最后一次修改时间'", nullable = false, updatable = false, insertable = false)
	private Timestamp tokenUpdateTime;
	
}
