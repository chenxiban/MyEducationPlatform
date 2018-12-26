package com.cxb.cyj.service.impl;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.cyj.dao.UploadFile;
import com.cxb.cyj.service.UploadFileService;

@Service
public class UploadFileServiceImpl implements UploadFileService {
	@Autowired
	private UploadFile uploadFile;

	@Override
	public Integer getFileByFileName(String files_name) {
		// TODO Auto-generated method stub
		return uploadFile.getFileByFileName(files_name);
	}

	@Override
	public void deleteFileByFileName(String files_name) {
		// TODO Auto-generated method stub
		uploadFile.deleteFileByFileName(files_name);
	}

	@Override
	public Integer insertVidoFile(String uuid, String files_name, String files_ur, String files_url, Date create_time,
			String video_size, Integer video_time, String video_format, String video_cover) {
		// TODO Auto-generated method stub
		return uploadFile.insertVidoFile(uuid, files_name, files_ur, files_url, create_time, video_size, video_time,
				video_format, video_cover);
	}

}
