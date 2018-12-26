package com.cxb.mzl.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
*@author 作者 E-mail 谢立博 13837051752@163.com
*@version 创建时间:2018年12月20日下午9:25:56
*类说明 班级实体类
*/
public class Clazz {
	private Integer classId;
	private Integer classNumber;
	private String className;
	private Date classCreatTime;
	private Timestamp classUpdateTime;
	private College college;
	private Integer collegeId;
	private int page = 0;
	private int rows = 10;	
	private String collegeName;	
	public String getCollegeName() {
		if(college != null) {
			System.out.println("贴吧分类的名称为");
			return college.getCollegeName();
		}else {
			return collegeName;
		}
		
	}
	public Clazz(Integer classId, Integer classNumber, String className, Date classCreatTime, Timestamp classUpdateTime,
			College college, Integer collegeId, int page, int rows, String collegeName) {
		super();
		this.classId = classId;
		this.classNumber = classNumber;
		this.className = className;
		this.classCreatTime = classCreatTime;
		this.classUpdateTime = classUpdateTime;
		this.college = college;
		this.collegeId = collegeId;
		this.page = page;
		this.rows = rows;
		this.collegeName = collegeName;
	}
	public Clazz() {
		super();
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Integer getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(Integer classNumber) {
		this.classNumber = classNumber;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Date getClassCreatTime() {
		return classCreatTime;
	}
	public void setClassCreatTime(Date classCreatTime) {
		this.classCreatTime = classCreatTime;
	}
	public Timestamp getClassUpdateTime() {
		return classUpdateTime;
	}
	public void setClassUpdateTime(Timestamp classUpdateTime) {
		this.classUpdateTime = classUpdateTime;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public Integer getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	@Override
	public String toString() {
		return "Clazz [classId=" + classId + ", classNumber=" + classNumber + ", className=" + className
				+ ", classCreatTime=" + classCreatTime + ", classUpdateTime=" + classUpdateTime + ", college=" + college
				+ ", collegeId=" + collegeId + ", page=" + page + ", rows=" + rows + ", collegeName=" + collegeName
				+ "]";
	}

}
