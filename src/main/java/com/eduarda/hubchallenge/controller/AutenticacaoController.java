package com.eduarda.hubchallenge.controller;

import com.eduarda.hubchallenge.domain.usuario.DadosLogin;
import com.eduarda.hubchallenge.domain.usuario.DadosToken;
import com.eduarda.hubchallenge.security.TokenService;
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
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DadosToken> login(@RequestBody @Valid DadosLogin dados) {

        var authenticationToken = new UsernamePasswordAuthenticationToken(
                dados.login(),
                dados.senha()
        );

        var authentication = manager.authenticate(authenticationToken);
        var token = tokenService.gerarToken(authentication.getName());

        return ResponseEntity.ok(new DadosToken(token));
    }
}
