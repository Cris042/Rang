package com.rang.api.entity.consultation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultationService 
{
    @Autowired
    IConsultationRepository consultationRepository;
    
    @Transactional
    public void save(ConsultationDTO consultationRequest) 
    {

        Consultation consult = new Consultation
        (
            consultationRequest.getState(),
            consultationRequest.getDate(),
            consultationRequest.getCrm(),
            consultationRequest.getCpf(),
            consultationRequest.getTime()

        );

        consult.setDescription( consultationRequest.getState() + "  " + consultationRequest.getDate() );

        consultationRepository.save( consult );
    }

    public Optional<Consultation> findById(long id) 
    {
        return consultationRepository.findById(id);
    }

    public boolean existsByDate( String cpf, String crm, String date, String time) 
    {

        return ( consultationRepository.existsByCpf(cpf) || consultationRepository.existsByCrm(crm) ) && 
               consultationRepository.existsByDate( date ) && consultationRepository.existsByTime( time );
    }

    @Transactional
    public void delete(Consultation consultationModel) 
    {
        consultationRepository.delete(consultationModel);
    }

    public List<Consultation> findAll()
    {
        return consultationRepository.findAll();
    }


}
