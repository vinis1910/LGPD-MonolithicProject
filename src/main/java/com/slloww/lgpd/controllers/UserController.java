package com.slloww.lgpd.controllers;

import com.slloww.lgpd.DTOs.UserRequestDTO;
import com.slloww.lgpd.DTOs.UserResponseDTO;
import com.slloww.lgpd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody UserRequestDTO userRequestDTO){
        userService.create(userRequestDTO);
        return "Client created successfully";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponseDTO> findAll(){
        List<UserResponseDTO> user = userService.findAll();
        return user;
    }
}
