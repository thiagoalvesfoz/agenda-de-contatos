package com.agenda.api.shedule.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.api.shedule.domain.Contact;
import com.agenda.api.shedule.domain.repository.ContactRepository;
import com.agenda.api.shedule.dto.input.ContactDTO;
import com.agenda.api.shedule.dto.input.ContactInput;
import com.agenda.api.shedule.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactController {
	
	@Autowired
	private ContactRepository repo;
	
	@Autowired
	private ContactService service;

	@GetMapping
	public ResponseEntity<List<Contact>> index(){				
		return ResponseEntity.ok(repo.findAll());
	}
	
	@PostMapping
	public ResponseEntity<ContactDTO> save(@RequestBody @Valid ContactInput newContact){
		
		var contact = service.save(newContact);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(contact);
		
	}
}
