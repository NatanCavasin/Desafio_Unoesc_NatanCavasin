package com.desafiofullstackunoesc.controller;

import com.desafiofullstackunoesc.model.curso.Curso;
import com.desafiofullstackunoesc.model.curso.CursoService;
import com.desafiofullstackunoesc.model.disciplina.DisciplinaService;
import com.desafiofullstackunoesc.model.roles.RoleService;
import com.desafiofullstackunoesc.model.usuario.Usuario;
import com.desafiofullstackunoesc.model.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

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
    public RedirectView salvarUsuario(Usuario usuario){
        this.usuarioService.insertUsuario(usuario);
        return new RedirectView("/admin/usuarios");
    }

    @GetMapping("/usuario/atualizar/{id}")
    @Secured({"ROLE_ADMIN"})
    public ModelAndView atulaizarUsuario(@PathVariable("id") int id){
        Optional<Usuario> userOptional = usuarioService.getUserById(id);
        Usuario usuario = userOptional.get();

        ModelAndView model = new ModelAndView("admin_user_atualizar_view");
        model.addObject("roles", roleService.getAllRoles());
        model.addObject("usuario", usuario);
        return model;
    }

    @PostMapping("/usuario/update")
    @Secured({"ROLE_ADMIN"})
    public RedirectView atualizarUsuario(Usuario usuario){
        this.usuarioService.update(usuario);
        return new RedirectView("/admin/usuarios");
    }

    @GetMapping("/usuario/excluir/{id}")
    @Secured({"ROLE_ADMIN"})
    public RedirectView excluirUsuario(@PathVariable("id") int id){
        this.usuarioService.delete(id);
        return new RedirectView("/admin/usuarios");
    }

    // ----------------------------------------------------------------------------------
    @GetMapping("/cursos")
    @Secured({"ROLE_ADMIN"})
    public ModelAndView listarCursos() {
        ModelAndView model = new ModelAndView("admin_curso_view");
        model.addObject("getAllCursos", cursoService.getAllCursos());
        return model;
    }

    @GetMapping("/curso/inserir")
    @Secured({"ROLE_ADMIN"})
    public ModelAndView novoCurso(){
        ModelAndView model = new ModelAndView("admin_curso_inserir_view");
        model.addObject("getAllDisciplinas", disciplinaService.getAllDisciplinas());
        model.addObject("curso", new Curso());
        return model;
    }

    @PostMapping("/curso/inserir")
    @Secured({"ROLE_ADMIN"})
    public RedirectView salvarCurso(Curso curso){
        this.cursoService.insertCurso(curso);
        return new RedirectView("/admin/cursos");
    }

    @GetMapping("/curso/atualizar/{id}")
    @Secured({"ROLE_ADMIN"})
    public ModelAndView atulaizarCurso(@PathVariable("id") int id){
        Optional<Curso> cursoOptional = cursoService.getCursoById(id);
        Curso curso = cursoOptional.get();

        ModelAndView model = new ModelAndView("admin_curso_atualizar_view");
        model.addObject("getAllDisciplinas", disciplinaService.getAllDisciplinas());
        model.addObject("curso", curso);
        return model;
    }

    @PostMapping("/curso/update")
    @Secured({"ROLE_ADMIN"})
    public RedirectView updateCurso(Curso curso){
        this.cursoService.update(curso);
        return new RedirectView("/admin/cursos");
    }

    @GetMapping("/curso/excluir/{id}")
    @Secured({"ROLE_ADMIN"})
    public RedirectView excluirCurso(@PathVariable("id") int id){
        System.out.println("IDDDDDDDDD" + id);
        this.cursoService.delete(id);
        return new RedirectView("/admin/cursos");
    }

    // ----------------------------------------------------------------------------------
    @GetMapping("/disciplinas")
    @Secured({"ROLE_ADMIN"})
    public ModelAndView listarDisciplinas() {
        ModelAndView model = new ModelAndView("admin_discplina_view");
        model.addObject("getAllDisciplinas", disciplinaService.getAllDisciplinas());
        return model;
    }

}
