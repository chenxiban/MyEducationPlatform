package com.cxb.mzl.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
*@author 作者 E-mail 谢立博 13837051752@163.com
*@version 创建时间:2018年12月20日下午5:54:28
*类说明   用户实体类
*/

public class User {
	private Integer userId;
	private Integer userStuNo;
	private String userName;
	private String userProtectMTel;
	private String userProtectEMail;
	private String userPassword;
	private String userIsLookout;
	private Integer userPsdWrongTime;
	private Date userLockTime;
	private Date userLastLoginTime;
	private Date userCreatTime;
	private Timestamp userUpdateTime;
	private String Pass;
	private String backUrl;
	public User(Integer userId, Integer userStuNo, String userName, String userProtectMTel, String userProtectEMail,
			String userPassword, String userIsLookout, Integer userPsdWrongTime, Date userLockTime,
			Date userLastLoginTime, Date userCreatTime, Timestamp userUpdateTime, String pass, String backUrl) {
		super();
		this.userId = userId;
		this.userStuNo = userStuNo;
		this.userName = userName;
		this.userProtectMTel = userProtectMTel;
		this.userProtectEMail = userProtectEMail;
		this.userPassword = userPassword;
		this.userIsLookout = userIsLookout;
		this.userPsdWrongTime = userPsdWrongTime;
		this.userLockTime = userLockTime;
		this.userLastLoginTime = userLastLoginTime;
		this.userCreatTime = userCreatTime;
		this.userUpdateTime = userUpdateTime;
		Pass = pass;
		this.backUrl = backUrl;
	}
	public User() {
		super();
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getUserStuNo() {
		return userStuNo;
	}
	public void setUserStuNo(Integer userStuNo) {
		this.userStuNo = userStuNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserProtectMTel() {
		return userProtectMTel;
	}
	public void setUserProtectMTel(String userProtectMTel) {
		this.userProtectMTel = userProtectMTel;
	}
	public String getUserProtectEMail() {
		return userProtectEMail;
	}
	public void setUserProtectEMail(String userProtectEMail) {
		this.userProtectEMail = userProtectEMail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserIsLookout() {
		return userIsLookout;
	}
	public void setUserIsLookout(String userIsLookout) {
		this.userIsLookout = userIsLookout;
	}
	public Integer getUserPsdWrongTime() {
		return userPsdWrongTime;
	}
	public void setUserPsdWrongTime(Integer userPsdWrongTime) {
		this.userPsdWrongTime = userPsdWrongTime;
	}
	public Date getUserLockTime() {
		return userLockTime;
	}
	public void setUserLockTime(Date userLockTime) {
		this.userLockTime = userLockTime;
	}
	public Date getUserLastLoginTime() {
		return userLastLoginTime;
	}
	public void setUserLastLoginTime(Date userLastLoginTime) {
		this.userLastLoginTime = userLastLoginTime;
	}
	public Date getUserCreatTime() {
		return userCreatTime;
	}
	public void setUserCreatTime(Date userCreatTime) {
		this.userCreatTime = userCreatTime;
	}
	public Timestamp getUserUpdateTime() {
		return userUpdateTime;
	}
	public void setUserUpdateTime(Timestamp userUpdateTime) {
		this.userUpdateTime = userUpdateTime;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	public String getBackUrl() {
		return backUrl;
	}
	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userStuNo=" + userStuNo + ", userName=" + userName + ", userProtectMTel="
				+ userProtectMTel + ", userProtectEMail=" + userProtectEMail + ", userPassword=" + userPassword
				+ ", userIsLookout=" + userIsLookout + ", userPsdWrongTime=" + userPsdWrongTime + ", userLockTime="
				+ userLockTime + ", userLastLoginTime=" + userLastLoginTime + ", userCreatTime=" + userCreatTime
				+ ", userUpdateTime=" + userUpdateTime + ", Pass=" + Pass + ", backUrl=" + backUrl + "]";
	}
	
}
