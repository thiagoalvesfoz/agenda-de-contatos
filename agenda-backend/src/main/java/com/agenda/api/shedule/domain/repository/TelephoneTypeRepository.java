package com.agenda.api.shedule.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenda.api.shedule.domain.TelephoneType;

@Repository
public interface TelephoneTypeRepository extends JpaRepository<TelephoneType, Long>{

}
