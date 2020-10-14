package com.pixeon.challenge.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExamInput extends BaseInput{	
	@NotBlank
	private String patientName;
	@NotBlank
	private String patientAge;
	@NotBlank
	private String patientGender;
	@NotBlank
	private String physicianName;
	@NotBlank
	private String physicianCrm;
	@NotBlank
	private String producereName;
}
