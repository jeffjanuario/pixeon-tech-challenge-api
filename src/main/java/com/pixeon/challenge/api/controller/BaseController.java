package com.pixeon.challenge.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pixeon.challenge.api.model.BaseModel;
import com.pixeon.challenge.api.model.input.BaseInput;
import com.pixeon.challenge.domain.model.AbstractPojo;

public interface BaseController<P extends AbstractPojo, I extends BaseInput,  E extends BaseModel> {
	List<E> findAll();

	ResponseEntity<E> findById(Long id);

	E save(I input);

	ResponseEntity<E> put(Long id, I input);

	ResponseEntity<E> delete(Long id);
}
