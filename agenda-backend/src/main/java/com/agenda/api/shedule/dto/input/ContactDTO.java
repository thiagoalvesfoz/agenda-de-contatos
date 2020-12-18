package com.agenda.api.shedule.dto.input;

import java.util.ArrayList;
import java.util.List;

import com.agenda.api.shedule.domain.Contact;
import com.agenda.api.shedule.domain.Email;
import com.agenda.api.shedule.domain.Telephone;

public class ContactDTO {

	private Long idUser;
	private String name;
	private List<EmailInput> emails = new ArrayList<>();
	private List<TelephoneInput> telephones = new ArrayList<>();
	
	public ContactDTO() {}
	
	public ContactDTO(Contact contact, List<Email> emails) {
		this.idUser = contact.getUser().getIdUser();
		this.name = contact.getName();
		
		for(Email email : emails) {
			this.emails.add(new EmailInput(email));
		}
	}
	
	public ContactDTO(Contact contact, List<Email> emails, List<Telephone> telephones) {
		this.idUser = contact.getUser().getIdUser();
		this.name = contact.getName();
		
		for(Email email : emails) {
			this.emails.add(new EmailInput(email));
		}
		
		for(Telephone tel : telephones) {
			this.telephones.add(new TelephoneInput(tel));
		}
	}
	
	public ContactDTO(Contact contact) {
		this.idUser = contact.getUser().getIdUser();
		this.name = contact.getName();
	}
	
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
}
