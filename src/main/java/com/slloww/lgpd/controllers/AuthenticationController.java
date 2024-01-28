package com.slloww.lgpd.controllers;

import com.slloww.lgpd.DTOs.AuthenticationDTO;
import com.slloww.lgpd.DTOs.LoginResponseDTO;
import com.slloww.lgpd.DTOs.RegisterDTO;
import com.slloww.lgpd.models.User;
import com.slloww.lgpd.repositories.UserRepository;
import com.slloww.lgpd.security.TokenService;
import com.slloww.lgpd.services.exceptions.EmailAlreadyExists;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.email(), authenticationDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.genereteToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public String register(@RequestBody @Valid RegisterDTO registerDTO){
        //if(this.userRepository.findByEmail(registerDTO.email()) != null) throw new EmailAlreadyExists();

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());

        this.userRepository.save(User.builder()
                .email(registerDTO.email())
                .password(encryptedPassword)
                .username(registerDTO.username())
                .role(registerDTO.role())
                .build()
        );
        return "Register successfully";
    }

}
