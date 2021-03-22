package com.desafiofullstackunoesc.model.disciplina;

import com.desafiofullstackunoesc.model.curso.Curso;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private int usuario_professor_id;

    //Associação muitos para muitos com a tabela disciplina
    @ManyToMany(fetch = FetchType.EAGER)
    //Tabela de associação e definição das chaves estrangeiras
    @JoinTable(name = "curso_disciplina",
            joinColumns = @JoinColumn(name = "disciplina_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id", referencedColumnName = "id"))
    private List<Curso> cursos;
}
