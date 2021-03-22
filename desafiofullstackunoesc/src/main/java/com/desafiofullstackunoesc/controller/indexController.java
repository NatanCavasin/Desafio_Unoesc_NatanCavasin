package com.desafiofullstackunoesc.controller;


import com.desafiofullstackunoesc.model.usuario.Usuario;
import com.desafiofullstackunoesc.model.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/")
public class indexController {

    @Autowired
    private UsuarioService service;

    @GetMapping()
    public RedirectView login(@AuthenticationPrincipal Usuario currentUser){

        if(currentUser.getRoles().get(0).getNome().equals("ROLE_ADMIN")){
           return new RedirectView("/admin");
        }
        if(currentUser.getRoles().get(0).getNome().equals("ROLE_PROFESSOR")){
            return new RedirectView("/professor");
        }
        if(currentUser.getRoles().get(0).getNome().equals("ROLE_ALUNO")){
            return new RedirectView("/aluno");
        }
       else return new RedirectView("/login");

    }

}
