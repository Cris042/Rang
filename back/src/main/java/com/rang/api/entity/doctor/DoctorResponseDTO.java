package com.rang.api.entity.doctor;


import com.rang.api.entity.healthUnit.HealthUnit;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DoctorResponseDTO 
{
	private String username;
    private String crm;
	private HealthUnit healthUnit;
	private String specialty;

	public DoctorResponseDTO(String username, String crm, HealthUnit healthUnit, String specialty) 
	{
		this.username = username;
		this.crm = crm;
		this.healthUnit = healthUnit;
		this.specialty = specialty;	
	}
}
