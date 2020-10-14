package com.pixeon.challenge.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pixeon.challenge.api.controller.ConvertClassModel;

@Configuration
public class ConvertClassModelConfig<T, E> {
	
	@Bean
	public ConvertClassModel<T, E> convertClassModel() {
		return new ConvertClassModel<T, E>();
	}
	
}
