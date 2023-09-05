package com.rang.api.entity.doctor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.rang.api.enums.ValidSpecialty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class DoctorDTO 
{
    @NotNull( message = "O campo username e obrigatorio!")
    @NotBlank( message = "O campo username não pode ser nulo!")
    @Size(min = 3, max = 120, message ="O campo username deve ter entre 3 e 120 caractres")
    private String username;
    
    @NotNull( message = "O campo password e obrigatorio!")
    @NotBlank( message = "O campo password não pode ser nulo!")
    @Size(min = 3, max = 120, message ="O campo password deve ter entre 3 e 120 caractres")
    private String password;

    @NotNull( message = "O campo specialty não pode ser nulo!")
    @NotBlank( message = "O campo specialty e obrigatorio!")
    @ValidSpecialty(message = "Especialidade invalida! Especialidade validas : Clínico geral, Dermatologista ou Cardiologista")
	  private String specialty;

    @NotNull( message = "O campo crm não pode ser nulo!")
    @NotBlank( message = "O campo crm e obrigatorio!")
    @Size(min = 8,max = 20,  message = "O campo crm deve ter entre 8 e 20 caractres")
    private String crm;
    
    @NotNull( message = "O campo healthUnit não pode ser nulo!")
    private long healthUnit;

    public DoctorDTO( String username, String password, String crm, String specialty, long healthUnit ) 
    {
      this.username = username;
      this.password = password;
      this.crm = crm;
      this.specialty = specialty;
      this.healthUnit = healthUnit;
    }

}
