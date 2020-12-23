package com.agenda.api.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.agenda.api.auth.UserAuth;
import com.agenda.api.exceptions.AuthorizationException;
import com.agenda.api.exceptions.BusinessRuleException;
import com.agenda.api.exceptions.ResourceNotFoundException;
import com.agenda.api.users.domain.User;
import com.agenda.api.users.domain.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	public static UserAuth authenticated() {
		try {
			return (UserAuth)SecurityContextHolder.getContext().getAuthentication().getPrincipal();	
		}catch(Exception ex) {
			return null;
		}
	}
	

	public User register(User register) {
		
		this.validateUserEmail(register.getEmail());
		
		register.setPassword(bcrypt.encode(register.getPassword()));
		return repo.save(register);
	}

	
	private void validateUserEmail(String email) {
		repo
			.findByEmail(email)
			.ifPresent( x -> {
				throw new BusinessRuleException("Já existe um usuário cadastrado com este e-mail");
			});	
	}
	
	public User findUser(Long idUser) {
		UserAuth user = UserService.authenticated();
		if(user == null || !idUser.equals(user.getIdUser()))
			throw new AuthorizationException("Acesso negado");
		
		return repo
				.findById(idUser)
				.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
	}

	public Object whoami() {
		UserAuth user = UserService.authenticated();
		if(user == null)
			throw new ResourceNotFoundException("Não identificado");
		
		return user;
	}
	
}
