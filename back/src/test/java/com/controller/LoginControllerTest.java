package com.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rang.api.entity.auth.AuthController;
import com.rang.api.entity.auth.AuthRequestDTO;
import com.rang.api.entity.auth.UserService;
import com.rang.api.entity.roles.IRoleRepository;
import com.rang.api.security.jwt.JwtUtils;
import com.rang.api.security.services.UserDetailsImpl;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class LoginControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private UserService userService;

    @Mock
    private PasswordEncoder encoder;

    @Mock
    private JwtUtils jwtUtils;

    @InjectMocks
    private AuthController authController;

    @Autowired
    IRoleRepository roleRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAuthenticateUser() {
        AuthRequestDTO loginRequest = new AuthRequestDTO();
        loginRequest.setUsername("test@example.com");
        loginRequest.setPassword("password");

        Authentication authentication = mock(Authentication.class);
        when(authenticationManager.authenticate(any())).thenReturn(authentication);

        UserDetailsImpl userDetails = mock(UserDetailsImpl.class);
        when(authentication.getPrincipal()).thenReturn(userDetails);
        when(jwtUtils.generateJwtCookie(userDetails)).thenReturn(ResponseCookie.from("jwtCookie", "jwtValue").build());
        when(userDetails.getAuthorities()).thenReturn(Collections.emptyList());

        ResponseEntity<?> response = authController.authenticateUser(loginRequest);
        assertEquals("jwtCookie=jwtValue", response.getHeaders().getFirst(HttpHeaders.SET_COOKIE));
        assertEquals(200, response.getStatusCodeValue());
    }

  
}