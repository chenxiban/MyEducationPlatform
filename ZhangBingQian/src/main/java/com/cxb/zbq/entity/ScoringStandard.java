package com.cxb.zbq.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="scoringStandardTb")

public class ScoringStandard {//评分标准表
	@Id
	@GeneratedValue
	private Integer scoringStandardId;//评分表id
	private Integer curriculumId;//课程id
	private Integer proportion;//章节所占比重(一门课程比重总和必须为100,考试比重就是100-proportion)
	private Integer updateCount=0;//修改次数,默认为0
	@Transient
	private Integer exam;//考试所占比重
	@Transient
	private String curriculumName;//临时参数
	public Integer getScoringStandardId() {
		return scoringStandardId;
	}
	public void setScoringStandardId(Integer scoringStandardId) {
		this.scoringStandardId = scoringStandardId;
	}
	public Integer getCurriculumId() {
		return curriculumId;
	}
	public void setCurriculumId(Integer curriculumId) {
		this.curriculumId = curriculumId;
	}
	public Integer getProportion() {
		return proportion;
	}
	public void setProportion(Integer proportion) {
		this.proportion = proportion;
	}
	public Integer getUpdateCount() {
		return updateCount;
	}
	public void setUpdateCount(Integer updateCount) {
		this.updateCount = updateCount;
	}
	public Integer getExam() {
		return exam;
	}
	public void setExam(Integer exam) {
		this.exam = exam;
	}
	public String getCurriculumName() {
		return curriculumName;
	}
	public void setCurriculumName(String curriculumName) {
		this.curriculumName = curriculumName;
	}
	@Override
	public String toString() {
		return "ScoringStandard [scoringStandardId=" + scoringStandardId + ", curriculumId=" + curriculumId
				+ ", proportion=" + proportion + ", updateCount=" + updateCount + ", exam=" + exam + ", curriculumName="
				+ curriculumName + "]";
	}
	public ScoringStandard(Integer scoringStandardId, Integer curriculumId, Integer proportion, Integer updateCount,
			Integer exam, String curriculumName) {
		super();
		this.scoringStandardId = scoringStandardId;
		this.curriculumId = curriculumId;
		this.proportion = proportion;
		this.updateCount = updateCount;
		this.exam = exam;
		this.curriculumName = curriculumName;
	}
	public ScoringStandard() {
		super();
	}
	

}
