package com.cxb.yyc.entity;

import java.io.Serializable;
import java.sql.Timestamp;



/**
 * 
 * @Description: 权限实体类
 * @author Chenyongjia
 * @Date 2018-11-13 下午5:42:22
 * @Email chen867647213@163.com
 * 
 */

public class Permission implements Serializable {

	private Integer permissionId;// 权限ID
	private String permissionValue;// 权限
	private String permissionModule;// 权限所属模块
	private String permissionName;// 权限备注说明介绍
	private Timestamp permissionLastUpdateTime;// 权限修改日期时间
	
	
	
	public Permission(String permissionValue, String permissionModule,
			String permissionName) {
		super();
		this.permissionValue = permissionValue;
		this.permissionModule = permissionModule;
		this.permissionName = permissionName;
	}

	public Permission() {
		super();
	}

	public Permission(Integer permissionId, String permissionValue, String permissionModule, String permissionName,
			Timestamp permissionLastUpdateTime) {
		super();
		this.permissionId = permissionId;
		this.permissionValue = permissionValue;
		this.permissionModule = permissionModule;
		this.permissionName = permissionName;
		this.permissionLastUpdateTime = permissionLastUpdateTime;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionValue() {
		return permissionValue;
	}

	public void setPermissionValue(String permissionValue) {
		this.permissionValue = permissionValue;
	}

	public String getPermissionModule() {
		return permissionModule;
	}

	public void setPermissionModule(String permissionModule) {
		this.permissionModule = permissionModule;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public Timestamp getPermissionLastUpdateTime() {
		return permissionLastUpdateTime;
	}

	public void setPermissionLastUpdateTime(Timestamp permissionLastUpdateTime) {
		this.permissionLastUpdateTime = permissionLastUpdateTime;
	}
	
	
	
}
