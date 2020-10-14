package com.pixeon.challenge.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class HealthcareInstitution extends AbstractPojo{

	private static final long serialVersionUID = 4473322544295694300L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "id")
	private Long idHealthcare;
	private String name;
	private String cnpj;
	@OneToOne
	private Bugdet bugdet;
	
	
	@Override
	public Serializable getId() {
		return idHealthcare;
	}

	@Override
	public void setId(Serializable id) {
		this.idHealthcare = (Long) id;
	}
	
	
}