package com.marciosalesdev.movieflix.controller;

import com.marciosalesdev.movieflix.config.TokenService;
import com.marciosalesdev.movieflix.controller.request.LoginRequest;
import com.marciosalesdev.movieflix.controller.request.UserRequest;
import com.marciosalesdev.movieflix.controller.response.UserResponse;
import com.marciosalesdev.movieflix.entity.User;
import com.marciosalesdev.movieflix.exception.UsernameOrPasswordInvalidException;
import com.marciosalesdev.movieflix.mapper.UserMapper;
import com.marciosalesdev.movieflix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest) {
        User saveUser = userService.save(UserMapper.toUser(userRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(saveUser));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> register(@RequestBody LoginRequest loginRequest) {
        try {

            UsernamePasswordAuthenticationToken authAndPass = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());
            Authentication authentication = authenticationManager.authenticate(authAndPass);

            User user = (User) authentication.getPrincipal();
            String token = tokenService.generateToken(user);

            return ResponseEntity.ok(new LoginResponse(token));
        } catch (BadCredentialsException exception) {
            throw new UsernameOrPasswordInvalidException("Usuario ou senha invalida");
        }
    }

}
