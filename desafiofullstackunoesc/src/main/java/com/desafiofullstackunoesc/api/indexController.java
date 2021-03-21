package com.desafiofullstackunoesc.api;


import com.desafiofullstackunoesc.domain.usuario.Usuario;
import com.desafiofullstackunoesc.domain.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
            return new RedirectView("/admin");
        }
        if(currentUser.getRoles().get(0).getNome().equals("ROLE_ALUNO")){
            return new RedirectView("/admin");
        }
       else return new RedirectView("/login");

    }

}
