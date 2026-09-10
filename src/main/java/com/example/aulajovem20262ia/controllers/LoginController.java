package com.example.aulajovem20262ia.controllers;

import com.example.aulajovem20262ia.DTO.LoginRequest;
import com.example.aulajovem20262ia.DTO.LoginResponse;
import com.example.aulajovem20262ia.entities.Usuario;
import com.example.aulajovem20262ia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<LoginResponse> logar(@RequestBody LoginRequest loginRequest){



        if ( usuarioRepository.existsUsuarioByCpfAndSenha(loginRequest.getLogin(),
                loginRequest.getSenha()) ){

            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setMensagem("Bem vindo! Ao sistema de alunos!");

            return ResponseEntity.ok(loginResponse);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }


}
