package com.cxb.zbq.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
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
	private Integer noticeId;//公告id
	private Integer curriculumId;//课程id
	private Integer teacherId;//老师id
	private String noticeTitle;//公告标题
	@Column(columnDefinition="varchar(1000) DEFAULT NULL")
	private String announcementContent;//公告内容
	@OrderBy(value="DESC")
	private Date creationTime=new Date();//创建时间
	@Column(columnDefinition="timestamp")
	private Timestamp lastUpdateTime;//最后一次修改时间
	@Transient
	private String curriculumName;//临时参数(课程名称)
}
