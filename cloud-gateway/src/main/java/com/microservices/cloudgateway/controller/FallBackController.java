package com.microservices.cloudgateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallBackController {
    @GetMapping("/retailBankFallback")
    public ResponseEntity<String> retailBankFallBack(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("We are facing a problem. Please contact helpdesk");
    }
    @GetMapping("/departmentserviceFallback")
    public ResponseEntity<String> departmentFallBack(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("We are facing a problem in department fallback. Please contact helpdesk");
    }
    @GetMapping("/identityservicefallback")
    public ResponseEntity<String> identityservicefallback(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("We are facing a problem in identity fallback. Please contact helpdesk");
    }
}
