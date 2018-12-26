package com.cxb.zbq.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.cxb.zbq.dao.CoverMapRepository;
import com.cxb.zbq.entity.CoverMap;
import com.cxb.zbq.feign.UploadFeign;
import com.cxb.zbq.service.CoverMapService;
@Service
public class CoverMapServiceImpl implements CoverMapService {
	@Autowired
	private CoverMapRepository coverRepository;


	@Override
	public CoverMap insertCoverMap(CoverMap coverMap) {
		return coverRepository.save(coverMap);
	}

	@Override
	public List<CoverMap> getAllCovermap() {
		return coverRepository.findAll();
	}

	/*@Override
	public Integer deleteCoverMap(String covermapId) {
		List<String> fileId=new ArrayList<>();
		fileId.add(covermapId);
		return feign.deleteFile(fileId);
	}*/

}
