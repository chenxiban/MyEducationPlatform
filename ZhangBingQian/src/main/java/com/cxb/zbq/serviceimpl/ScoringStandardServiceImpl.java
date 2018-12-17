package com.cxb.zbq.serviceimpl;

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

}
