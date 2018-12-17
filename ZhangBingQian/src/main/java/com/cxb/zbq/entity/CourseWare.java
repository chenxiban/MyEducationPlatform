package com.cxb.zbq.entity;

import java.sql.Timestamp;
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
@Table(name="courseWareTb")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseWare {//课件表
	@Id     /*:#{# }*/
	@GeneratedValue
	private Integer courseWareId;
	@Column(columnDefinition="varchar(1000) DEFAULT NULL")
	private String coursewareDescription;
	private Integer classHourId;
	private String coursewarePath;
	private String coursewareType;
	@Column(columnDefinition="int unsigned DEFAULT 0")
	private Integer coursewareDuration;
	private Date coursewareCreationTime;
	@Column(columnDefinition="timestamp")
	private Timestamp lastUpdateTime;
	@Transient
	private String coursewareParam;//临时参数

}
