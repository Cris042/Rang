package com.rang.api.entity.consultation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rang.api.entity.auth.MessageResponseDTO;
import com.rang.api.entity.doctor.Doctor;
import com.rang.api.entity.doctor.DoctorService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/consult")
public class ConsultationController 
{
 
    @Autowired
    ConsultationService consultService;
    
    @Autowired
    DoctorService doctorService;


    @PostMapping("/add")
    public ResponseEntity<?> add (@Valid @RequestBody ConsultationDTO consultationRequest)
    {
        if( consultService.existsByDate( consultationRequest.getCpf() , consultationRequest.getCrm(), consultationRequest.getDate(), consultationRequest.getTime() ) ) 
        {
           return ResponseEntity.badRequest().body(new MessageResponseDTO("Error: Date is already taken!"));
        }

        consultService.save(consultationRequest);

        return ResponseEntity.ok("Consulta Salva" );
    }

    @GetMapping("/list")
    public ResponseEntity<?> lsit (@PageableDefault(page = 0, size = 10, sort = "id") Pageable pageable) 
    {
        List<Consultation> consultationsAll = consultService.findAll();

       List<ConsultationResponseDTO> consultationsDTO = new ArrayList<>();

        for (Consultation consult : consultationsAll) 
        {
            Optional<Doctor> doctor = doctorService.findByCrm(consult.getCrm());

            final ConsultationResponseDTO consultDTO = new ConsultationResponseDTO
            ( 
                consult.getState() , consult.getDate(), 
                doctor.get().getUser().getUsername(), doctor.get().getSpecialty(), consult.getTime()
            );
            
            consultationsDTO.add(consultDTO);
        }

        return ResponseEntity.ok(consultationsDTO);

    }


    @GetMapping("/list/doc/{crm}")
    public ResponseEntity<?> lsitbyDoctor(@PathVariable(value = "crm") String crm, @PageableDefault(page = 0, size = 10, sort = "id") Pageable pageable) 
    {
        List<Consultation> consultationsAll = consultService.findAll();

        List<Consultation> consultations = consultationsAll.stream()
        .filter(consult -> crm.equals(consult.getCrm()))
        .collect(Collectors.toList());

        List<ConsultationResponseDTO> consultationsDTO = new ArrayList<>();

        for (Consultation consult : consultations) 
        {
            Optional<Doctor> doctor = doctorService.findByCrm(consult.getCrm());

            final ConsultationResponseDTO consultDTO = new ConsultationResponseDTO
            ( 
                consult.getState() , consult.getDate(), 
                doctor.get().getUser().getUsername(), doctor.get().getSpecialty(), consult.getTime()
            );
            
            consultationsDTO.add(consultDTO);
        }

        return ResponseEntity.ok(consultationsDTO);

    }

    @GetMapping("/list/{cpf}")
    public ResponseEntity<?> lsitbyPatient(@PathVariable(value = "cpf") String cpf, @PageableDefault(page = 0, size = 10, sort = "id") Pageable pageable) 
    {
        List<Consultation> consultationsAll = consultService.findAll();

        List<Consultation> consultations = consultationsAll.stream()
        .filter(consult -> cpf.equals(consult.getCpf()))
        .collect(Collectors.toList());

        List<ConsultationResponseDTO> consultationsDTO = new ArrayList<>();

        for (Consultation consult : consultations) 
        {
            Optional<Doctor> doctor = doctorService.findByCrm(consult.getCrm());

            final ConsultationResponseDTO consultDTO = new ConsultationResponseDTO
            ( 
                consult.getState() , consult.getDate(), 
                doctor.get().getUser().getUsername(), doctor.get().getSpecialty(), consult.getTime()
            );
            
            consultationsDTO.add(consultDTO);
        }

        return ResponseEntity.ok(consultationsDTO);
    }

    @PreAuthorize("hasRole('ADM')")
    @DeleteMapping("/delet")
    public ResponseEntity<?> delet(@PathVariable(value = "id") long id) 
    {

       return ResponseEntity.ok("Consulta Deletada" );
       
    }
}
