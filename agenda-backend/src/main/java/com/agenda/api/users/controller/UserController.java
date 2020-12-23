package com.agenda.api.users.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.api.exceptions.BusinessRuleException;
import com.agenda.api.users.domain.User;
import com.agenda.api.users.domain.repository.UserRepository;
import com.agenda.api.users.dto.input.UserInput;
import com.agenda.api.users.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> index() {		
		return ResponseEntity.ok(repo.findAll());
	}
	
	@GetMapping("/{idUser}")
	public ResponseEntity<User> find(@PathVariable Long idUser){
		return ResponseEntity.ok(service.findUser(idUser));
	}
	
	@GetMapping("/whoami")
	public ResponseEntity<Object> find(){
		return ResponseEntity.ok(service.whoami());
	}
	
	@PostMapping
	public ResponseEntity<User> registration(@Valid @RequestBody UserInput user) {
			
		if(user.passwordIsInvalid())
			throw new BusinessRuleException("As senhas não concidem, tente novamente");
		
		User newUser = service.register(user.toEntity());		 
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(newUser);
	}
}
