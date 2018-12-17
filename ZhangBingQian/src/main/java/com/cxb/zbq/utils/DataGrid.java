package com.cxb.zbq.utils;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * {'total':1000,rows:[]}
 * EasyUI数据表格所需对象
 * @author Administrator
 *
 */
@JsonInclude(Include.NON_NULL)	//如果该属性为NULL则不参与序列化
public class DataGrid {
	
	private long total;
	private List<?> rows;	
	
	public DataGrid(long total, List<?> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public DataGrid() {
		super();
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "DataGrid [total=" + total + ", rows=" + rows + "]";
	}
	
	

}
