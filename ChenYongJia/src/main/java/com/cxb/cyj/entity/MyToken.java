package com.cxb.cyj.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	
	@Column(columnDefinition = "varchar(120) COMMENT 'token存储'  ")
	private String tokenAcc;
	
	@OneToOne(fetch = FetchType.EAGER)		// 默认值optional = true表示是否可以为空
	@JoinColumn(name="user_id",unique = true)	////副表中的外键字段名称 // unique=true确保了一对一关系	
	private User user;
	
}
