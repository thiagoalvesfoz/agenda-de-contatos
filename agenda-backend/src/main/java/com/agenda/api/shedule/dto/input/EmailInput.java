package com.agenda.api.shedule.dto.input;

import javax.validation.constraints.NotBlank;

import com.agenda.api.shedule.domain.Email;

public class EmailInput {

	private Long idEmail;
	
	@NotBlank
	private String email;

	public EmailInput() {}
	
	public EmailInput(String email) {
		this.email = email;
	}
	
	public EmailInput(Email email) {
		this.email = email.getEmail();
		this.idEmail = email.getIdEmail();
	}

	public Long getIdEmail() {
		return idEmail;
	}

	public void setIdEmail(Long id) {
		this.idEmail = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Email toEntity() {
		Email email = new Email();
		email.setEmail(this.email);
		return email;
	}
}
