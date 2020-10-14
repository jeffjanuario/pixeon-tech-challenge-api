package com.pixeon.challenge.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Bugdet extends AbstractPojo{
	private static final long serialVersionUID = -6516676128505344230L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "id")
	private Long idBugdet;
	private BigDecimal coin;
	private String description;
	
	@Override
	public Serializable getId() {
		return idBugdet;
	}

	@Override
	public void setId(Serializable id) {
		this.idBugdet = (Long) id;
	}
}