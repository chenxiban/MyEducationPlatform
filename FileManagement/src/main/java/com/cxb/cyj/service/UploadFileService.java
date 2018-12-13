package com.cxb.cyj.service;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface UploadFileService {
	/**
	 * 上传文件
	 * 
	 * @param files
	 * @return
	 */
	Integer insertFile(String uuid,String files_name,String files_url,String files_uploadUrl,Date create_time);
	/**
	 * 根据名称查找FILE
	 * 
	 * @param files_name
	 * @return
	 */
	Integer getFileByFileName(@Param("name") String files_name);

	/**
	 * 根据名称删除FILE
	 * 
	 * @param files_name
	 * @return
	 */
	void deleteFileByFileName(@Param("name") String files_name);
}
