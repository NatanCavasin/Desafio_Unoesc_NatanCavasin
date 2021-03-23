package com.desafiofullstackunoesc.model.curso;

import com.desafiofullstackunoesc.model.usuario.Usuario;
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

    public Optional<Curso> getCursoById(int id){
        return repository.findById(id);
    }

    public Curso insertCurso(Curso curso){
        return repository.save(curso);
    }

    public void incluirInscricao(Curso curso){
        Assert.notNull(curso, "Não foi possivel atualizar o registro");

        Optional<Curso> optionalUCurso = repository.findById(curso.getId());
        if(optionalUCurso.isPresent()) {
            Curso curso_db = optionalUCurso.get();
            curso_db.setInscricoes(curso.getInscricoes());

            repository.save(curso_db);
        }
    }

    public boolean update(Curso curso) {
        Assert.notNull(curso, "Não foi possivel atualizar o registro");

        Optional<Curso> optionalCurso = repository.findById(curso.getId());
        if(optionalCurso.isPresent()){
            Curso curso_db = optionalCurso.get();

            curso_db.setNome(curso.getNome());
            curso_db.setVagas(curso.getVagas());

            repository.save(curso_db);

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
