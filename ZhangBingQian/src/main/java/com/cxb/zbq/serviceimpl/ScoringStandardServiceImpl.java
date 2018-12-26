package com.cxb.zbq.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.zbq.dao.ScoringStandardRepository;
import com.cxb.zbq.entity.ScoringStandard;
import com.cxb.zbq.service.ScoringStandardService;
@Service
public class ScoringStandardServiceImpl implements ScoringStandardService {
	@Autowired
	private ScoringStandardRepository scRepository;

	@Override
	public ScoringStandard insertScStan(ScoringStandard scoringStandard) {
		return scRepository.save(scoringStandard);
	}

	@Override
	public int updateScStan(ScoringStandard scoringStandard) {
		return scRepository.updateScStan(scoringStandard);
	}

	@Override
	public int deleteScStan(Integer currId) {
		return scRepository.deleteScStan(currId);
	}

	@Override
	public ScoringStandard findByScoringStandardId(Integer scstanId) {
		return scRepository.findByScoringStandardId(scstanId);
	}

	@Override
	public ScoringStandard findByCurriculumId(Integer currId) {
		return scRepository.findByCurriculumId(currId);
	}

	@Override
	public List<ScoringStandard> queryScoringStandardBycurriculumId(List<Integer> curriculumId) {
		// TODO Auto-generated method stub
		return scRepository.queryScoringStandardBycurriculumId(curriculumId);
	}

	@Override
	public int updateScStan(Integer scoringStandardId, Integer proportion) {
		// TODO Auto-generated method stub
		return scRepository.updateScStan(scoringStandardId, proportion);
	}

	@Override
	public ScoringStandard insertScoringStandard(ScoringStandard s) {
		// TODO Auto-generated method stub
		return scRepository.save(s);
	}

}
