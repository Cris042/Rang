package com.rang.api.entity.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import com.rang.api.entity.patient.PatientService;
import com.rang.api.entity.roles.IRoleRepository;
import com.rang.api.entity.roles.Roles;
import com.rang.api.security.jwt.JwtUtils;
import com.rang.api.security.services.UserDetailsImpl;

import javax.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService 
{
    @Autowired
    IUserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PatientService patientService;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    IRoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    
    @Transactional
    public User save(User user) 
    {
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) 
    {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findById(long id) 
    {
        return userRepository.findById(id);
    }

    public Boolean existsByUsername(String username)
    {
        return userRepository.existsByUsername(username);
    }

    @Transactional
    public void delete(User user) 
    {
        userRepository.delete(user);
    }

    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    public void deleteAll(List<User> user)
    {
        List<User> allUser = userRepository.findAll();
        userRepository.deleteAll( allUser);
    }

    public String getRoles( User user )
    {
        return user.getRole().getName();
    }
    
    public ResponseEntity<?> signin( AuthRequestDTO loginRequest )
    {
        Authentication authentication = authenticationManager
          .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
        
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
            .body(  new UserInfoResponseDTO(  userDetails.getId(),userDetails.getUsername(), userDetails.getAuthorities() ) );

    }

    @Transactional
    public void signup(SignupRequestDTO signUpRequest, String roleName) 
    {
        Optional<Roles> roles = roleRepository.findByName(roleName);

        User user = new User(
            signUpRequest.getUsername(),
            encoder.encode(signUpRequest.getPassword()),
            roles.get(),
            true,
            LocalDate.now()
        );

        userRepository.save(user);

        if( roleName == "ROLE_PATIENT")
        {
            patientService.save(user, signUpRequest);
        }
      
        
    }


}
