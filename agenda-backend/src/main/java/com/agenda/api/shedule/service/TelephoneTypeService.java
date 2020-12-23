package com.agenda.api.shedule.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.api.shedule.domain.TelephoneType;
import com.agenda.api.shedule.domain.repository.TelephoneTypeRepository;

@Service
public class TelephoneTypeService {

	@Autowired
	private TelephoneTypeRepository repo;
	
	public TelephoneType save(TelephoneType telephoneType) {
		return repo.save(telephoneType);
	}

	public Optional<TelephoneType> findById(Long idTelephoneType) {
		return repo.findById(idTelephoneType);
	}
}
