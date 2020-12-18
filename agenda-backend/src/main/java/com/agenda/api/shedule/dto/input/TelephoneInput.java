package com.agenda.api.shedule.dto.input;

import javax.validation.constraints.NotBlank;

import com.agenda.api.shedule.domain.Telephone;
import com.agenda.api.shedule.domain.TelephoneType;

public class TelephoneInput {

	@NotBlank
	private String telephone;
	
	private TelephoneType type;
	
	public TelephoneInput() {}
	
	public TelephoneInput(String telephone, TelephoneType type) {
		this.telephone = telephone;
		this.type = type;
	}
	
	public TelephoneInput(Telephone telephone) {
		this.telephone = telephone.getTelephone();
		this.type = telephone.getTelephoneType();
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public TelephoneType getType() {
		return type;
	}

	public void setType(TelephoneType type) {
		this.type = type;
	}
	
	public Telephone toEntity() {
		Telephone tel = new Telephone();
		tel.setTelephone(telephone);
		tel.setTelephoneType(type);
		return tel;
	}
}
