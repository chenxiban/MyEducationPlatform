package com.cxb.zbq.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="covermapTb")

public class CoverMap {
	@Id
	private String covermapId;//封面图id(王安岭返回过来的id,uuid)
	private String covermapUrl;//封面图路径
	@Column(columnDefinition="timestamp")
	private Timestamp lastUpdateTime;//最后一次修改时间
	private Integer curriculumId;//课程id
	public CoverMap(String covermapId, String covermapUrl, Integer curriculumId) {
		super();
		this.covermapId = covermapId;
		this.covermapUrl = covermapUrl;
		this.curriculumId = curriculumId;
	}
	public String getCovermapId() {
		return covermapId;
	}
	public void setCovermapId(String covermapId) {
		this.covermapId = covermapId;
	}
	public String getCovermapUrl() {
		return covermapUrl;
	}
	public void setCovermapUrl(String covermapUrl) {
		this.covermapUrl = covermapUrl;
	}
	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public Integer getCurriculumId() {
		return curriculumId;
	}
	public void setCurriculumId(Integer curriculumId) {
		this.curriculumId = curriculumId;
	}
	@Override
	public String toString() {
		return "CoverMap [covermapId=" + covermapId + ", covermapUrl=" + covermapUrl + ", lastUpdateTime="
				+ lastUpdateTime + ", curriculumId=" + curriculumId + "]";
	}
	public CoverMap() {
		super();
	}
	
	
	

}
