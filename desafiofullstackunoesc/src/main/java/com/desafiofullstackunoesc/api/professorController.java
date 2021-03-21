package com.desafiofullstackunoesc.api;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professor")
public class professorController {

    @Secured({"ROLE_PROFESSOR"})
    public String login(){
        return "Bem vindo professor";
    }
}
