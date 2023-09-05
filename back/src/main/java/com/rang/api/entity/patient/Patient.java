package com.rang.api.entity.patient;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.rang.api.entity.auth.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table
(
    name = "patients",
    uniqueConstraints = 
    {
       @UniqueConstraint(columnNames = "cpf")
    }
)
public class Patient
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @NotNull
    @Size( max = 14, min = 14)
    private String cpf;

    @ManyToOne
    @NotNull
    private User user;

    public Patient ( String cpf, User user ) 
    {
      this.cpf = cpf;
      this.user = user;
    }

}
