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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScoringStandard {//评分标准表
	@Id
	@GeneratedValue
	private Integer scoringStandardId;//评分表id
	private Integer curriculumId;//课程id
	private Integer proportion;//章节所占比重(一门课程比重总和必须为100,考试比重就是100-proportion)
	private Integer updateCount;//修改次数,默认为0
	@Transient
	private String scoringStandardParam;//临时参数
	

}
