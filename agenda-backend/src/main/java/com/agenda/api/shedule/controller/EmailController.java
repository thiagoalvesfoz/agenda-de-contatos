package com.agenda.api.shedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.api.shedule.domain.Email;
import com.agenda.api.shedule.domain.repository.EmailRepository;

@RestController
@RequestMapping("/emails")
public class EmailController {
	
	@Autowired
	private EmailRepository repo;
	

	@GetMapping
	public ResponseEntity<List<Email>> index(){				
		return ResponseEntity.ok(repo.findAll());
	}
	
	@GetMapping("/{idContact}")
	public ResponseEntity<List<Email>> find(@PathVariable Long idContact){				
		return ResponseEntity.ok(repo.findByidContact(idContact));
	}
}
