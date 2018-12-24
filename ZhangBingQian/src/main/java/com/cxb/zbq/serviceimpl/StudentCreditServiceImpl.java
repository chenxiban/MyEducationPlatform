package com.cxb.zbq.serviceimpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.cxb.zbq.dao.StudentCreditRepository;
import com.cxb.zbq.entity.StudentCredit;
import com.cxb.zbq.entityquery.StudentCreditQuery;
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

	@Override
	public List<StudentCredit> getStudentCredits(StudentCreditQuery sQuery) {
		return stuRepository.findAll(this.getWhereClause(sQuery));
	}
	
	private Specification<StudentCredit> getWhereClause(StudentCreditQuery sQuery){ 
		  return new Specification<StudentCredit>() {
			@Override
			public Predicate toPredicate(Root<StudentCredit> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				 Predicate predicate = cb.conjunction();//动态SQL表达式              
				 List<Expression<Boolean>> exList = predicate.getExpressions();//动态SQL表达式集合   
				 if( sQuery.getStudentId() != null){ 
					 exList.add(cb.equal(root.get("studentId").as(Integer.class), sQuery.getStudentId()));
					 }           
				  if( sQuery.getMinCredit() != null ){   
					  exList.add(cb.greaterThanOrEqualTo(root.<Integer>get("credit"), sQuery.getMinCredit()));    
					  }            
				  if( sQuery.getMaxCredit() != null ){         
					  exList.add(cb.lessThanOrEqualTo(root.get("credit").as(Integer.class), sQuery.getMaxCredit()));        
					  } 
				 
				return predicate;
			}
		};
	  }

}
