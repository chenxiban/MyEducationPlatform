package com.cxb.wmx.entitysearch;


/**
 * 分页查询贴吧分类
 * @author 王梦霞
 *
 */
public class BarSearch {

	private String barCategory;
	private int page=0;
	private int rows=10;
	public String getBarCategory() {
		return barCategory;
	}
	public int getPage() {
		return page;
	}
	public int getRows() {
		return rows;
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
	public BarSearch(String barCategory, int page, int rows) {
		super();
		this.barCategory = barCategory;
		this.page = page;
		this.rows = rows;
	}
	public BarSearch() {
		super();
	}
	@Override
	public String toString() {
		return "BarSearch [barCategory=" + barCategory + ", page=" + page + ", rows=" + rows + "]";
	}
	
}
