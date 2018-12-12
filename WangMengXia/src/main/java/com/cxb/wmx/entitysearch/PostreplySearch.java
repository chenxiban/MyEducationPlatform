package com.cxb.wmx.entitysearch;

public class PostreplySearch {

	private String userName;
	private int page=0;
	private int rows=10;
	public String getUserName() {
		return userName;
	}
	public int getPage() {
		return page;
	}
	public int getRows() {
		return rows;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public PostreplySearch(String userName, int page, int rows) {
		super();
		this.userName = userName;
		this.page = page;
		this.rows = rows;
	}
	public PostreplySearch() {
		super();
	}
	@Override
	public String toString() {
		return "PostreplySearch [userName=" + userName + ", page=" + page + ", rows=" + rows + "]";
	}
	
}
