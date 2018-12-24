package com.cxb.zbq.serviceimpl;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.cxb.zbq.dao.CurriculumRepository;
import com.cxb.zbq.entity.Curriculum;
import com.cxb.zbq.entityquery.CurriculumQuery;
import com.cxb.zbq.service.CurriculumService;
@Service
public class CurriculumServiceImpl implements CurriculumService {
	@Autowired
	private CurriculumRepository curriculumRepository;

	@Override
	public int updateCurriculum(Curriculum curriculum) {
		return curriculumRepository.updateCurriculum(curriculum);
	}

	@Override
	public Curriculum insertCurriculum(Curriculum curriculum) {
		return curriculumRepository.save(curriculum);
	}

	@Override
	public Curriculum findByCurriculumName(String curriculumName) {
		return curriculumRepository.findByCurriculumName(curriculumName);
	}

	@Override
	public Curriculum findBycurriculumId(Integer curriculumId) {
		return curriculumRepository.findBycurriculumId(curriculumId);
	}

	@Override
	public int deleteCurriculum(Integer curriculumId) {
		return curriculumRepository.deleteCurriculum(curriculumId);
	}

	@Override
	public int updateSubscriptionNum(Integer currId) {
		return curriculumRepository.updateSubscriptionNum(currId);
	}

	@Override
	public int updateIsReleaseToTrue(Integer currId, Date startTime, Date endTime) {
		return curriculumRepository.updateIsReleaseToTrue(currId, startTime, endTime);
	}

	@Override
	public int updateIsReleaseToFalse(Integer currId) {
		return curriculumRepository.updateIsReleaseToFalse(currId);
	}
	
	@Override
	public List<Curriculum> getCurriculumByPage(CurriculumQuery currQuery) {
		// Sort sort = new Sort(Sort.Direction.ASC, "curriculumId");   
		 // pageable = new PageRequest(page, size);
		return curriculumRepository.findAll(this.getWhereClause(currQuery));
	}

	/*@Override
	public Page<Curriculum> queryCurriculumByPage(CurriculumQuery currQuery,Pageable pageable) {
		// Sort sort = new Sort(Sort.Direction.ASC, "curriculumId");   
		 // pageable = new PageRequest(page, size);
		return curriculumRepository.findAll(this.getWhereClause(currQuery), pageable);
	}*/

	
	private Specification<Curriculum> getWhereClause(CurriculumQuery currQuery){ 
		  return new Specification<Curriculum>() {
			@Override
			public Predicate toPredicate(Root<Curriculum> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				 Predicate predicate = cb.conjunction();//动态SQL表达式              
				 List<Expression<Boolean>> exList = predicate.getExpressions();//动态SQL表达式集合   
				 if( currQuery.getCurriculumName() != null && !"".equals(currQuery.getCurriculumName()) ){ 
					 exList.add(cb.like(root.<String>get("curriculumName"), "%"+currQuery.getCurriculumName()+"%"));   
					 }           
				 if( currQuery.getCurriculumCategoryId() != null ){           
					 exList.add(cb.equal(root.get("curriculumCategoryId").as(Integer.class), currQuery.getCurriculumCategoryId()));
					 }
				 if( currQuery.getWhetherToIssue() != null ){           
					 exList.add(cb.equal(root.get("whetherToIssue").as(Integer.class), currQuery.getWhetherToIssue()));
					 }
				 if( currQuery.getTeacherId() != null ){           
					 exList.add(cb.equal(root.get("teacherId").as(Integer.class), currQuery.getTeacherId()));
					 }
				 
				return predicate;
			}
		};
	  }

	@Override
	public int delSubscriptionNum(Integer currId) {
		return curriculumRepository.delSubscriptionNum(currId);
	}

	@Override
	public List<Curriculum> getAllCurr() {
		return curriculumRepository.findAll();
	}

	@Override
	public List<Integer> getCurrIdBySubscriptionNum() {
		return curriculumRepository.getCurrIdBySubscriptionNum();
	}

	@Override
	public String getCurrNameByCurrId(Integer currId) {
		return curriculumRepository.findBycurriculumId(currId).getCurriculumName();
	}


}
