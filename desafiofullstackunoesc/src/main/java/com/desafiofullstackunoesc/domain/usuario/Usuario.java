package com.desafiofullstackunoesc.domain.usuario;

import com.desafiofullstackunoesc.domain.curso.Curso;
import com.desafiofullstackunoesc.domain.inscricao.Inscricao;
import com.desafiofullstackunoesc.domain.roles.Role;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String cpf;
    private String perfil;

    @OneToMany
    @JoinColumn(name="usuario_id")
    private List<Inscricao> inscricoes;
    
    //Associação muitos para muitos com a tabela role
    @ManyToMany(fetch = FetchType.EAGER)
    //Tabela de associação e definição das chaves estrangeiras
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
