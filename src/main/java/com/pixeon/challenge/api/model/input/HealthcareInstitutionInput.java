package com.pixeon.challenge.api.model.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HealthcareInstitutionInput extends BaseInput{
	@NotBlank
	@Size(max = 60)
	private String name;
	@NotBlank
	@CNPJ
	@Size(max = 14)
	private String cnpj;
}
