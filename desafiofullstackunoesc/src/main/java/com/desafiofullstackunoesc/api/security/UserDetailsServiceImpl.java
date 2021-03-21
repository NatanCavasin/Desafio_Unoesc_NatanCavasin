package com.desafiofullstackunoesc.api.security;

import com.desafiofullstackunoesc.domain.usuario.Usuario;
import com.desafiofullstackunoesc.domain.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service()
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Usuario user = usuarioService.getUserByCpf(username);
        if(user == null){
            throw new UsernameNotFoundException("user not found");
        }
        return user;
    }
}
