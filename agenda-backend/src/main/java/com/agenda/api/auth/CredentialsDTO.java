package com.agenda.api.auth;

public class CredentialsDTO {
	
	private String email;
	
	private String password;
	
	private CredentialsDTO() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
