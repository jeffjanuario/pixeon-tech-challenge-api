package com.pixeon.challenge.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Exam extends AbstractPojo{
	private static final long serialVersionUID = -5853394367351775730L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "id")
	private Long idExam;
	@ManyToOne
	private HealthcareInstitution healthcare;
	private String patientName;
	private String patientAge;
	private String patientGender;
	private String physicianName;
	private String physicianCrm;
	private String producereName;
	private Boolean accessFirst;

	@Override
	public Serializable getId() {
		return idExam;
	}

	@Override
	public void setId(Serializable id) {
		this.idExam = (Long) id;
	}
}