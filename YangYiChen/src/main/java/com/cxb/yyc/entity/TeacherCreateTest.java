package com.cxb.yyc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 教师发起测试
 * @author dell
 *
 */
@Entity
@Table(name="teachercreatetesttb")
public class TeacherCreateTest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned comment '备注：教师发起测试主键' ")
	private Integer teachercreatetestId;
	@Column(nullable=false,columnDefinition="varchar(225) comment '备注：测试说明' ")
	private String teachercreatetestExplain;
	@Column(nullable=false,columnDefinition="datetime comment '备注：测试截止时间' ")
	@JsonFormat(locale="zh",timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")//后台到前台的时间格式的转换
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//前台到后台的时间格式的转换
	private Date teachercreatetestEndtime;
	@Column(columnDefinition="varchar(225) comment '备注：测试时间' ")
	private String teachercreatetestTesttime;
	@Column(columnDefinition="varchar(10) NOT NULL comment '备注：测试题目是否随机出现' ")
	private String teachercratetestRandom;
	@Column(columnDefinition="tinyint NOT NULL DEFAULT 0 comment '备注：测试状态(0:未发布；1:发布)' ")
	private Integer teachercratetestState;
	@Column(columnDefinition="varchar(120) NOT NULL comment '备注：测试名称' ")
	private String teachercratetestTestname;
	@Column(columnDefinition="int unsigned comment '备注：选择题数量' ")
	private Integer teachercratetestChoicenum;
	@Column(columnDefinition="int unsigned comment '备注：判断题数量' ")
	private Integer teachercratetestTfngnum;
	@Column(columnDefinition="int unsigned comment '备注：填空题数量' ")
	private Integer teachercratetestGapfillingnum;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：允许测试的次数' ")
	private Integer teachercreatetestNumber;
	private Integer teachercreatetestExt1;
	@Column(length=225)
	private String teachercreatetestExt2;
	@Column(columnDefinition="int unsigned comment '备注：章节外键' ")
	private Integer teachercreatetestChapterId;
	@Column(columnDefinition="int unsigned comment '备注：教师外键' ")
	private Integer teachercreatetestTeacherId;
	
	
	
	public Integer getTeachercreatetestId() {
		return teachercreatetestId;
	}
	public void setTeachercreatetestId(Integer teachercreatetestId) {
		this.teachercreatetestId = teachercreatetestId;
	}
	public String getTeachercreatetestExplain() {
		return teachercreatetestExplain;
	}
	public void setTeachercreatetestExplain(String teachercreatetestExplain) {
		this.teachercreatetestExplain = teachercreatetestExplain;
	}
	public Date getTeachercreatetestEndtime() {
		return teachercreatetestEndtime;
	}
	public void setTeachercreatetestEndtime(Date teachercreatetestEndtime) {
		this.teachercreatetestEndtime = teachercreatetestEndtime;
	}
	public String getTeachercreatetestTesttime() {
		return teachercreatetestTesttime;
	}
	public void setTeachercreatetestTesttime(String teachercreatetestTesttime) {
		this.teachercreatetestTesttime = teachercreatetestTesttime;
	}
	public String getTeachercratetestRandom() {
		return teachercratetestRandom;
	}
	public void setTeachercratetestRandom(String teachercratetestRandom) {
		this.teachercratetestRandom = teachercratetestRandom;
	}
	
	public Integer getTeachercratetestState() {
		return teachercratetestState;
	}
	public void setTeachercratetestState(Integer teachercratetestState) {
		this.teachercratetestState = teachercratetestState;
	}
	
	public Integer getTeachercreatetestChapterId() {
		return teachercreatetestChapterId;
	}
	public void setTeachercreatetestChapterId(Integer teachercreatetestChapterId) {
		this.teachercreatetestChapterId = teachercreatetestChapterId;
	}
	public Integer getTeachercreatetestTeacherId() {
		return teachercreatetestTeacherId;
	}
	public void setTeachercreatetestTeacherId(Integer teachercreatetestTeacherId) {
		this.teachercreatetestTeacherId = teachercreatetestTeacherId;
	}
	public String getTeachercratetestTestname() {
		return teachercratetestTestname;
	}
	public void setTeachercratetestTestname(String teachercratetestTestname) {
		this.teachercratetestTestname = teachercratetestTestname;
	}
	public Integer getTeachercratetestChoicenum() {
		return teachercratetestChoicenum;
	}
	public void setTeachercratetestChoicenum(Integer teachercratetestChoicenum) {
		this.teachercratetestChoicenum = teachercratetestChoicenum;
	}
	public Integer getTeachercratetestTfngnum() {
		return teachercratetestTfngnum;
	}
	public void setTeachercratetestTfngnum(Integer teachercratetestTfngnum) {
		this.teachercratetestTfngnum = teachercratetestTfngnum;
	}
	public Integer getTeachercratetestGapfillingnum() {
		return teachercratetestGapfillingnum;
	}
	public void setTeachercratetestGapfillingnum(Integer teachercratetestGapfillingnum) {
		this.teachercratetestGapfillingnum = teachercratetestGapfillingnum;
	}
	public Integer getTeachercreatetestNumber() {
		return teachercreatetestNumber;
	}
	public void setTeachercreatetestNumber(Integer teachercreatetestNumber) {
		this.teachercreatetestNumber = teachercreatetestNumber;
	}
	public Integer getTeachercreatetestExt1() {
		return teachercreatetestExt1;
	}
	public void setTeachercreatetestExt1(Integer teachercreatetestExt1) {
		this.teachercreatetestExt1 = teachercreatetestExt1;
	}
	public String getTeachercreatetestExt2() {
		return teachercreatetestExt2;
	}
	public void setTeachercreatetestExt2(String teachercreatetestExt2) {
		this.teachercreatetestExt2 = teachercreatetestExt2;
	}
	

	
}
