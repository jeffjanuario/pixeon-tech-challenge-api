package com.pixeon.challenge.domain.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class AbstractPojo implements Serializable {
	private static final long serialVersionUID = 8060573592387963153L;
	public abstract Serializable getId();
	public abstract void setId(Serializable id);
}
