package com.pixeon.challenge.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pixeon.challenge.domain.model.AbstractPojo;
import com.pixeon.challenge.domain.service.BaseService;

public class BaseServiceImpl<T extends AbstractPojo> implements BaseService<T> {
	@Autowired
	private JpaRepository<T , Long> repository;

	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<T> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public T  save(T  entity) {
		return repository.save(entity);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return repository.existsById(id);
	}
}
