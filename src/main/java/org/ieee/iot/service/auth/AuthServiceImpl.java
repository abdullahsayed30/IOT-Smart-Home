package org.ieee.iot.service.auth;

import lombok.RequiredArgsConstructor;
import org.ieee.iot.db.sequence.SequenceGenerator;
import org.ieee.iot.domain.User;
import org.ieee.iot.domain.req.NewUserModel;
import org.ieee.iot.repository.UserRepository;
import org.ieee.iot.service.token.TokenService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final SequenceGenerator sequenceGenerator;

    private final TokenService tokenService;

    @Override
    public String signupNewUser(NewUserModel userModel) {
        if (userRepository.existsByUsername(userModel.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.existsByEmail(userModel.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        Long id = sequenceGenerator.generateSequence(User.SEQ_NAME);

        User user = new User(
                id,
                userModel.getFirstName(),
                userModel.getLastName(),
                userModel.getAddress(),
                userModel.getUsername(),
                userModel.getEmail(),
                passwordEncoder.encode(userModel.getPassword()),
                userModel.getPhoneNumber()
        );

        user.setRoles("USER");

        userRepository.save(user);

        return tokenService.generateToken(user);
    }

    @Override
    public String loginUser(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return tokenService.generateToken(user);
    }

}
