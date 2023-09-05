package com.rang.api.entity.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rang.api.entity.auth.SignupRequestDTO;
import com.rang.api.entity.auth.User;


import java.util.List;
import java.util.Optional;

@Service
public class PatientService 
{
    @Autowired
    IPatientRepository patientRepository;

    public void save(User user, SignupRequestDTO signUpRequest) 
    {      
        Patient patient = new Patient(signUpRequest.getCpf(), user);
        patientRepository.save(patient);
    }
    
    public Optional<Patient> findById(long id) 
    {
        return patientRepository.findById(id);
    }

    public Boolean existsByCpf(String cpf)
    {
        return patientRepository.existsByCpf( cpf );
    }

    public List<Patient> findAll()
    {
        return patientRepository.findAll();
    }


}
