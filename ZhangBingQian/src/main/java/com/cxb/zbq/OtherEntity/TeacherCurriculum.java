package com.cxb.zbq.OtherEntity;



import java.util.List;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class TeacherCurriculum {
	@JsonProperty("value")
	private Integer curriculumId;//课程id
	@JsonProperty("label")
	private String curriculumName;//课程名称
	@JsonProperty("children")
	List<CurriculumChapter> children;
	public Integer getCurriculumId() {
		return curriculumId;
	}
	public void setCurriculumId(Integer curriculumId) {
		this.curriculumId = curriculumId;
	}
	public String getCurriculumName() {
		return curriculumName;
	}
	public void setCurriculumName(String curriculumName) {
		this.curriculumName = curriculumName;
	}
	public List<CurriculumChapter> getChildren() {
		return children;
	}
	public void setChildren(List<CurriculumChapter> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "TeacherCurriculum [curriculumId=" + curriculumId + ", curriculumName=" + curriculumName + ", children="
				+ children + "]";
	}
	public TeacherCurriculum(Integer curriculumId, String curriculumName, List<CurriculumChapter> children) {
		super();
		this.curriculumId = curriculumId;
		this.curriculumName = curriculumName;
		this.children = children;
	}
	public TeacherCurriculum() {
		super();
	}

}
