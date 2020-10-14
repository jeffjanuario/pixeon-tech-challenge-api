package com.pixeon.challenge.api.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonRootName(value = "HealthcareInstitution")
public class HealthcareInstitutionModel extends BaseModel{
	private String name;
	private String cnpj;
	private BugdetResumModel bugdet;
}
