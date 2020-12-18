package com.agenda.api.shedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.api.auth.UserAuth;
import com.agenda.api.exceptions.AuthorizationException;
import com.agenda.api.shedule.domain.Email;
import com.agenda.api.shedule.domain.Telephone;
import com.agenda.api.shedule.domain.repository.ContactRepository;
import com.agenda.api.shedule.dto.input.ContactDTO;
import com.agenda.api.shedule.dto.input.ContactInput;
import com.agenda.api.users.service.UserService;

@Service
public class ContactService {

	private ContactRepository repo;
	private EmailService emailService;
	private TelephoneService telephoneService;
	private TelephoneTypeService telephoneTypeService;

	@Autowired
	public ContactService(ContactRepository repo, EmailService emailService, TelephoneService telephoneService,
			TelephoneTypeService telephoneTypeService) {
		this.repo = repo;
		this.emailService = emailService;
		this.telephoneService = telephoneService;
		this.telephoneTypeService = telephoneTypeService;
	}

	public ContactDTO save(ContactInput contact) {

		this.validateUserAuth(contact.getIdUser());

		var contactSaved = repo.save(contact.toEntity());

		contact.getEmails().stream().forEach(email -> emailService.save(email.toEntity(), contactSaved.getIdContact()));

		contact.getTelephones().stream().forEach(telephone -> {
			var tel = telephone.toEntity();
			
			var idType = tel.getTelephoneType().getIdTelephoneType();
			
			if(idType != null) {
				var type = telephoneTypeService.findById(idType).get();
				tel.setTelephoneType(type);
			} else {
				var type = telephoneTypeService.save(tel.getTelephoneType());
				tel.setTelephoneType(type);
			}
			
			tel.setContact(contactSaved);
			telephoneService.save(tel);
		});

		List<Email> emails = findEmailsByContact(contactSaved.getIdContact());
		List<Telephone> telephones = findTelephonesByContact(contactSaved.getIdContact());
		return new ContactDTO(contactSaved, emails, telephones);
	}

	private List<Email> findEmailsByContact(Long idContact) {
		return emailService.findByIdContact(idContact);
	}

	private List<Telephone> findTelephonesByContact(Long idContact) {
		return telephoneService.findByIdContact(idContact);
	}

	private void validateUserAuth(Long idUser) {
		UserAuth user = UserService.authenticated();
		if (user == null || !idUser.equals(user.getIdUser()))
			throw new AuthorizationException("Acesso negado");
	}

}
