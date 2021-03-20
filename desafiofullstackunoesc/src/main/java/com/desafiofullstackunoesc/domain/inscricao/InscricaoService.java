package com.desafiofullstackunoesc.domain.inscricao;

import com.desafiofullstackunoesc.domain.inscricao.Inscricao;
import com.desafiofullstackunoesc.domain.inscricao.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository repository;

    public List<Inscricao> getAllInscricoes(){
        return repository.findAll();
    }

    public Inscricao insertInscricao(Inscricao inscricao){
        return repository.save(inscricao);
    }
    
    public boolean update(int id, Inscricao inscricao) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");

        Optional<Inscricao> optionalInscricao = repository.findById(id);
        if(optionalInscricao.isPresent()){
            repository.save(inscricao);
            return true;
        }
        else{
            return false;
        }

    }

    // Deleta um Inscricao na base de dados
    public boolean delete(int id) {
        Assert.notNull(id, "Não foi possivel excluir o registro");

        Optional<Inscricao> optionalInscricao = repository.findById(id);
        if(optionalInscricao.isPresent()){
            repository.deleteById(id);
            return true;
        }
        else{
            return false;
        }

    }

    
}
