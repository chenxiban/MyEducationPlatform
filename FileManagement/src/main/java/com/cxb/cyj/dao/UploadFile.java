package com.cxb.cyj.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UploadFile {
	/**
	 * 上传文件
	 * 
	 * @param files
	 * @return
	 */
	@Insert({ "INSERT INTO tb_files (files_id,files_name,files_url,files_uploadUrl,create_time) VALUES (#{uuid},#{files_name},#{files_url},#{files_uploadUrl},#{creatTime})" })
	Integer insertFile(@Param("uuid") String uuid,@Param("files_name") String files_name, @Param("files_url") String files_ur, @Param("files_uploadUrl") String files_uploadUrl,@Param("creatTime")Date create_time);
}
