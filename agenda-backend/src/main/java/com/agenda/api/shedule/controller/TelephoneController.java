package com.agenda.api.shedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.api.shedule.domain.Telephone;
import com.agenda.api.shedule.domain.repository.TelephoneRepository;

@RestController
@RequestMapping("/telephones")
public class TelephoneController {
	
	@Autowired
	private TelephoneRepository repo;	

	@GetMapping
	public ResponseEntity<List<Telephone>> index(){				
		return ResponseEntity.ok(repo.findAll());
	}
}
