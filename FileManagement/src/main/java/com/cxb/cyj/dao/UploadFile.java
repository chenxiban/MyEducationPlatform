package com.cxb.cyj.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

	/**
	 * 根据名称查找file
	 * 
	 * @param files_name
	 * @return
	 */
	@Select({ "SELECT COUNT(*) FROM tb_files WHERE files_name=#{name}" })
	Integer getFileByFileName(@Param("name") String files_name);

	/**
	 * 根据名称删除file
	 * 
	 * @param files_name
	 * @return
	 */
	@Delete({ "DELETE FROM filemanagement.tb_files WHERE files_name =#{name}" })
	void deleteFileByFileName(@Param("name") String files_name);
}
