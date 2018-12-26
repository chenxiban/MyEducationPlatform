package com.cxb.cyj.service;

import java.util.Date;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface UploadFileService {
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

	/**
	 * 根据名称删除file
	 * 
	 * @param files_name
	 * @return
	 */
	Integer deleteFileByFileids(@Param("ids") String fileids);

	/**
	 * 
	 * @param uuid
	 * @param files_name
	 * @param files_ur
	 * @param files_url
	 * @param create_time
	 * @param video_size
	 * @param video_time
	 * @param video_format
	 * @param video_cover
	 * @return
	 */
	Integer insertVidoFile(@Param("uuid") String uuid, @Param("name") String files_name, @Param("ur") String files_ur,
			@Param("url") String files_url, @Param("creatTime") Date create_time, @Param("size") String video_size,
			@Param("time") Integer video_time, @Param("format") String video_format,
			@Param("cover") String video_cover);
}
