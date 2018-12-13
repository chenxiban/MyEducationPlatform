package com.cxb.cyj.service;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public interface UploadFileService {
	Integer insertFile(String uuid,String files_name,String files_url,String files_uploadUrl,Date create_time);
}
