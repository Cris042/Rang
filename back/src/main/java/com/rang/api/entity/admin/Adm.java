package com.rang.api.entity.admin;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.rang.api.entity.auth.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table
public class Adm
{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne
  @NotNull
  private User user;

  public Adm( User user ) 
  {
    this.user = user;
  }

}
