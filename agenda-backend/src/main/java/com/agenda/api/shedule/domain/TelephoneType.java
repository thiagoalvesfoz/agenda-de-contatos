package com.agenda.api.shedule.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "telephone_types")
public class TelephoneType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_telephonetype")
	private Long idTelephoneType;

	private String name;

	public TelephoneType() {
	}

	public Long getIdTelephoneType() {
		return idTelephoneType;
	}

	public void setIdTelephoneType(Long idTelephoneType) {
		this.idTelephoneType = idTelephoneType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TelephoneType [idTelephoneType=" + idTelephoneType + ", name=" + name + "]";
	}
	
	

}
