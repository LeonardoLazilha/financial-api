package com.financial.api.service;

import com.financial.api.dto.UserRequestDTO;
import com.financial.api.dto.UserResponseDTO;
import com.financial.api.model.User;
import com.financial.api.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional
    public UserResponseDTO criar (UserRequestDTO dto){
        User user = new User(dto);
        User salvo = repository.save(user);
        return new UserResponseDTO(salvo);
    }

}
