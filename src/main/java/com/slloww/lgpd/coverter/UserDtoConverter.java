package com.slloww.lgpd.coverter;

import com.slloww.lgpd.DTOs.UserRequestDTO;
import com.slloww.lgpd.DTOs.UserResponseDTO;
import com.slloww.lgpd.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public UserRequestDTO convertUsertToUserRequestDTO(User user){
        return modelMapper.map(user, UserRequestDTO.class);
    }

    public User convertUserRequestDTOToUser(UserRequestDTO userRequestDTO){
        return modelMapper.map(userRequestDTO, User.class);
    }

    public UserResponseDTO convertUserToUserResponseDTO(User user){
        return modelMapper.map(user, UserResponseDTO.class);
    }

    public User convertUserResponseDTOToUser(UserResponseDTO userRequestDTO){
        return modelMapper.map(userRequestDTO, User.class);
    }

}
