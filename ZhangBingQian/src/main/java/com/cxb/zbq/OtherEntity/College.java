package com.cxb.zbq.OtherEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 学院/院系/专业实体类
 * @author 王传威 
 *18/12/8 下午 15:35
 */


public class College implements Serializable {
	
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

	@Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + ", collegeParentId="
				+ collegeParentId + ", collegeRmark=" + collegeRmark + ", collegePath=" + collegePath
				+ ", collegeWeight=" + collegeWeight + ", collegeCreatTime=" + collegeCreatTime + ", collegeUpdateTime="
				+ collegeUpdateTime + ", collegeFounder=" + collegeFounder + ", collegeUpdateMan=" + collegeUpdateMan
				+ "]";
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

	public College(Integer collegeId, String collegeName, Integer collegeParentId, Integer collegeRmark,
			String collegePath, Integer collegeWeight, Date collegeCreatTime, Timestamp collegeUpdateTime,
			String collegeFounder, String collegeUpdateMan) {
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
	}

	public College() {
		super();
	}
	
	
}
