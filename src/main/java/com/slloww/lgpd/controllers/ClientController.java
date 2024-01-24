package com.slloww.lgpd.controllers;

import com.slloww.lgpd.DTOs.ClientRequestDTO;
import com.slloww.lgpd.DTOs.ClientResponseDTO;
import com.slloww.lgpd.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody ClientRequestDTO clientRequestDTO){
        clientService.create(clientRequestDTO);
        return "Client created successfully";
    }
}
