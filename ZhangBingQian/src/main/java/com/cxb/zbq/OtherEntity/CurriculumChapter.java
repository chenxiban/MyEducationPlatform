package com.cxb.zbq.OtherEntity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class CurriculumChapter {
	@JsonProperty("value")
	private Integer chapterId;//章节id
	@JsonProperty("label")
	private String chapterName;//章节名称
	public Integer getChapterId() {
		return chapterId;
	}
	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	@Override
	public String toString() {
		return "CurriculumChapter [chapterId=" + chapterId + ", chapterName=" + chapterName + "]";
	}
	public CurriculumChapter(Integer chapterId, String chapterName) {
		super();
		this.chapterId = chapterId;
		this.chapterName = chapterName;
	}
	public CurriculumChapter() {
		super();
	}

}
