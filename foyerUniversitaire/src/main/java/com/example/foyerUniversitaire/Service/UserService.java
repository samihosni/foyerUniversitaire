package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private static final String EXISTING_EMAIL = "samy.hosni@gmail.com";

    public Optional<UserEntity> findByEmail(String email) {
        // TODO: move this to database
        if (!EXISTING_EMAIL.equalsIgnoreCase(email))
            return Optional.empty();
        var user = new UserEntity();
        user.setId(1L);
        user.setEmail(EXISTING_EMAIL);
        user.setPassword("$2a$12$r5yg6kyHhDojvzLnwFc7sOSZjF00aY9UC7CV7EDiyez7EX7JER/UK"); //password = ca1920}
        user.setRole("ROLE_ADMIN");
        user.setExtraInfo("SAMI L'ADMIN");
        return Optional.of(user);
    }
}

