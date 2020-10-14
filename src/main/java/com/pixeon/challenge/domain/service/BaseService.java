package com.pixeon.challenge.domain.service;

import java.util.List;
import java.util.Optional;

import com.pixeon.challenge.domain.model.AbstractPojo;


public interface BaseService<T extends AbstractPojo> {
	List<T>  findAll();

	Optional<T> findById(Long id);

	T save(T entity);
	
	void deleteById(Long id);

	boolean existsById(Long id);


}
