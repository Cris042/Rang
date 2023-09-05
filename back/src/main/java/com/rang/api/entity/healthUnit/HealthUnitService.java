package com.rang.api.entity.healthUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import com.rang.api.entity.doctor.Doctor;
import com.rang.api.entity.doctor.DoctorController;
import com.rang.api.entity.doctor.DoctorService;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class HealthUnitService 
{
    @Autowired
    IHealthUnitRepository healthUnitRepository;

    @Autowired
    DoctorService doctorService;
    
    @Transactional
    public HealthUnit save(HealthUnitDTO healthUnitDTO) 
    {
        HealthUnit healthUnit = new HealthUnit
        (
            healthUnitDTO.getName(),
            healthUnitDTO.getCity(),
            healthUnitDTO.getNeighborhood(),
            healthUnitDTO.getStreet()
        );

        return healthUnitRepository.save( healthUnit );
    }

    public Optional<HealthUnit> findById(long id) 
    {
        return healthUnitRepository.findById(id);
    }


    public Boolean existsByName(String name) 
    {
        return healthUnitRepository.existsByName( name );
    }

    public List<HealthUnit> findAll()
    {
        return healthUnitRepository.findAll();
    }
 
    public List<HealthUnitDTO> findAllFormatted()
    {
        List<HealthUnit> healthUnit = healthUnitRepository.findAll();

        List<HealthUnitDTO> healthUnitAll = new ArrayList<>();

        List<Doctor> doctors = doctorService.findAll();

        for(HealthUnit unit : healthUnit) 
        {        
            HealthUnitDTO unitDTO = new HealthUnitDTO( unit.getName(), unit.getCity(), unit.getNeighborhood(), unit.getStreet());

            List<Doctor> docsUnit = doctors.stream()
            .filter(doc -> unit.getId() == doc.getHealthUnit().getId())
            .collect(Collectors.toList());

            for (Doctor doc : docsUnit) 
            {
                unitDTO.add( WebMvcLinkBuilder.linkTo
                (
                    WebMvcLinkBuilder.methodOn( DoctorController.class ).lsitById( doc.getId() ) )
                    .withRel("Doctor") 
                );
            }
               
      
            healthUnitAll.add(unitDTO);       
        }

        return healthUnitAll;
    }



}
