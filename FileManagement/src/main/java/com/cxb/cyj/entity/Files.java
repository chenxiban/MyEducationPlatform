package com.cxb.cyj.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor // 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@ToString
public class Files implements Serializable {
	
	private int files_id;
	private Date create_time;
	private String files_name;
	private Date update_time;
	private String files_uploadUrl;
	private String files_url;
	
}
