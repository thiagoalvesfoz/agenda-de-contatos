package com.agenda.api.shedule.dto.input;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.agenda.api.shedule.domain.Contact;
import com.agenda.api.users.domain.User;

public class ContactInput {

	@NotBlank
	private String name;
	
	@NotNull
	private Long idUser;
	
	@Valid
	private List<EmailInput> emails;
	
	private List<TelephoneInput> telephones;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	
	
	public List<EmailInput> getEmails() {
		return emails;
	}
	

	public void setEmails(List<EmailInput> emails) {
		this.emails = emails;
	}

	
	public List<TelephoneInput> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<TelephoneInput> telephones) {
		this.telephones = telephones;
	}

	public Contact toEntity() {
		Contact contact = new Contact();
		contact.setName(name);
		contact.setUser(new User());
		contact.getUser().setIdUser(idUser);
		
		return contact;
	}	
}
