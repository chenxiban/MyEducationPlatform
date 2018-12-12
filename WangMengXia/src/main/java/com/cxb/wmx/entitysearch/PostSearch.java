package com.cxb.wmx.entitysearch;

public class PostSearch {

	private String postName;
	private String barCategory;
	private int page=0;
	private int rows=10;
	public String getPostName() {
		return postName;
	}
	public String getBarCategory() {
		return barCategory;
	}
	public int getPage() {
		return page;
	}
	public int getRows() {
		return rows;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public void setBarCategory(String barCategory) {
		this.barCategory = barCategory;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public PostSearch(String postName, String barCategory, int page, int rows) {
		super();
		this.postName = postName;
		this.barCategory = barCategory;
		this.page = page;
		this.rows = rows;
	}
	public PostSearch() {
		super();
	}
	@Override
	public String toString() {
		return "PostSearch [postName=" + postName + ", barCategory=" + barCategory + ", page=" + page + ", rows=" + rows
				+ "]";
	}
	
}
