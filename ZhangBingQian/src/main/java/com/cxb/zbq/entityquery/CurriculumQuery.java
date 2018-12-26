package com.cxb.zbq.entityquery;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class CurriculumQuery {
	private String curriculumName;//课程名称
	private Integer curriculumCategoryId;//类别id
	private Integer whetherToIssue;//是否发布(0：未发布 1：已发布)
	private Integer teacherId;//老师id
	public String getCurriculumName() {
		return curriculumName;
	}
	public void setCurriculumName(String curriculumName) {
		this.curriculumName = curriculumName;
	}
	public Integer getCurriculumCategoryId() {
		return curriculumCategoryId;
	}
	public void setCurriculumCategoryId(Integer curriculumCategoryId) {
		this.curriculumCategoryId = curriculumCategoryId;
	}
	public Integer getWhetherToIssue() {
		return whetherToIssue;
	}
	public void setWhetherToIssue(Integer whetherToIssue) {
		this.whetherToIssue = whetherToIssue;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	@Override
	public String toString() {
		return "CurriculumQuery [curriculumName=" + curriculumName + ", curriculumCategoryId=" + curriculumCategoryId
				+ ", whetherToIssue=" + whetherToIssue + ", teacherId=" + teacherId + "]";
	}
	public CurriculumQuery(String curriculumName, Integer curriculumCategoryId, Integer whetherToIssue,
			Integer teacherId) {
		super();
		this.curriculumName = curriculumName;
		this.curriculumCategoryId = curriculumCategoryId;
		this.whetherToIssue = whetherToIssue;
		this.teacherId = teacherId;
	}
	public CurriculumQuery() {
		super();
	}
	

}
