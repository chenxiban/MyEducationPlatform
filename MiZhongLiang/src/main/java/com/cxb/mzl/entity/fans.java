package com.cxb.mzl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @ClassName: fans
 * @Description: 粉丝实体类
 * @Author 谢立博
 * @DateTime 2018年12月19日 下午3:09:53 
 */
@Entity
@Table(name="fanstb")
public class fans {

	@Id//实体类的主键
	@GeneratedValue//自动增长列
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:粉丝自动增长主键'  ")
	private Integer fansId;
	@Column(columnDefinition="int unsigned NOT NULL ")
	private Integer fansUsersId;
	@Column(columnDefinition="int unsigned NOT NULL ")
	private Integer fansUsersIds;
	public Integer getFansId() {
		return fansId;
	}
	public void setFansId(Integer fansId) {
		this.fansId = fansId;
	}
	public Integer getFansUsersId() {
		return fansUsersId;
	}
	public void setFansUsersId(Integer fansUsersId) {
		this.fansUsersId = fansUsersId;
	}
	public Integer getFansUsersIds() {
		return fansUsersIds;
	}
	public void setFansUsersIds(Integer fansUsersIds) {
		this.fansUsersIds = fansUsersIds;
	}
	@Override
	public String toString() {
		return "fans [fansId=" + fansId + ", fansUsersId=" + fansUsersId + ", fansUsersIds=" + fansUsersIds + "]";
	}
	
	

}
