package org.ieee.iot.controller;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.ieee.iot.domain.User;
import org.ieee.iot.domain.req.NewUserModel;
import org.ieee.iot.domain.res.Response;
import org.ieee.iot.service.token.TokenService;
import org.ieee.iot.service.auth.AuthServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthServiceImpl authServiceImpl;
    private final TokenService tokenService;

    @PostMapping("/signup")
    public ResponseEntity<Response> signup(@RequestBody @Valid NewUserModel newUserModel) {
        String token = authServiceImpl.signupNewUser(newUserModel);

        return ResponseEntity.created(null)
                .body(Response.builder()
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .timeStamp(LocalDateTime.now().toString())
                        .message("User created successfully.")
                        .data(Map.of("token", token))
                        .build()
                );
    }


    @PostMapping("/login")
    public ResponseEntity<Response> login(@Valid @RequestBody LoginForm loginForm) {
        String token = authServiceImpl.loginUser(loginForm.getUsername(), loginForm.getPassword());

        return ResponseEntity.ok(
                Response.builder()
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .timeStamp(LocalDateTime.now().toString())
                .message("User logged in successfully.")
                .data(Map.of("token", token))
                .build()
        );
    }

    @GetMapping("/@me")
    public ResponseEntity<Response> getUser(@AuthenticationPrincipal Jwt jwt) {
        User user = tokenService.getUser(jwt);

        return ResponseEntity.ok(
                Response.builder()
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .timeStamp(LocalDateTime.now().toString())
                        .message("User details fetched successfully.")
                        .data(Map.of("user", user))
                        .build()
        );
    }

}

@Data
class LoginForm {
    private String username;
    private String password;
}
