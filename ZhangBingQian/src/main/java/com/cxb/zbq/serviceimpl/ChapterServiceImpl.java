package com.cxb.zbq.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.zbq.dao.ChapterRepository;
import com.cxb.zbq.entity.Chapter;
import com.cxb.zbq.service.ChapterService;
@Service
public class ChapterServiceImpl implements ChapterService {
	@Autowired
	private ChapterRepository chapterRepository;

	@Override
	public List<Chapter> getChapterListByCurriculumId(Integer CurriculumId) {
		return chapterRepository.getChapterListByCurriculumId(CurriculumId);
	}

}
