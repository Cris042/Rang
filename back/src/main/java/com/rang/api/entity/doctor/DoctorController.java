package com.rang.api.entity.doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
@RequestMapping("/api/doctor")
public class DoctorController 
{
 
    @Autowired
    DoctorService doctorService;

    @PreAuthorize("hasRole('ADM')")
    @PostMapping("/add")
    public ResponseEntity<?> add (@Valid @RequestBody DoctorDTO doctorRequest)
    {
        if ( doctorService.existsByCrm( doctorRequest.getCrm() ) ) 
        {
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error: Username is already taken!"));
        }

        doctorService.save(doctorRequest, "ROLE_DOC");

        return ResponseEntity.ok("Usuario Salvo" );
    }

    @GetMapping("/list")
    public ResponseEntity<?> lsit (@PageableDefault(page = 0, size = 10, sort = "id") Pageable pageable) 
    {
        List<Doctor> doctors = doctorService.findAll();
        List<DoctorResponseDTO > doctorsDTO = new ArrayList<>();

        for (Doctor doctor : doctors) 
        {
            DoctorResponseDTO doctorDTO = new DoctorResponseDTO( doctor.getUser().getUsername(), doctor.getCrm() , doctor.getHealthUnit(), doctor.getSpecialty() );
            
            doctorsDTO.add(doctorDTO);
        }

        return ResponseEntity.ok( doctorsDTO );
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> lsitById(@PathVariable(value = "id") long id) 
    {
        Optional<Doctor> doctorAux = doctorService.findById(id);
    
        if (!doctorAux.isPresent()) {
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error: Doctor not found!"));
        }
    
        Doctor doctor = doctorAux.get();
       
        DoctorResponseDTO doctorDTO = new DoctorResponseDTO(doctor.getUser().getUsername(), doctor.getCrm(), doctor.getHealthUnit(), doctor.getSpecialty());
          
        return ResponseEntity.ok(doctorDTO);
    }
    
}
