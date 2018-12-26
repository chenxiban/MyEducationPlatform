package com.cxb.zbq.OtherEntity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class SelectCurriculum {
	@JsonProperty("value")
	private Integer curriculumId;//课程id
	@JsonProperty("label")
	private String curriculumName;//课程名称
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
	@Override
	public String toString() {
		return "SelectCurriculum [curriculumId=" + curriculumId + ", curriculumName=" + curriculumName + "]";
	}
	public SelectCurriculum(Integer curriculumId, String curriculumName) {
		super();
		this.curriculumId = curriculumId;
		this.curriculumName = curriculumName;
	}
	public SelectCurriculum() {
		super();
	}

}
