package com.rang.api.entity.consultation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.rang.api.enums.ValidStateConsultation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ConsultationDTO 
{

  @NotNull( message = "O campo state e obrigatorio!" )
  @NotBlank( message = "O campo state não pode ser nulo!")
  @ValidStateConsultation( message = "state Invalido! state validos : Aceita, Cancelada, Realizada, Solicitada")
  private String state;

  @Size(min = 3, max = 244, message ="O campo description deve ter entre 3 e 244 caractres")
  private String description;

  @NotNull( message = "O campo crm e obrigatorio!")
  @NotBlank( message = "O campo crm não pode ser nulo!")
  @Size(min = 8,max = 20,  message = "O campo crm deve ter entre 8 e 20 caractres")
  private String crm;

  @NotNull( message = "O campo cpf e obrigatorio!")
  @NotBlank( message = "O campo cpf não pode ser nulo!")
  @Size(min = 14, max = 14, message = "O tamanho e de 14 caractres")
  private String cpf;

  @NotNull( message = "O campo data e obrigatorio!")
  private String date;

  @NotNull( message = "O campo time e obrigatorio!")
@Size(min = 3, max = 24, message =  "O formato do cmapo time esta errado")
  private String time;

  public ConsultationDTO
  (
     String state, String date, 
     String crm, String cpf, String time
  ) 
  {
     this.state = state;
     this.date = date;
     this.cpf = cpf;
     this.time = time;
     this.crm = crm;
  }
}
