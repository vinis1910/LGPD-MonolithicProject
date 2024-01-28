package com.slloww.lgpd.controllers;

import com.slloww.lgpd.DTOs.ClientRequestDTO;
import com.slloww.lgpd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody ClientRequestDTO clientRequestDTO){
        userService.create(clientRequestDTO);
        return "Client created successfully";
    }
}
