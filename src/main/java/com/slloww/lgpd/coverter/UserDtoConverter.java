package com.slloww.lgpd.coverter;

import com.slloww.lgpd.DTOs.ClientRequestDTO;
import com.slloww.lgpd.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientDtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public ClientRequestDTO convertClientToClientDTO(User user){
        return modelMapper.map(user, ClientRequestDTO.class);
    }

    public User convertClientDTOToClient(ClientRequestDTO clientRequestDTO){
        return modelMapper.map(clientRequestDTO, User.class);
    }

}
