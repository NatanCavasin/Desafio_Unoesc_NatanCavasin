package com.desafiofullstackunoesc.domain.curso;

import com.desafiofullstackunoesc.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
