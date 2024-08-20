package com.pierrette.api.controllers;

import com.pierrette.api.requests.LoginRequest;
import com.pierrette.api.requests.SignUp;
import com.pierrette.api.response.AuthenficationResponse;
import com.pierrette.api.services.AuthentificationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:50085"})
public class LoginController {

    private final AuthentificationService authentificationService;
    @PostMapping("/sign-up")
    public String signUp(@RequestBody SignUp request){
        return authentificationService.signUp(request);
    }

    @PostMapping ("/sign-in")
    public AuthenficationResponse signIn(@RequestBody LoginRequest request){
        return authentificationService.signIn(request);
    }
}