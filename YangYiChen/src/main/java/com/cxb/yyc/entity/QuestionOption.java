package com.cxb.yyc.entity;

/**
 *原生SqL多表连接,查询出的结果集对应(只需原生SQL结果集字段顺序与此实体类字段顺序一致即可)的自定义实体类
 *@Description:   查询问题以及该问题下的选项
 *@ClassName:     QuestionOption.java
 * @author dell
 *
 */
public interface QuestionOption {	

	Integer getOtherState(); 
	String getOtherQuestion();
	Integer getOtherScore();
	String getOtherImgurl();
	Integer getOtherCourseId();
	Integer getOtherChapterId();
	String getOtherA();
	String getOtherB();
	String getOtherC();
	String getOtherD();
	/*public String getOtherQuestion() {
		return otherQuestion;
	}
	public void setOtherQuestion(String otherQuestion) {
		this.otherQuestion = otherQuestion;
	}
	public Integer getOtherScore() {
		return otherScore;
	}
	public void setOtherScore(Integer otherScore) {
		this.otherScore = otherScore;
	}
	public String getOtherImgurl() {
		return otherImgurl;
	}
	public void setOtherImgurl(String otherImgurl) {
		this.otherImgurl = otherImgurl;
	}
	public Integer getOtherState() {
		return otherState;
	}
	public void setOtherState(Integer otherState) {
		this.otherState = otherState;
	}
	public Integer getOtherCourseId() {
		return otherCourseId;
	}
	public void setOtherCourseId(Integer otherCourseId) {
		this.otherCourseId = otherCourseId;
	}
	public Integer getOtherChapterId() {
		return otherChapterId;
	}
	public void setOtherChapterId(Integer otherChapterId) {
		this.otherChapterId = otherChapterId;
	}
	public String getOtherA() {
		return otherA;
	}
	public void setOtherA(String otherA) {
		this.otherA = otherA;
	}
	public String getOtherB() {
		return otherB;
	}
	public void setOtherB(String otherB) {
		this.otherB = otherB;
	}
	public String getOtherC() {
		return otherC;
	}
	public void setOtherC(String otherC) {
		this.otherC = otherC;
	}
	public String getOtherD() {
		return otherD;
	}
	public void setOtherD(String otherD) {
		this.otherD = otherD;
	}*/
	
	
	
}
