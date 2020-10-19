package com.pixeon.challenge.domain.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixeon.challenge.domain.model.Bugdet;
import com.pixeon.challenge.domain.model.HealthcareInstitution;
import com.pixeon.challenge.domain.repository.BugdetRepository;
import com.pixeon.challenge.domain.service.HealthcareInstitutionService;

@Service
public class HealthcareInstitutionServiceImpl extends BaseServiceImpl<HealthcareInstitution> implements HealthcareInstitutionService {
	
	@Autowired
	private BugdetRepository bugdetRepository;
	
	@Override
	public HealthcareInstitution save(HealthcareInstitution entity) {
		if(entity.getIdHealthcare() == null) {
			Bugdet bugdet = new Bugdet();
			bugdet.setCoin(BigDecimal.valueOf(20.0D));
			bugdet.setDescription("New Institution");
			Bugdet newBubdet = bugdetRepository.save(bugdet);
			entity.setBugdet(newBubdet);
		}
		return super.save(entity);
	}

	@Override
	public HealthcareInstitution addCoinBugdet(HealthcareInstitution entity, BigDecimal coin) {
		Optional<Bugdet> findById = bugdetRepository.findById(entity.getBugdet().getIdBugdet());
		if(findById.isPresent()) {
			Bugdet bugdet = findById.get();
			bugdet.setCoin(bugdet.getCoin().add(coin));
			bugdet.setDescription("Add coin to bugdet");
			entity.setBugdet(bugdet);	
		}
		return save(entity);
	}
}
