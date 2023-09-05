package com.rang.api.entity.auth;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rang.api.entity.patient.PatientService;
import com.rang.api.security.jwt.JwtUtils;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController 
{
 
    @Autowired
    UserService userService;

    @Autowired
    PatientService patientService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody AuthRequestDTO loginRequest)
    {
        return userService.signin(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequestDTO signupRequest) 
    {
        if (userService.existsByUsername( signupRequest.getUsername()) ) 
        {
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error: Username is already taken!"));
        }

        if (patientService.existsByCpf( signupRequest.getCpf()) ) 
        {
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error: Cpf is already taken!"));
        }
       
        userService.signup(signupRequest, signupRequest.getRole() );
      
        return ResponseEntity.ok("Usuario Salvo" );

    }

    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() 
    {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
            .body(new MessageResponseDTO("You've been signed out!"));
    }
}
