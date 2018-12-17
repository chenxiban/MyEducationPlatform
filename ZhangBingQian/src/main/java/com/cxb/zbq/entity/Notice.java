package com.cxb.zbq.entity;

import java.util.Date;

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
@Table(name="noticeTb")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notice {//公告表
	@Id
	@GeneratedValue
	private Integer noticeId;
	private Integer curriculumId;
	private Integer teacherId;
	@Column(columnDefinition="varchar(1000) DEFAULT NULL")
	private String announcementContent;
	private Date creationTime;
	@Transient
	private String noticeParam;//临时参数
}
