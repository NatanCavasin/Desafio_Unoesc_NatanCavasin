package com.desafiofullstackunoesc.controller;

import com.desafiofullstackunoesc.model.curso.CursoService;
import com.desafiofullstackunoesc.model.disciplina.DisciplinaService;
import com.desafiofullstackunoesc.model.roles.RoleService;
import com.desafiofullstackunoesc.model.usuario.Usuario;
import com.desafiofullstackunoesc.model.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private DisciplinaService disciplinaService;


    @GetMapping()
    @Secured({"ROLE_ADMIN"})
    public String get() {
        return "dashBoard";
    }

    @GetMapping("/usuarios")
    @Secured({"ROLE_ADMIN"})
    public ModelAndView listarUsuarios() {
        ModelAndView model = new ModelAndView("admin_user_view");
        model.addObject("getAllUsers", usuarioService.getAllUsuarios());
        return model;
    }

    @GetMapping("/cursos")
    @Secured({"ROLE_ADMIN"})
    public ModelAndView listarCursos() {
        ModelAndView model = new ModelAndView("admin_curso_view");
        model.addObject("getAllCursos", cursoService.getAllCursos());
        return model;
    }

    @GetMapping("/disciplinas")
    @Secured({"ROLE_ADMIN"})
    public ModelAndView listarDisciplinas() {
        ModelAndView model = new ModelAndView("admin_discplina_view");
        model.addObject("getAllDisciplinas", disciplinaService.getAllDisciplinas());
        return model;
    }

    @GetMapping("/usuario/inserir")
    @Secured({"ROLE_ADMIN"})
    public ModelAndView novoUsuario(){
        ModelAndView model = new ModelAndView("admin_user_inserir_view");
        model.addObject("roles", roleService.getAllRoles());
        model.addObject("usuario", new Usuario());
        return model;
    }

    @PostMapping("/usuario/inserir")
    @Secured({"ROLE_ADMIN"})
    public RedirectView salvar (Usuario usuario){
        this.usuarioService.insertUsuario(usuario);
        return new RedirectView("/admin");
    }

}
