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
	public Integer insertFile(String uuid,String files_name, String files_url, String files_uploadUrl, Date create_time) {
		return uploadFile.insertFile(uuid,files_name, files_url, files_uploadUrl, create_time);
	}




}
