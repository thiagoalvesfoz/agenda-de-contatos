package com.agenda.api.shedule.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telephones")
public class Telephone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_telephone")
	private Long idTelephone;

	private String telephone;

	@ManyToOne
	@JoinColumn(name = "id_contact")
	private Contact contact;

	@ManyToOne
	@JoinColumn(name = "id_telephonetype")
	private TelephoneType TelephoneType;

	public Telephone() {
	}

	public Long getIdTelephone() {
		return idTelephone;
	}

	public void setIdTelephone(Long idTelephone) {
		this.idTelephone = idTelephone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public TelephoneType getTelephoneType() {
		return TelephoneType;
	}

	public void setTelephoneType(TelephoneType telephoneType) {
		TelephoneType = telephoneType;
	}

}
