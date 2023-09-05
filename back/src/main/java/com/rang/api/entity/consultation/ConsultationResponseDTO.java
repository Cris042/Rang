package com.rang.api.entity.consultation;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ConsultationResponseDTO 
{
	private String state;
    private String date;
	private String doctor;
	private String specialty;
	private String time;

	public ConsultationResponseDTO(String state, String date, String doctor, String specialty, String time ) 
	{
		this.state = state;
		this.date = date;
		this.doctor = doctor;
		this.specialty = specialty;
		this.time = time;
	}
}
