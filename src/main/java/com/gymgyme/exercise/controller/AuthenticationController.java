package com.gymgyme.exercise.controller;

import com.gymgyme.exercise.model.ApplicationUser;
import com.gymgyme.exercise.model.LoginResponseDTO;
import com.gymgyme.exercise.model.RegistrationDTO;
import com.gymgyme.exercise.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body) {
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body) {
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }

    @GetMapping("/user")
    public ApplicationUser currentUser() {
        return authenticationService.currentUser();
    }

}
