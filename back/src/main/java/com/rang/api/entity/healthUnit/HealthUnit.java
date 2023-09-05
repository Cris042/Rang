package com.rang.api.entity.healthUnit;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table( name =  "health_units")
public class HealthUnit 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotBlank
    @Size(min = 3,max = 120)
    private String city;

    @NotNull
    @NotBlank
    @Size(min = 3,max = 120)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 3,max = 120)
    private String neighborhood;

    @NotNull
    @NotBlank
    @Size(min = 3,max = 120)
    private String street;

    public HealthUnit( String name, String city, String neighborhood, String street) 
    {
        this.name = name;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        
    }

}
