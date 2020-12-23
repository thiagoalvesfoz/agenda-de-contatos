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
@Table(name="emails")
public class Email {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_email")
	private Long idEmail;
	private String email;
	
	@ManyToOne
	@JoinColumn(name="id_contact")
	private Contact contact;
	
	public Email() {}
	
	public Email(String email) {
		this.email = email;
	}
	
	public Long getIdEmail() {
		return idEmail;
	}
	public void setIdEmail(Long idEmail) {
		this.idEmail = idEmail;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
}
