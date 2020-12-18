package com.agenda.api.shedule.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.agenda.api.shedule.domain.Telephone;

@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, Long>{

	@Query("SELECT obj FROM Telephone obj WHERE obj.contact.idContact = ?1")
	List<Telephone> findByidContact(Long idContact);

}
