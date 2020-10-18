package com.pixeon.challenge.domain.service;

import java.math.BigDecimal;

import com.pixeon.challenge.domain.model.HealthcareInstitution;


public interface HealthcareInstitutionService extends BaseService<HealthcareInstitution> {
	public HealthcareInstitution addCoinBugdet(HealthcareInstitution entity,BigDecimal coin);
}
