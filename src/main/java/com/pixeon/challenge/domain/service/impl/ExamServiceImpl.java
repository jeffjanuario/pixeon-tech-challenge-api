package com.pixeon.challenge.domain.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pixeon.challenge.domain.exception.BusinessException;
import com.pixeon.challenge.domain.model.Bugdet;
import com.pixeon.challenge.domain.model.Exam;
import com.pixeon.challenge.domain.model.HealthcareInstitution;

@Service
public class ExamServiceImpl extends BaseServiceImpl<Exam> {

	@Override
	public Exam save(Exam entity) {		
		if(entity.getIdExam() == null) {
			if(entity.getHealthcare().getBugdet().getCoin().compareTo(BigDecimal.ZERO) == 0) {
				throw new BusinessException("You are not allowed to create or take an exam, because you are out of budget!");
			}
			entity.setAccessFirst(true);
			subtractCoinBugdet(entity, "New Exam", BigDecimal.ONE);
		}
		return super.save(entity);
	}
	
	@Override
	public Optional<Exam> findById(Long id) {
		Optional<Exam> findById = super.findById(id);
		if(findById.isPresent()) {
			Exam exam = findById.get();
			if(exam.getAccessFirst().equals(true)) {
				subtractCoinBugdet(exam, "Access First", BigDecimal.ONE);
				exam.setAccessFirst(false);
				this.save(exam);
			}
		}
		return super.findById(id);
	}

	private void subtractCoinBugdet(Exam exam, String description, BigDecimal coin) {
		HealthcareInstitution healthcare = exam.getHealthcare();
		Bugdet bugdet = healthcare.getBugdet();
		BigDecimal coinBugdet =  healthcare.getBugdet().getCoin().subtract(coin);
		bugdet.setCoin(coinBugdet);
		bugdet.setDescription(description);
		healthcare.setBugdet(bugdet);	
		exam.setHealthcare(healthcare);
	}

}
