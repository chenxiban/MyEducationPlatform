package com.cxb.wmx.entitysearch;

public class PostComSearch {

	private String postcommitName;
	private int page=0;
	private int rows=10;
	public String getPostcommitName() {
		return postcommitName;
	}
	public int getPage() {
		return page;
	}
	public int getRows() {
		return rows;
	}
	public void setPostcommitName(String postcommitName) {
		this.postcommitName = postcommitName;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public PostComSearch(String postcommitName, int page, int rows) {
		super();
		this.postcommitName = postcommitName;
		this.page = page;
		this.rows = rows;
	}
	public PostComSearch() {
		super();
	}
	@Override
	public String toString() {
		return "PostComSearch [postcommitName=" + postcommitName + ", page=" + page + ", rows=" + rows + "]";
	}
	
}
