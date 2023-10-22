package com.lucaslucenak.Shurima.controllers;

import com.lucaslucenak.Shurima.entities.AuthenticationNewSessionEntity;
import com.lucaslucenak.Shurima.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping(value = "/new-session")
    public ResponseEntity<AuthenticationNewSessionEntity> getNewSession() {
        return ResponseEntity.ok().body(authenticationService.getNewSession());
    }
}
