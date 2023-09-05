package com.rang.api.entity.healthUnit;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class HealthUnitDTO extends RepresentationModel<HealthUnitDTO>
{

    @NotNull( message = "O campo city e obrigatorio!")
    @NotBlank( message = "O campo city não pode ser nulo!")
    @Size(min = 3,max = 120,  message = "O campo city deve ter entre 3 e 120 caractres")
    private String city;

    @NotNull( message = "O campo name e obrigatorio!")
    @NotBlank( message = "O campo name não pode ser nulo!")
    @Size(min = 3,max = 120,  message = "O campo name deve ter entre 3 e 120 caractres")
    private String name;

    @NotNull( message = "O campo neighborhood e obrigatorio!")
    @NotBlank( message = "O campo neighborhood não pode ser nulo!")
    @Size(min = 3,max = 120,  message = "O campo neighborhood deve ter entre 3 e 120 caractres")
    private String neighborhood;

    @NotNull( message = "O campo street e obrigatorio!")
    @NotBlank( message = "O campo street não pode ser nulo!")
    @Size(min = 3,max = 120,  message = "O campo street deve ter entre 3 e 120 caractres")
    private String street;

    public HealthUnitDTO( String name, String city, String neighborhood, String street ) 
    {
        this.name = name;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        
    }
}
