package com.cxb.yyc.srviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.yyc.entity.Option;
import com.cxb.yyc.repository.TeacherSetOptionRepository;
import com.cxb.yyc.service.TeacherSetOptionService;
/**
 * 教师设置选择题的选项
 * @author dell
 *
 */
@Service
public class TeacherSetOptionServiceImpl implements TeacherSetOptionService{

	@Autowired
	private TeacherSetOptionRepository optionRepository;
	
	/**
	 * 教师设置选择题的所有选项
	 */
	@Override
	public Option insertOption(Option option) {
		return optionRepository.save(option);
	}

	/**
	 * 根据问题主键，删除问题的所有主键
	 */
	@Override
	@Transactional
	public int deleteOption(Integer questionId) {
		return optionRepository.deleteOption(questionId);
	}

	/**
	 * 根据选项主键修改选项
	 */
	@Override
	@Transactional
	public int updateOption(Integer optionId, String optiona, String optionb, String optionc, String optiond) {
		return optionRepository.updateOption(optionId, optiona, optionb, optionc, optiond);
	}

	

}
