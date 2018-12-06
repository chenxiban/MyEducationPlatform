package com.cxb.cyj.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "tb_user")
public class User implements UserDetails,Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	@Column(columnDefinition = "int unsigned  COMMENT '用户id'")
	private Integer usersId;
	@Column(columnDefinition = "int unsigned NOT NULL COMMENT '由 Java 代码生成的用户流水号'")
	private Integer usersStuNo;
	@Column(columnDefinition = "varchar(20) NOT NULL COMMENT '用户名称'  ")
	private String usersName;
	@Column(columnDefinition = "varchar(11) COMMENT '密保手机号'  ")
	private String usersProtectMTel;
	@Column(columnDefinition = "varchar(50) COMMENT '密保邮箱'  ")
	private String usersProtectEMail;
	@Column(columnDefinition = "varchar(120) COMMENT '用户登陆密码'  ")
	private String usersPassword;
	@Column(columnDefinition = "char(1) DEFAULT '否'  COMMENT '是否锁定'")
	private String usersIsLookout;
	@Column(columnDefinition = "tinyint unsigned DEFAULT 0 COMMENT '密码错误次数'")
	private Integer usersPsdWrongTime;
	@Column(columnDefinition = "datetime COMMENT '用户锁定时间' ")
	private Date usersLockTime;
	@Column(columnDefinition = "datetime COMMENT '用户最后一次登录时间' ")
	private Date usersLastLoginTime;
	@Column(columnDefinition = "datetime COMMENT '创建时间' ")
	private Date usersCreatTime;
	@Column(columnDefinition = "timestamp COMMENT '最后一次修改时间'", nullable = false, updatable = false, insertable = false)
	private Timestamp usersUpdateTime;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER) // 指定多对多关系
	@Cascade(value = { CascadeType.ALL }) // 设置级联关系
	@JoinTable(name = "tb_userroles", // 指定第三张中间表名称
			joinColumns = { @JoinColumn(name = "users_id") }, // 本表主键userId与第三张中间表user_role_tb的外键user_role_tb_user_id对应
			inverseJoinColumns = { @JoinColumn(name = "roles_id") }) // 多对多关系另一张表与第三张中间表表的外键的对应关系
	@NotFound(action = NotFoundAction.IGNORE) // NotFound : 意思是找不到引用的外键数据时忽略，NotFound默认是exception
	private Set<Roles> rolesSet = new HashSet<Roles>();// 用户所拥有的角色集合
	
	@Transient
	private String Pass;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<>();
		Set<Roles> roles = this.getRolesSet();
		for (Roles role : roles) {
			auths.add(new SimpleGrantedAuthority(role.getRolesName()));
		}
		return auths;
	}

	@Override
	public String getPassword() {
		return this.usersPassword;
	}

	@Override
	public String getUsername() {
		return this.usersName;
	}

	/**
	 * 账户是否未过期
	 * 指示用户的帐户是否已过期。过期的帐户无法验证。
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * 账户是否未锁定
	 * 指示用户是否锁定或解锁。无法对锁定用户进行身份验证。
	 */
	@Override
	public boolean isAccountNonLocked() {
		/*if (this.getUsersIsLookout().equals("是")) {
			return false;
		} else {
			return true;
		}*/
		return true;
	}

	/**
	 * 指示用户的凭据(密码)是否已过期。过期凭据阻止身份验证。
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * 指示用户是否启用或禁用。无法对禁用用户进行身份验证。
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}