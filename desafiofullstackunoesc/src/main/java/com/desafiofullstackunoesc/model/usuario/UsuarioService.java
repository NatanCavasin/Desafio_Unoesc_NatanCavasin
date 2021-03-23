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

    public Optional<Usuario> getUserById(int id){
        return repository.findById(id);
    }

    public Usuario getUserByLogin(String cpf){
        return repository.findByLogin(cpf);
    }

    public Usuario insertUsuario(Usuario usuario){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuario.setSenha(encoder.encode(usuario.getSenha()));

        return repository.save(usuario);
    }

    public void incluirInscricao(Usuario usuario){
        Assert.notNull(usuario, "Não foi possivel atualizar o registro");

        Optional<Usuario> optionalUsuario = repository.findById(usuario.getId());
        if(optionalUsuario.isPresent()) {
            Usuario user_db = optionalUsuario.get();
            user_db.setInscricoes(usuario.getInscricoes());

            repository.save(user_db);
        }
    }
    
    public boolean update(Usuario usuario) {
        Assert.notNull(usuario, "Não foi possivel atualizar o registro");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Optional<Usuario> optionalUsuario = repository.findById(usuario.getId());
        if(optionalUsuario.isPresent()){
            Usuario user_db = optionalUsuario.get();
            if(!user_db.getSenha().equals(usuario.getSenha()))
                usuario.setSenha(encoder.encode(usuario.getSenha()));
            user_db.setSenha(usuario.getSenha());
            user_db.setCpf(usuario.getCpf());
            user_db.setLogin(usuario.getLogin());
            user_db.setRoles(usuario.getRoles());
            user_db.setNome(usuario.getNome());

            repository.save(user_db);

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
