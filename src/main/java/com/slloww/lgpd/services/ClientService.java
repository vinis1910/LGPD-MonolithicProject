package com.slloww.lgpd.services;

import com.slloww.lgpd.DTOs.ClientRequestDTO;
import com.slloww.lgpd.coverter.ClientDtoConverter;
import com.slloww.lgpd.models.Client;
import com.slloww.lgpd.repositories.ClientRepository;
import com.slloww.lgpd.services.exceptions.EmailAlreadyExists;
import com.slloww.lgpd.services.exceptions.UsernameAlreadyExists;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientDtoConverter clientDtoConverter;

    public void create(ClientRequestDTO clientRequestDto){
        if(clientRepository.findByUsername(clientRequestDto.getUsername()).isPresent()) throw new UsernameAlreadyExists();
        if(clientRepository.findByEmail(clientRequestDto.getEmail()).isPresent()) throw new EmailAlreadyExists();

        Client client = clientDtoConverter.convertClientDTOToClient(clientRequestDto);
        clientRepository.save(client);
    }

}
