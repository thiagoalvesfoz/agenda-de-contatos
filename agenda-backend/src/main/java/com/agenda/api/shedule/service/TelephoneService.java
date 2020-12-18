package com.agenda.api.shedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.api.shedule.domain.Telephone;
import com.agenda.api.shedule.domain.repository.TelephoneRepository;

@Service
public class TelephoneService {

	private TelephoneRepository telephoneRepository;
	

	@Autowired
	public TelephoneService(TelephoneRepository telephoneRepository) {
		this.telephoneRepository = telephoneRepository;
	}

	public Telephone save(Telephone telephone) {				
		return telephoneRepository.save(telephone);
	}

	public List<Telephone> findByIdContact(Long idContact) {
		return telephoneRepository.findByidContact(idContact);
	}

	
}
