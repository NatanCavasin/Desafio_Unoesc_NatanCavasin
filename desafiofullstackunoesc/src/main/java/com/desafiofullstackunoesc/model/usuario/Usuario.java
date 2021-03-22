package com.desafiofullstackunoesc.model.usuario;

import com.desafiofullstackunoesc.model.inscricao.Inscricao;
import com.desafiofullstackunoesc.model.roles.Role;
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
  //  private String perfil;
    private String senha;
    private String login;

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
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
