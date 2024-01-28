package com.slloww.lgpd.services;

import com.slloww.lgpd.DTOs.UserRequestDTO;
import com.slloww.lgpd.DTOs.UserResponseDTO;
import com.slloww.lgpd.coverter.UserDtoConverter;
import com.slloww.lgpd.models.User;
import com.slloww.lgpd.repositories.UserRepository;
import com.slloww.lgpd.services.exceptions.EmailAlreadyExists;
import com.slloww.lgpd.services.exceptions.UsernameAlreadyExists;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDtoConverter userDtoConverter;

    @Transactional
    public void create(UserRequestDTO userRequestDto){
        if(userRepository.findByUsername(userRequestDto.getUsername()).isPresent()) throw new UsernameAlreadyExists();
        if(userRepository.findByEmail(userRequestDto.getEmail()).isPresent()) throw new EmailAlreadyExists();

        User user = userDtoConverter.convertUserRequestDTOToUser(userRequestDto);
        userRepository.save(user);
    }

    @Transactional
    public List<UserResponseDTO> findAll() {
        List<User> users = userRepository.findAll();
        List<UserResponseDTO> userResponse = users.stream().map(user -> userDtoConverter
                .convertUserToUserResponseDTO(user)).toList();
        return userResponse;
    }
}
