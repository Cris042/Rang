package com.rang.api.entity.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.rang.api.entity.roles.Roles;

import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table( name = "users")
public class User 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 3, max = 120)
    private String username;

    @NotBlank
    @Size(min = 3, max = 120)
    private String password;

    @ManyToOne
    @NotNull
    private Roles role;

    @NotNull
    private boolean state;

    @NotNull
    private LocalDate date;

    public User( String username, String password, Roles role, Boolean state, LocalDate date ) 
    {
        this.username = username;
        this.password = password;
        this.role = role;
        this.state = state;
        this.date = date;
    }
}
