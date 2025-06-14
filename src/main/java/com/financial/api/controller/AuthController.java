package com.financial.api.controller;

import com.financial.api.config.TokenDTO;
import com.financial.api.config.TokenService;
import com.financial.api.dto.LoginDTO;
import com.financial.api.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login (@RequestBody @Valid LoginDTO login){

        //-spring nao aceita receber meu dto, entao preciso jogar ele nessa classe
        var authToken = new UsernamePasswordAuthenticationToken(login.email(), login.senha());

        //-representa o usuario autenticado no sistema
        var authentication = manager.authenticate(authToken);

        var tokenJWT = tokenService.gerarToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(tokenJWT));
    }

}
