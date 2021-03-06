package com.pixeon.challenge.api.controller.impl;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pixeon.challenge.api.controller.ConvertClassModel;
import com.pixeon.challenge.api.controller.ExamController;
import com.pixeon.challenge.api.model.ExamModel;
import com.pixeon.challenge.api.model.input.ExamInput;
import com.pixeon.challenge.domain.model.Exam;
import com.pixeon.challenge.domain.model.HealthcareInstitution;
import com.pixeon.challenge.domain.service.ExamService;
import com.pixeon.challenge.domain.service.HealthcareInstitutionService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/healthcares/{healthcareId}/exams")
public class ExamControllerImpl implements ExamController {

	@Autowired
	private ExamService service;
	@Autowired
	private HealthcareInstitutionService healthcareService;

	@Autowired
	protected ConvertClassModel<ExamInput, ExamModel> inputToModel;
	@Autowired
	protected ConvertClassModel<Exam, ExamModel> entityToModel;
	@Autowired
	protected ConvertClassModel<ExamInput, Exam> inputToEntity;

	public ExamControllerImpl() {
	}

	@Override
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(value = "Add new exam by healthcare institution")
	public ExamModel save(@PathVariable Long healthcareId, @Valid @RequestBody ExamInput input) {
		Optional<HealthcareInstitution> findById = healthcareService.findById(healthcareId);
		Exam exam = inputToEntity.toSimple(input, Exam.class);
		if (findById.isPresent()) {
			exam.setHealthcare(findById.get());
		}
		return entityToModel.toSimple(service.save(exam), ExamModel.class);
	}

	@Override
	@GetMapping("/{id}")
	@ApiOperation(value = "Find exam by id")
	public ResponseEntity<ExamModel> findById(@PathVariable Long healthcareId, @PathVariable Long id) {
		Optional<Exam> old = service.findByHealthcare(healthcareId, id);
		if (old.isPresent()) {
			return ResponseEntity.ok(entityToModel.toSimple(old.get(), ExamModel.class));
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete exam")
	public ResponseEntity<ExamModel> delete(@PathVariable Long healthcareId, @PathVariable(value = "id") Long id) {
		Optional<Exam> old = service.findByHealthcare(healthcareId, id);
		if(!old.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	@PutMapping("/{id}")
	@ApiOperation(value = "Put exam")
	public ResponseEntity<ExamModel> put(@PathVariable Long healthcareId, @PathVariable Long id,
			@Valid @RequestBody ExamInput input) {
		Optional<Exam> old = service.findByHealthcare(healthcareId, id);
		if(!old.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		input.setId(id);
		Exam entity = service.save(inputToEntity.toSimple(input, Exam.class));
		return ResponseEntity.ok(entityToModel.toSimple(entity, ExamModel.class));
	}

}
