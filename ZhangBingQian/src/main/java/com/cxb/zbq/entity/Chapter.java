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


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="chapterTb")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chapter {//章节表
	@Id
	@GeneratedValue
	private Integer chapterId;
	private Integer curriculumId;
	private String chapterName;
	@Column(columnDefinition="varchar(1000) DEFAULT NULL")
	private String chapterDescription;
	private Date creationTime;
	private Date openingHours;
	private Date endTime;
	@Column(columnDefinition="int unsigned DEFAULT 0")
	private Integer parentId;
	@Column(columnDefinition="timestamp")
    private Timestamp lastUpdteTime;
    @Transient
    private String remarkParam;//临时字段
    @Transient
    private List<Chapter> children;
	
}
