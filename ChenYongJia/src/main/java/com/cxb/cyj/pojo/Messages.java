package com.cxb.cyj.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @Description:消息提示类
 * @ClassName: Messages.java
 * @author ChenYongJia
 * @Date 2018年12月02日 晚上22：54
 * @Email chen87647213@163.com
 */
@SuppressWarnings("serial")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Messages implements Serializable {
	
	private String title;
    private String content;
    private String extraInfo;
	
}
