package com.rang.api.entity.roles;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table( name = "roles")
public class Roles 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;


    public Roles( String name, long id )
    {  
        this.id = id;
        this.name = name;
    }

}