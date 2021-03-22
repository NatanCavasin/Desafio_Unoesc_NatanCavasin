package com.desafiofullstackunoesc.model.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> getAllUsuarios(){
        return repository.findAll();
    }

    public Usuario getUserByLogin(String cpf){
        return repository.findByLogin(cpf);
    }

    public Usuario insertUsuario(Usuario usuario){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuario.setSenha(encoder.encode(usuario.getSenha()));

        return repository.save(usuario);
    }
    
    public boolean update(int id, Usuario usuario) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");

        Optional<Usuario> optionalUsuario = repository.findById(id);
        if(optionalUsuario.isPresent()){
            repository.save(usuario);
            return true;
        }
        else{
            return false;
        }

    }

    // Deleta um Usuario na base de dados
    public boolean delete(int id) {
        Assert.notNull(id, "Não foi possivel excluir o registro");

        Optional<Usuario> optionalUsuario = repository.findById(id);
        if(optionalUsuario.isPresent()){
            repository.deleteById(id);
            return true;
        }
        else{
            return false;
        }

    }

    
}