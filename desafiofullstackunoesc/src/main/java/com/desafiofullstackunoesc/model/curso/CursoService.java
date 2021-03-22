package com.desafiofullstackunoesc.model.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    public List<Curso> getAllCursos(){
        return repository.findAll();
    }

    public Curso insertCurso(Curso curso){
        return repository.save(curso);
    }
    
    public boolean update(int id, Curso curso) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");

        Optional<Curso> optionalCurso = repository.findById(id);
        if(optionalCurso.isPresent()){
            repository.save(curso);
            return true;
        }
        else{
            return false;
        }

    }

    // Deleta um Curso na base de dados
    public boolean delete(int id) {
        Assert.notNull(id, "Não foi possivel excluir o registro");

        Optional<Curso> optionalCurso = repository.findById(id);
        if(optionalCurso.isPresent()){
            repository.deleteById(id);
            return true;
        }
        else{
            return false;
        }

    }

    
}
