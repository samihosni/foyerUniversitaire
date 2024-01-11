package com.example.foyerUniversitaire.Security;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtPrincipalConverter {
    public UserPrincipal convert(DecodedJWT decodedJWT){
        return UserPrincipal.builder()
                .userId(Long.valueOf(decodedJWT.getSubject()))
                .email(decodedJWT.getClaim("e").asString())
                .authorities(extractAuthoritiesFromClaim(decodedJWT))
                .build();
    }
    private List<SimpleGrantedAuthority> extractAuthoritiesFromClaim(DecodedJWT jwt){
        var claim = jwt.getClaim("e");
        if (claim.isNull() || claim.isMissing()) return List.of();
return claim.asList(SimpleGrantedAuthority.class);
    }
}
