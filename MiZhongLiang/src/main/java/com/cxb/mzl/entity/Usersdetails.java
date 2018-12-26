package com.cxb.mzl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName: usersdetails
 * @Description: 用户详情实体类
 * @Author 谢立博
 * @DateTime 2018年12月19日 下午3:11:25 
 */
@Entity
@Table(name="usersdetailstb")
public class Usersdetails {
	@Id//实体类的主键
	/*@GeneratedValue//自动增长列
*/	@Column(columnDefinition ="int unsigned COMMENT '用户id'")
	private Integer usersId;
	@Column(columnDefinition = "varchar(50) NOT NULL COMMENT '头像路径'  ")
	private String usersUrl;
	@Column(columnDefinition = "varchar(20) NOT NULL COMMENT '用户昵称'  ")
	private String usersNickname;
	@Column(columnDefinition = "varchar(50) NOT NULL COMMENT '邮箱'  ")
	private String usersEmail;
	@Column(columnDefinition = "varchar(11) COMMENT '手机号'  ")
	private String usersTelephone;
	@Column(columnDefinition = "varchar(8) COMMENT '用户真实姓名'  ")
	private String usersName;
	@Column(columnDefinition= "char(1) comment '备注:用户性别' ",nullable=false)
	private String usersSex;	//不允许为空
	@Column(columnDefinition = "varchar(20) COMMENT '生日'  ")
	private Date usersBirthday;
	@Column(columnDefinition = "varchar(18) COMMENT '身份证'  ")
	private String usersIdcard;
	@Column(columnDefinition = "varchar(4) NOT NULL COMMENT '身份类型:1为学生；0为老师'  ")
	private String usersIdentitytype;
	@Column(columnDefinition = "varchar(20) NOT NULL COMMENT '院系'  ")
	private String usersDepartmentsmajor;
	@Column(columnDefinition = "varchar(20) COMMENT '最高学历'  ")
	private String usersDiploma;
	@Column(columnDefinition = "varchar(200) COMMENT '个人简介'  ")
	private String usersProfile;
	@Column(columnDefinition = "varchar(20) COMMENT '预留字段1'  ")
	private String usersExt1;
	@Column(columnDefinition="int unsigned COMMENT '预留字段2' ")
	private Integer usersExt2;
	public Integer getUsersId() {
		return usersId;
	}
	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}
	public String getUsersUrl() {
		return usersUrl;
	}
	public void setUsersUrl(String usersUrl) {
		this.usersUrl = usersUrl;
	}
	public String getUsersNickname() {
		return usersNickname;
	}
	public void setUsersNickname(String usersNickname) {
		this.usersNickname = usersNickname;
	}
	public String getUsersEmail() {
		return usersEmail;
	}
	public void setUsersEmail(String usersEmail) {
		this.usersEmail = usersEmail;
	}
	public String getUsersTelephone() {
		return usersTelephone;
	}
	public void setUsersTelephone(String usersTelephone) {
		this.usersTelephone = usersTelephone;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public String getUsersSex() {
		return usersSex;
	}
	public void setUsersSex(String usersSex) {
		this.usersSex = usersSex;
	}
	public Date getUsersBirthday() {
		return usersBirthday;
	}
	public void setUsersBirthday(Date usersBirthday) {
		this.usersBirthday = usersBirthday;
	}
	public String getUsersIdcard() {
		return usersIdcard;
	}
	public void setUsersIdcard(String usersIdcard) {
		this.usersIdcard = usersIdcard;
	}
	public String getUsersDepartmentsmajor() {
		return usersDepartmentsmajor;
	}
	public void setUsersDepartmentsmajor(String usersDepartmentsmajor) {
		this.usersDepartmentsmajor = usersDepartmentsmajor;
	}
	public String getUsersDiploma() {
		return usersDiploma;
	}
	public void setUsersDiploma(String usersDiploma) {
		this.usersDiploma = usersDiploma;
	}
	public String getUsersProfile() {
		return usersProfile;
	}
	public void setUsersProfile(String usersProfile) {
		this.usersProfile = usersProfile;
	}
	public String getUsersExt1() {
		return usersExt1;
	}
	public void setUsersExt1(String usersExt1) {
		this.usersExt1 = usersExt1;
	}
	public Integer getUsersExt2() {
		return usersExt2;
	}
	public void setUsersExt2(Integer usersExt2) {
		this.usersExt2 = usersExt2;
	}
	@Override
	public String toString() {
		return "usersdetails [usersId=" + usersId + ", usersUrl=" + usersUrl + ", usersNickname=" + usersNickname
				+ ", usersEmail=" + usersEmail + ", usersTelephone=" + usersTelephone + ", usersName=" + usersName
				+ ", usersSex=" + usersSex + ", usersBirthday=" + usersBirthday + ", usersIdcard=" + usersIdcard
				+ ", usersDepartmentsmajor=" + usersDepartmentsmajor + ", usersDiploma=" + usersDiploma
				+ ", usersProfile=" + usersProfile + ", usersExt1=" + usersExt1 + ", usersExt2=" + usersExt2 + "]";
	}
	

}