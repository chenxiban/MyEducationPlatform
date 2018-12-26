package com.cxb.wmx.dao;

import java.util.Date;

/**
 * 自定义投影映射
 * Post Bar
 * @author 刘森川
 *
 */
public interface PostBar {
	
	 String getPostName();
	 String getPostTitle();
	 String getPostContent();
	 Date getPostCreatetime();
     String getBarCategory();

}