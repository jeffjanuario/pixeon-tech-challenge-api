package com.pixeon.challenge.api.controller;

import org.springframework.http.ResponseEntity;

import com.pixeon.challenge.api.model.ExamModel;
import com.pixeon.challenge.api.model.input.ExamInput;

public interface ExamController  {
    ExamModel save(Long healthcareId,ExamInput input);
	
	ResponseEntity<ExamModel> findById(Long healthcareId, Long id);

	ResponseEntity<ExamModel> delete(Long healthcareId,Long id);
	
	ResponseEntity<ExamModel> put(Long healthcareId, Long id, ExamInput input);
}
