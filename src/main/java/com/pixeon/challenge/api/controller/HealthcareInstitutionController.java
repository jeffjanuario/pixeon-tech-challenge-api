package com.pixeon.challenge.api.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.pixeon.challenge.api.model.HealthcareInstitutionModel;
import com.pixeon.challenge.api.model.input.HealthcareInstitutionInput;
import com.pixeon.challenge.domain.model.HealthcareInstitution;

@RestController
public interface HealthcareInstitutionController extends BaseController<HealthcareInstitution,HealthcareInstitutionInput, HealthcareInstitutionModel> {
	public ResponseEntity<HealthcareInstitutionModel> addCoinBugdet(Long id,BigDecimal coin);
}
