package com.example.foyerUniversitaire.Controller;

import com.example.foyerUniversitaire.Model.LoginRequest;
import com.example.foyerUniversitaire.Model.LoginResponse;
import com.example.foyerUniversitaire.Security.JwtIssuer;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthenticationRESTController {

    private final JwtIssuer jwtIssuer;
    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest loginRequest){
        var token=jwtIssuer.issue(1997, loginRequest.getEmail(), List.of("USER"));
        return LoginResponse.builder()
                .accessToken(token)
                .build();

    }
}
