package com.slloww.lgpd.coverter;

import com.slloww.lgpd.DTOs.ClientRequestDTO;
import com.slloww.lgpd.models.Client;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientDtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public ClientRequestDTO convertClientToClientDTO(Client client){
        return modelMapper.map(client, ClientRequestDTO.class);
    }

    public Client convertClientDTOToClient(ClientRequestDTO clientRequestDTO){
        return modelMapper.map(clientRequestDTO, Client.class);
    }

}
