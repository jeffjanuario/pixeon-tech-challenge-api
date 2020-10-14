package com.pixeon.challenge.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ConvertClassModel<T, E> {
	@Autowired
	private ModelMapper modelMapper;
	protected Class<E> convertClass;

	public E toSimple(T entity, Class<E> convertClass) {
		return (E) modelMapper.map(entity, convertClass);
	}
	
	public List<E> toCollection(List<T> list, Class<E> convertClass) {
		return list.stream()
		.map(entity -> toSimple(entity, convertClass))
		.collect(Collectors.toList());
	}

}
