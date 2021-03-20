package com.desafiofullstackunoesc.domain.curso;

import com.desafiofullstackunoesc.domain.disciplina.Disciplina;
import com.desafiofullstackunoesc.domain.inscricao.Inscricao;
import com.desafiofullstackunoesc.domain.roles.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private int vagas;

    @OneToMany
    @JoinColumn(name="curso_id")
    private List<Inscricao> inscricoes;

    //Associação muitos para muitos com a tabela disciplina
    @ManyToMany(fetch = FetchType.EAGER)
    //Tabela de associação e definição das chaves estrangeiras
    @JoinTable(name = "curso_disciplina",
               joinColumns = @JoinColumn(name = "curso_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "disciplina_id", referencedColumnName = "id"))
    private List<Disciplina> disciplinas;
}
