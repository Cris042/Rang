package com.rang.api.entity.patient;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> 
{
   Optional<Patient> findByCpf(String cpf);
   Boolean existsByCpf(String cpf);
   Optional<Patient> findById(long id);
}
