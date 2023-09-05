package com.rang.api.entity.doctor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Long> 
{

    Optional<Doctor> findByCrm(String crm);
    Optional<Doctor> findById(long id);
    Boolean existsByCrm(String username);
 
}
