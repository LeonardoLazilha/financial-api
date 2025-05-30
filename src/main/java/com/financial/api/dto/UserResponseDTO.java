package com.financial.api.dto;

import com.financial.api.model.User;

public record UserResponseDTO(
        Long id,
        String nome,
        String email,
        String senha,
        Boolean admin
) {
    public UserResponseDTO(User user){
        this(user.getId(), user.getNome(), user.getEmail(), user.getSenha(), user.getAdmin());
    }
}
