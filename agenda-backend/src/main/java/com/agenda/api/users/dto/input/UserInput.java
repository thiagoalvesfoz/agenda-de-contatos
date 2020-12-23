package com.agenda.api.users.dto.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.agenda.api.users.domain.User;

public class UserInput {
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String password;
	
	@NotBlank 
	private String passwordConfimation;
	
	public UserInput() {}

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
	
	
	public String getPasswordConfimation() {
		return passwordConfimation;
	}

	public void setPasswordConfimation(String passwordConfimation) {
		this.passwordConfimation = passwordConfimation;
	}

	public User toEntity() {
		User user = new User();
		
		user.setEmail(email);
		user.setPassword(password);
		
		return user;
	}
	
	public boolean passwordIsInvalid() {
		if(!this.password.equals(this.passwordConfimation))
			return true;
		
		return false;
	}
}
