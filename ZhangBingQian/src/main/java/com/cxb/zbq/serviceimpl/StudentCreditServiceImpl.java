package com.cxb.zbq.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.zbq.dao.StudentCreditRepository;
import com.cxb.zbq.entity.StudentCredit;
import com.cxb.zbq.service.StudentCreditService;

@Service
public class StudentCreditServiceImpl implements StudentCreditService {
	@Autowired
	private StudentCreditRepository stuRepository;

	@Override
	public int insertStudentCredit(Double credit, Integer currId, Integer stuId) {
		return stuRepository.insertStudentCredit(credit, currId, stuId);
	}

	@Override
	public StudentCredit findByCurriculumIdAndStudentId(Integer curriculumId, Integer studentId) {
		return stuRepository.findByCurriculumIdAndStudentId(curriculumId, studentId);
	}

	@Override
	public double getSumCredit(Integer stuId) {
		return stuRepository.getSumCredit(stuId);
	}

	@Override
	public int updateStudentCredit(Double credit, Integer currId, Integer stuId) {
		return stuRepository.updateStudentCredit(credit, currId, stuId);
	}

	@Override
	public List<StudentCredit> findByStudentId(Integer studentId) {
		return stuRepository.findByStudentId(studentId);
	}

}
