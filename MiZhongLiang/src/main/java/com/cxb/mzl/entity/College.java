package com.cxb.mzl.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
*@author 作者 E-mail 谢立博 13837051752@163.com
*@version 创建时间:2018年12月20日下午9:24:02
*类说明  院系实体类
*/
public class College {
	
	private Integer collegeId;
	private String collegeName;
	private Integer collegeParentId;
	private Integer collegeRmark;
	private String collegePath;
	private Integer collegeWeight;
	private Date collegeCreatTime;
	private Timestamp collegeUpdateTime;
	private String collegeFounder;
	private String collegeUpdateMan;
	private boolean checked;
	private Map<String, Object> attributes;
	private List<College> children;
	public College(Integer collegeId, String collegeName, Integer collegeParentId, Integer collegeRmark,
			String collegePath, Integer collegeWeight, Date collegeCreatTime, Timestamp collegeUpdateTime,
			String collegeFounder, String collegeUpdateMan, boolean checked, Map<String, Object> attributes,
			List<College> children) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.collegeParentId = collegeParentId;
		this.collegeRmark = collegeRmark;
		this.collegePath = collegePath;
		this.collegeWeight = collegeWeight;
		this.collegeCreatTime = collegeCreatTime;
		this.collegeUpdateTime = collegeUpdateTime;
		this.collegeFounder = collegeFounder;
		this.collegeUpdateMan = collegeUpdateMan;
		this.checked = checked;
		this.attributes = attributes;
		this.children = children;
	}
	public College() {
		super();
	}
	public Integer getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public Integer getCollegeParentId() {
		return collegeParentId;
	}
	public void setCollegeParentId(Integer collegeParentId) {
		this.collegeParentId = collegeParentId;
	}
	public Integer getCollegeRmark() {
		return collegeRmark;
	}
	public void setCollegeRmark(Integer collegeRmark) {
		this.collegeRmark = collegeRmark;
	}
	public String getCollegePath() {
		return collegePath;
	}
	public void setCollegePath(String collegePath) {
		this.collegePath = collegePath;
	}
	public Integer getCollegeWeight() {
		return collegeWeight;
	}
	public void setCollegeWeight(Integer collegeWeight) {
		this.collegeWeight = collegeWeight;
	}
	public Date getCollegeCreatTime() {
		return collegeCreatTime;
	}
	public void setCollegeCreatTime(Date collegeCreatTime) {
		this.collegeCreatTime = collegeCreatTime;
	}
	public Timestamp getCollegeUpdateTime() {
		return collegeUpdateTime;
	}
	public void setCollegeUpdateTime(Timestamp collegeUpdateTime) {
		this.collegeUpdateTime = collegeUpdateTime;
	}
	public String getCollegeFounder() {
		return collegeFounder;
	}
	public void setCollegeFounder(String collegeFounder) {
		this.collegeFounder = collegeFounder;
	}
	public String getCollegeUpdateMan() {
		return collegeUpdateMan;
	}
	public void setCollegeUpdateMan(String collegeUpdateMan) {
		this.collegeUpdateMan = collegeUpdateMan;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	public List<College> getChildren() {
		return children;
	}
	public void setChildren(List<College> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + ", collegeParentId="
				+ collegeParentId + ", collegeRmark=" + collegeRmark + ", collegePath=" + collegePath
				+ ", collegeWeight=" + collegeWeight + ", collegeCreatTime=" + collegeCreatTime + ", collegeUpdateTime="
				+ collegeUpdateTime + ", collegeFounder=" + collegeFounder + ", collegeUpdateMan=" + collegeUpdateMan
				+ ", checked=" + checked + ", attributes=" + attributes + ", children=" + children + "]";
	}
	
}
