package org.ieee.iot.service.user;

import lombok.RequiredArgsConstructor;
import org.ieee.iot.db.sequence.SequenceGenerator;
import org.ieee.iot.domain.House;
import org.ieee.iot.domain.User;
import org.ieee.iot.helper.req_model.NewUserModel;
import org.ieee.iot.repository.UserRepository;
import org.ieee.iot.service.house.HouseService;
import org.ieee.iot.service.token.TokenService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


/*************************************************
 * Copyright (c) 2023-2-18 Abdullah Sayed Sallam.
 ************************************************/

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final SequenceGenerator sequenceGenerator;
    // Auth related
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    private final UserRepository userRepository;
    private final HouseService houseService;

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

        House house = houseService.createHouseForNewUser(user);

        user.setHouse(house);
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

    @Override
    public boolean hasRoom(Long roomId, User user) {
        return user.getHouse().getRooms().stream().anyMatch(room -> room.getId().equals(roomId));
    }

}
