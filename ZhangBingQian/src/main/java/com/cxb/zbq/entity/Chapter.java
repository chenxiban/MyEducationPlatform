package com.cxb.zbq.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="chapterTb")

public class Chapter {//章节表
	@Id
	@GeneratedValue
	private Integer chapterId;//章节id
	private Integer curriculumId;//课程id
	private String chapterName;//章节/课时名称
	@Column(columnDefinition="varchar(1000) DEFAULT NULL")
	private String chapterDescription;//章节/课时描述
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")	//日期格式化为中国的时区 东8区
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")	//接受::字符串日期需要格式化为日期类型
	private Date creationTime=new Date();//创建时间
	@Column(columnDefinition="int unsigned DEFAULT 0")
	private Integer parentId;//父id
	@Column(columnDefinition="timestamp")
    private Timestamp lastUpdteTime;//最后一次修改时间
    @Transient
    private String remarkParam;//临时字段
    @Transient
    private List<Chapter> children;
    @Transient
    @JsonProperty("iconCls")
    private String iconCls;
	public Integer getChapterId() {
		return chapterId;
	}
	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}
	public Integer getCurriculumId() {
		return curriculumId;
	}
	public void setCurriculumId(Integer curriculumId) {
		this.curriculumId = curriculumId;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	public String getChapterDescription() {
		return chapterDescription;
	}
	public void setChapterDescription(String chapterDescription) {
		this.chapterDescription = chapterDescription;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Timestamp getLastUpdteTime() {
		return lastUpdteTime;
	}
	public void setLastUpdteTime(Timestamp lastUpdteTime) {
		this.lastUpdteTime = lastUpdteTime;
	}
	public String getRemarkParam() {
		return remarkParam;
	}
	public void setRemarkParam(String remarkParam) {
		this.remarkParam = remarkParam;
	}
	public List<Chapter> getChildren() {
		return children;
	}
	public void setChildren(List<Chapter> children) {
		this.children = children;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	@Override
	public String toString() {
		return "Chapter [chapterId=" + chapterId + ", curriculumId=" + curriculumId + ", chapterName=" + chapterName
				+ ", chapterDescription=" + chapterDescription + ", creationTime=" + creationTime + ", parentId="
				+ parentId + ", lastUpdteTime=" + lastUpdteTime + ", remarkParam=" + remarkParam + ", children="
				+ children + ", iconCls=" + iconCls + "]";
	}
	public Chapter(Integer chapterId, Integer curriculumId, String chapterName, String chapterDescription,
			Date creationTime, Integer parentId, Timestamp lastUpdteTime, String remarkParam, List<Chapter> children,
			String iconCls) {
		super();
		this.chapterId = chapterId;
		this.curriculumId = curriculumId;
		this.chapterName = chapterName;
		this.chapterDescription = chapterDescription;
		this.creationTime = creationTime;
		this.parentId = parentId;
		this.lastUpdteTime = lastUpdteTime;
		this.remarkParam = remarkParam;
		this.children = children;
		this.iconCls = iconCls;
	}
	public Chapter() {
		super();
	}
    
}
