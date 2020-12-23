package com.agenda.api.shedule.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.agenda.api.shedule.domain.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long>{

	@Query("SELECT obj FROM Email obj WHERE obj.contact.idContact = ?1")
	List<Email> findByidContact(Long idContact);
}
