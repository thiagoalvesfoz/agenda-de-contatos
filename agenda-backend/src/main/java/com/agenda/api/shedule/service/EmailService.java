package com.agenda.api.shedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.api.shedule.domain.Contact;
import com.agenda.api.shedule.domain.Email;
import com.agenda.api.shedule.domain.repository.EmailRepository;

@Service
public class EmailService {

	private EmailRepository emailRepository;
	

	@Autowired
	public EmailService(EmailRepository emailRepository) {
		this.emailRepository = emailRepository;
	}

	public Email save(Email email, Long idContact) {
		
		email.setContact(new Contact(idContact));;
		
		return emailRepository.save(email);
	}

	public List<Email> findByIdContact(Long idContact) {
		return emailRepository.findByidContact(idContact);
	}	
}
