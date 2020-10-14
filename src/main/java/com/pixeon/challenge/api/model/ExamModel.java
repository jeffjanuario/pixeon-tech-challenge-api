package com.pixeon.challenge.api.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonRootName(value = "Exam")
public class ExamModel extends BaseModel{
	private HealthcareInstitutionResumModel healthcare;
	private String patientName;
	private String patientAge;
	private String patientGender;
	private String physicianName;
	private String physicianCrm;
	private String producereName;

}
