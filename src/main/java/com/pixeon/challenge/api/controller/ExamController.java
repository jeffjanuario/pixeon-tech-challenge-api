package com.pixeon.challenge.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.pixeon.challenge.api.model.ExamModel;
import com.pixeon.challenge.api.model.input.ExamInput;

@RestController
public interface ExamController  {
    ExamModel save(Long healthcareId,ExamInput input);
	
	ResponseEntity<ExamModel> findById(Long id);

	ResponseEntity<ExamModel> delete(Long id);
	
	ResponseEntity<ExamModel> put(Long id, ExamInput input);
}
