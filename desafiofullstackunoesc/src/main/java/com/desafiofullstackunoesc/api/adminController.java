package com.desafiofullstackunoesc.api;

import com.desafiofullstackunoesc.domain.usuario.Usuario;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/admin")
public class adminController {

    @GetMapping()
    @Secured({"ROLE_ADMIN"})
    public String login(){
      return "Bem vindo administrador";
    }
}
