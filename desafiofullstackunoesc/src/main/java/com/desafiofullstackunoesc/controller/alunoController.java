package com.desafiofullstackunoesc.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluno")
public class alunoController {

    @Secured({"ROLE_ALUNO"})
    public String login(){
        return "Bem vindo aluno";
    }
}
