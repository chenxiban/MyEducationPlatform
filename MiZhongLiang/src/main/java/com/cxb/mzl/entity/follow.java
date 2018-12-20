package com.cxb.mzl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName: follow
 * @Description: 关注实体类
 * @Author 谢立博
 * @DateTime 2018年12月19日 下午3:10:29 
 */
@Entity
@Table(name="followtb")
public class follow {
	@Id//实体类的主键
	@GeneratedValue//自动增长列
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:关注自动增长主键'  ")
	private Integer followId;
	@Column(columnDefinition="int unsigned NOT NULL ")
	private Integer followUsersId;
	@Column(columnDefinition="int unsigned NOT NULL ")
	private Integer followUsersIds;
	public Integer getFollowId() {
		return followId;
	}
	public void setFollowId(Integer followId) {
		this.followId = followId;
	}
	public Integer getFollowUsersId() {
		return followUsersId;
	}
	public void setFollowUsersId(Integer followUsersId) {
		this.followUsersId = followUsersId;
	}
	public Integer getFollowUsersIds() {
		return followUsersIds;
	}
	public void setFollowUsersIds(Integer followUsersIds) {
		this.followUsersIds = followUsersIds;
	}
	@Override
	public String toString() {
		return "follow [followId=" + followId + ", followUsersId=" + followUsersId + ", followUsersIds="
				+ followUsersIds + "]";
	}
	
	

}
