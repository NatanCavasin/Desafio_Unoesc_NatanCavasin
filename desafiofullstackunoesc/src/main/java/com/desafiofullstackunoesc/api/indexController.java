package com.desafiofullstackunoesc.api;


import com.desafiofullstackunoesc.domain.usuario.Usuario;
import com.desafiofullstackunoesc.domain.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class indexController {

    @Autowired
    private UsuarioService service;

    @GetMapping()
    public ResponseEntity<List<Usuario>> get(){
        return ResponseEntity.ok(service.getAllUsuarios());
    }

}
