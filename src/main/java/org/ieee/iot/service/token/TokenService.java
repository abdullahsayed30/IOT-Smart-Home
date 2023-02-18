package org.ieee.iot.service.token;

import lombok.RequiredArgsConstructor;
import org.ieee.iot.domain.User;
import org.ieee.iot.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;


/*************************************************
 * Copyright (c) 2023-2-18 Abdullah Sayed Sallam.
 ************************************************/

@Service
@RequiredArgsConstructor
public class TokenService {

    private final JwtEncoder jwtEncoder;

    private final UserRepository userRepository;


    public String generateToken(String username, String roles) {

        Instant now = Instant.now();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(100, ChronoUnit.HOURS))
                .claim("roles", roles)
                .subject(username)
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public String generateToken(User user) {
        return generateToken(user.getUsername(), user.getRoles());
    }

    public User getUser(Jwt jwt) {
        String username = jwt.getSubject();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

}
