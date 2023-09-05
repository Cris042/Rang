package com.rang.api.entity.healthUnit;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rang.api.entity.auth.MessageResponseDTO;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/unit")
public class HealthUnitController 
{
 
    @Autowired
    HealthUnitService healthUnitService;

    @PreAuthorize("hasRole('ADM')")
    @PostMapping("/add")
    public ResponseEntity<?> add (@Valid @RequestBody HealthUnitDTO healthUnitDTO )
    {
        if (  healthUnitService.existsByName( healthUnitDTO.getName()) ) 
        {
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error: Name is already taken!"));
        }

        healthUnitService.save( healthUnitDTO );

        return ResponseEntity.ok("Unidade Salva" );
    }

    @GetMapping("/list")
    public ResponseEntity<?> lsit (@PageableDefault(page = 0, size = 10, sort = "id") Pageable pageable) 
    {
        List<HealthUnitDTO> healthUnitAll = healthUnitService.findAllFormatted();

        return ResponseEntity.ok( healthUnitAll );
    }

    @GetMapping("/list/{city}")
    public ResponseEntity<?> lsitbyCity (@PathVariable(value = "city") String city, @PageableDefault(page = 0, size = 10, sort = "id") Pageable pageable ) 
    {
       List<HealthUnitDTO> healthUnitAll = healthUnitService.findAllFormatted();

       List<HealthUnitDTO> healthUnitList = healthUnitAll.stream()
        .filter(unit -> city.equals(unit.getCity()))
        .collect(Collectors.toList());

        return ResponseEntity.ok( healthUnitList );
    }

}
