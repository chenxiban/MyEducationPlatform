package com.cxb.yyc.srviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.yyc.entity.GapfillingAnswer;
import com.cxb.yyc.repository.TeacherSetGapfillingAnswerRepository;
import com.cxb.yyc.service.TeacherSetGapfillingAnswerService;
/**
 * 教师设置填空题答案
 * @author dell
 *
 */
@Service
public class TeacherSetGapfillingAnswerServiceImpl implements TeacherSetGapfillingAnswerService{
	
	@Autowired
	private TeacherSetGapfillingAnswerRepository gapfillingAnswerRepository;
	
	/**
	 * 教师添加选择题答案
	 */
	@Override
	public GapfillingAnswer insertGapfillingAnswer(GapfillingAnswer gapfillingAnswer) {
		return gapfillingAnswerRepository.save(gapfillingAnswer);
	}
	
	/**
	 * 根据填空题主键删除填空题对应的正确答案
	 */
	@Override
	public int deleteGapfillingAnswer(Integer gapfillingAnswerId) {
		return gapfillingAnswerRepository.deleteGapfillingAnswer(gapfillingAnswerId);
	}

	/**
	 * 根据填空题主键修改填空题答案
	 */
	@Override
	@Transactional
	public int updateGapfillingAnswer(GapfillingAnswer gapfillingAnswer) {
		return gapfillingAnswerRepository.updateGapfillingAnswer(gapfillingAnswer);
	}

}
