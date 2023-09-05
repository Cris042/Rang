package com.rang.api.entity.consultation;


import javax.persistence.*;
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
@Entity
@Table( name = "consultations")
public class Consultation
{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  @NotBlank
  @ValidStateConsultation
  private String state;

  @Column(nullable = true)
  @Size(min = 3, max = 244)
  private String description;

  @Column(nullable = true)
  @Size(min = 8, max = 20)
  private String crm;

  @Column(nullable = true)
  @Size(min = 14, max = 14)
  private String cpf;

  @Column(nullable = true)
  private String date;

  @Column(nullable = true)
  @Size(min = 1, max = 24)
  private String time;

  public Consultation
  (
	   String state, String date, 
     String crm, String cpf, String time
  ) 
  {
	   this.state = state;
     this.date = date;
     this.cpf = cpf;
     this.crm = crm;
     this.time = time;
  }

 

}
