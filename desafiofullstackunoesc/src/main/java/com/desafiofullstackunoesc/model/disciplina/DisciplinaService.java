package com.desafiofullstackunoesc.model.disciplina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository repository;

    public List<Disciplina> getAllDisciplinas(){
        return repository.findAll();
    }

    public Disciplina insertDisciplina(Disciplina disciplina){
        return repository.save(disciplina);
    }
    
    public boolean update(int id, Disciplina disciplina) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");

        Optional<Disciplina> optionalDisciplina = repository.findById(id);
        if(optionalDisciplina.isPresent()){
            repository.save(disciplina);
            return true;
        }
        else{
            return false;
        }

    }

    // Deleta um Disciplina na base de dados
    public boolean delete(int id) {
        Assert.notNull(id, "Não foi possivel excluir o registro");

        Optional<Disciplina> optionalDisciplina = repository.findById(id);
        if(optionalDisciplina.isPresent()){
            repository.deleteById(id);
            return true;
        }
        else{
            return false;
        }

    }

    
}
