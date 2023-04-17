package com.microservice.identityservice.service;

import com.microservice.identityservice.entity.UserCredential;
import com.microservice.identityservice.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

   @Autowired
    private UserCredentialRepository userCredentialRepository;
   @Autowired
   private PasswordEncoder passwordEncoder;

   @Autowired
   private JwtService jwtService;

   public String saveUser(UserCredential userCredential){
       userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
       userCredentialRepository.save(userCredential);
       return "user added to the repository";
   }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
