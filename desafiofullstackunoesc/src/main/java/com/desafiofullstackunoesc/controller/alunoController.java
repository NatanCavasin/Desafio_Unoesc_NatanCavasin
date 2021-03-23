package com.desafiofullstackunoesc.controller;

import com.desafiofullstackunoesc.model.curso.Curso;
import com.desafiofullstackunoesc.model.curso.CursoService;
import com.desafiofullstackunoesc.model.inscricao.Inscricao;
import com.desafiofullstackunoesc.model.inscricao.InscricaoService;
import com.desafiofullstackunoesc.model.usuario.Usuario;
import com.desafiofullstackunoesc.model.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/aluno")
public class alunoController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private InscricaoService inscricaoService;

    @GetMapping()
    @Secured({"ROLE_ALUNO"})
    public ModelAndView listarCursos(){
        ModelAndView model = new ModelAndView("aluno_view");
        model.addObject("getAllCursos", cursoService.getAllCursos());
        return model;
    }

    @GetMapping("/inscricao/{id}")
    @Secured({"ROLE_ALUNO"})
    public ModelAndView listarCursos(@PathVariable("id") int id){
        ModelAndView model = new ModelAndView("aluno_inscricao_view");
        Optional<Curso> curso = cursoService.getCursoById(id);
        model.addObject("curso", curso);
        return model;
    }

    @PostMapping("/inscricao/confirmar")
    @Secured({"ROLE_ALUNO"})
    public RedirectView atualizarUsuario(Curso curso, @AuthenticationPrincipal Usuario currentUser){
       Inscricao inscricao = this.inscricaoService.insertInscricao(new Inscricao());
        List<Inscricao> inscUsuario =  currentUser.getInscricoes();
        inscUsuario.add(inscricao);
        currentUser.setInscricoes(inscUsuario);

        List<Inscricao> inscCurso =  curso.getInscricoes();
        inscCurso.add(inscricao);
        curso.setInscricoes(inscUsuario);

        return new RedirectView("/");
    }

}
