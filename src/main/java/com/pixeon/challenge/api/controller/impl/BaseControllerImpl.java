package com.pixeon.challenge.api.controller.impl;

import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pixeon.challenge.api.controller.BaseController;
import com.pixeon.challenge.api.controller.ConvertClassModel;
import com.pixeon.challenge.api.model.BaseModel;
import com.pixeon.challenge.api.model.input.BaseInput;
import com.pixeon.challenge.domain.model.AbstractPojo;
import com.pixeon.challenge.domain.service.BaseService;

public abstract class BaseControllerImpl<P extends AbstractPojo, I extends BaseInput, E extends BaseModel>
		implements BaseController<P, I, E> {
	@Autowired
	protected BaseService<P> service;
	protected Class<P> entityClass;
	protected Class<I> inputClass;
	protected Class<E> modelClass;
	@Autowired
	protected ConvertClassModel<I, E> inputToModel;
	@Autowired
	protected ConvertClassModel<P, E> entityToModel;
	@Autowired
	protected ConvertClassModel<I, P> inputToEntity;

	public BaseControllerImpl(Class<P> entityClass, Class<I> inputClass, Class<E> modelClass) {
		this.entityClass = entityClass;
		this.inputClass = inputClass;
		this.modelClass = modelClass;
	}

	@Override
	@GetMapping
	public List<E> findAll() {
		return entityToModel.toCollection(service.findAll(), modelClass);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<E> findById(@PathVariable Long id) {
		Optional<P> old = service.findById(id);
		if (old.isPresent()) {
			return ResponseEntity.ok(entityToModel.toSimple(old.get(), modelClass));
		}
		return  ResponseEntity.notFound().build();
	}


	@Override
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public E save(@Valid @RequestBody I input) {
		P entity = service.save(inputToEntity.toSimple(input, entityClass));
		return entityToModel.toSimple(entity, modelClass);
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<E> put(@PathVariable Long id, @Valid @RequestBody I input) {
		if (!service.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		input.setId(id);
		P entity = service.save(inputToEntity.toSimple(input, entityClass));
		return ResponseEntity.ok(entityToModel.toSimple(entity, modelClass));
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<E> delete(@PathVariable(value = "id") Long id) {
		if (!service.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
