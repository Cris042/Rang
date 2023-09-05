package com.rang.api.entity.auth;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.rang.api.enums.ValidRole;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDTO 
{
	@NotNull( message = "O campo username e obrigatorio!")
    @NotBlank( message = "O campo username não pode ser nulo!")
    @Size(min = 3, max = 120, message ="O campo username deve ter entre 3 e 120 caractres")
    private String username;
    
    @NotNull( message = "O campo password e obrigatorio!")
    @NotBlank( message = "O campo password não pode ser nulo!")
    @Size(min = 3, max = 120, message ="O campo password deve ter entre 3 e 120 caractres")
    private String password;

    @NotNull( message = "O campo cpf e obrigatorio!")
    @NotBlank( message = "O campo cpf não pode ser nulo!")
    @Size(min = 14, max = 14, message = "O tamanho do campo cpf e de 14 caractres")
    private String cpf;

    @NotNull( message = "O campo role e obrigatorio!")
    @NotBlank( message = "O campo role não pode ser nulo!")
    @ValidRole( message = "Role invalida! Role validas : ROLE_ADM, ROLE_PATIENT, ROLE_DOC")
    private String role;

}
