package com.rang.api.entity.auth;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageResponseDTO 
{
	private String message;

	public MessageResponseDTO(String message) {
	    this.message = message;
	  }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
