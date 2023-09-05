package com.rang.api.entity.doctor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.rang.api.entity.auth.User;
import com.rang.api.entity.healthUnit.HealthUnit;
import com.rang.api.enums.ValidSpecialty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table
(
  name = "doctors",
  uniqueConstraints = 
  {
      @UniqueConstraint(columnNames = "crm")
  }
)
public class Doctor
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long id;

    @NotNull
    @NotBlank
    @ValidSpecialty
    private String specialty;

    @NotNull
    @NotBlank
    @Size(min = 8,max = 20)
    private String crm;

    @NotNull
    @ManyToOne
    private User user;

    @NotNull
    @ManyToOne
    private HealthUnit healthUnit;

    public Doctor( String crm, User user, String specialty, HealthUnit healthUnit) 
    {
      this.crm = crm;
      this.user = user;
      this.specialty = specialty;
      this.healthUnit = healthUnit;
    }

}
