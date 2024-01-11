package com.example.foyerUniversitaire.Controller;

import com.example.foyerUniversitaire.Model.LoginRequest;
import com.example.foyerUniversitaire.Model.LoginResponse;
import com.example.foyerUniversitaire.Security.JwtIssuer;
import com.example.foyerUniversitaire.Security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthenticationRESTController {

    private final JwtIssuer jwtIssuer;
    private final AuthenticationManager authenticationManager;
    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest loginRequest){
        var authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        var principal=(UserPrincipal)authentication.getPrincipal();
        var roles= principal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        var token=jwtIssuer.issue (principal.getUserId(),principal.getEmail(), roles);
        return LoginResponse.builder()
                .accessToken(token)
                .build();

    }
}
