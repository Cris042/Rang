package com.rang.api.entity.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserInfoResponseDTO 
{
	private long id;
	private String username;
	private Collection<? extends GrantedAuthority>  roles;

	public UserInfoResponseDTO(long id, String username, Collection<? extends GrantedAuthority> roles) 
	{
		this.id = id;
		this.username = username;
		this.roles = roles;
	}
}
