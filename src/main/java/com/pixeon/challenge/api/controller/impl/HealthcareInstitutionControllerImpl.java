package com.pixeon.challenge.api.controller.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pixeon.challenge.api.controller.HealthcareInstitutionController;
import com.pixeon.challenge.api.model.HealthcareInstitutionModel;
import com.pixeon.challenge.api.model.input.HealthcareInstitutionInput;
import com.pixeon.challenge.domain.model.HealthcareInstitution;
import com.pixeon.challenge.domain.service.HealthcareInstitutionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/healthcares")
@Api(value="API REST Healthcares")
@CrossOrigin(origins="*")
public class HealthcareInstitutionControllerImpl extends BaseControllerImpl<HealthcareInstitution,HealthcareInstitutionInput, HealthcareInstitutionModel> implements HealthcareInstitutionController { 
	
	@Autowired
	private HealthcareInstitutionService healthcareInstitutionService;
	
	public HealthcareInstitutionControllerImpl() {
		super(HealthcareInstitution.class, HealthcareInstitutionInput.class, HealthcareInstitutionModel.class);
	}
	
	
	@Override
	@PostMapping("/{id}/{coin}")
	@ApiOperation(value="Add coin to budget by healthcare institution")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<HealthcareInstitutionModel> addCoinBugdet(@PathVariable Long id,@PathVariable BigDecimal coin,  @Valid @RequestBody HealthcareInstitutionInput input) {
		if (!service.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		input.setId(id);
		HealthcareInstitution entity = healthcareInstitutionService.addCoinBugdet(inputToEntity.toSimple(input, entityClass), coin);
		return ResponseEntity.ok(entityToModel.toSimple(entity, modelClass));
	}
	
	@Override
	@ApiOperation(value="List all healthcare institution")
	public List<HealthcareInstitutionModel> findAll() {
		return super.findAll();
	}
	
	@Override
	@ApiOperation(value="Find healthcare by id")
	public ResponseEntity<HealthcareInstitutionModel> findById(@PathVariable Long id) {
		return super.findById(id);
	}
	
	@Override
	@ApiOperation(value="Save healthcare")
	public HealthcareInstitutionModel save(@Valid @RequestBody HealthcareInstitutionInput input) {
		return super.save(input);
	}
	
	@Override
	@ApiOperation(value="Put healthcare")
	public ResponseEntity<HealthcareInstitutionModel> put(@PathVariable Long id, @Valid @RequestBody HealthcareInstitutionInput input) {
		return super.put(id, input);
	}
	
	@Override
	@ApiOperation(value="Delete healthcar")
	public ResponseEntity<HealthcareInstitutionModel> delete(@PathVariable Long id) {
		return super.delete(id);
	}
}
