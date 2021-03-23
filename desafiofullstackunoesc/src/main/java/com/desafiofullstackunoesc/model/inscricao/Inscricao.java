package com.desafiofullstackunoesc.model.inscricao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //Codigo
    private int curso_id;
    private int usuario_id;

    //Os atributos curso e usuário são mapeados atraves da associação entre as tabelas no banco
    //com a anotação @OneToMany nas respectivas classes
}
