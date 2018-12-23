package com.cxb.yyc.srviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.yyc.entity.TfngAnswer;
import com.cxb.yyc.repository.TeacherSetTfngAnswerRepository;
import com.cxb.yyc.service.TeacherSetTfngAnswerService;
/**
 * 教师设置判断题
 * @author dell
 *
 */
@Service
public class TeacherSetTfngAnswerServiceImpl implements TeacherSetTfngAnswerService{

	@Autowired
	private TeacherSetTfngAnswerRepository tfngAnswerRepository; 
	
	/**
	 * 教师添加判断题答案
	 */
	@Override
	public TfngAnswer insertTfngAnswer(TfngAnswer tfngAnswer) {
		return tfngAnswerRepository.save(tfngAnswer);
	}

	/**
	 * 根据判断题主键删除判断题
	 */
	@Override
	@Transactional
	public int deleteTfngAnswer(Integer tfngAnswerId) {
		return tfngAnswerRepository.deleteTfngAnswer(tfngAnswerId);
	}

	/**
	 * 根据判断题答案主键修改答案
	 */
	@Override
	@Transactional
	public int updateTfngAnswer(TfngAnswer tfngAnswer) {
		return tfngAnswerRepository.updateTfngAnswer(tfngAnswer);
	}

	@Override
	public String queryTfngAnswer(String question) {
		return queryTfngAnswer(question);
	}

}
