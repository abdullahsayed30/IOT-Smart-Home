package org.ieee.iot.service.auth;

import lombok.RequiredArgsConstructor;
import org.ieee.iot.domain.auth.SecurityUser;
import org.ieee.iot.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(SecurityUser::new)
                .orElseThrow();
    }
}
