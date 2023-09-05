package com.rang.api.entity.consultation;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IConsultationRepository extends JpaRepository<Consultation, Long> 
{
    Optional<Consultation> findById(long id); 
    Boolean existsByCpf(String cpf);
    Boolean existsByCrm(String crm);
    Boolean existsByDate(String date);
    Boolean existsByTime(String time);
}
