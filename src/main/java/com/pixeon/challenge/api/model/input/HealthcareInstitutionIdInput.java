package com.pixeon.challenge.api.model.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HealthcareInstitutionIdInput extends BaseInput{
	@NotNull
	@Override
	public Long getId() {
		return super.getId();
	}
}
