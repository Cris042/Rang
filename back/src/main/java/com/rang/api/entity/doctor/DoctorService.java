package com.rang.api.entity.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rang.api.entity.auth.IUserRepository;
import com.rang.api.entity.auth.User;
import com.rang.api.entity.healthUnit.HealthUnit;
import com.rang.api.entity.healthUnit.IHealthUnitRepository;
import com.rang.api.entity.roles.IRoleRepository;
import com.rang.api.entity.roles.Roles;

import javax.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService 
{
    @Autowired
    IDoctorRepository doctorRepository;

    @Autowired
    IRoleRepository roleRepository;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IHealthUnitRepository healthUnitRepository;

    @Autowired
    PasswordEncoder encoder;
    
    @Transactional
    public void save(DoctorDTO doctorRequest, String roleName) 
    {
        Optional<Roles> roles = roleRepository.findByName(roleName);
        Roles role = roles.get();
        Optional<HealthUnit>  healthUnit = healthUnitRepository.findById( doctorRequest.getHealthUnit() );

        User user = new User
        (
            doctorRequest.getUsername(),
            encoder.encode(doctorRequest.getPassword()),
            role,
            true,
            LocalDate.now()
        );

        userRepository.save(user);

        Doctor doctor = new Doctor
        (
            doctorRequest.getCrm(),
            user,
            doctorRequest.getSpecialty(),
            healthUnit.get()
        );

        doctorRepository.save( doctor );
       
    }

    public Optional<Doctor> findById(long id) 
    {
        return doctorRepository.findById(id);
    }

    public Boolean existsByCrm(String crm) 
    {
        return doctorRepository.existsByCrm(crm);
    }

    public List<Doctor> findAll()
    {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> findByCrm( String crm ) 
    {
       return doctorRepository.findByCrm(crm);
    }


}
