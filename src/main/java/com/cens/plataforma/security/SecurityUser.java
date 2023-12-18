package com.cens.plataforma.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cens.plataforma.rol.Rol;
import com.cens.plataforma.usuario.Usuario;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityUser implements UserDetails{
    private final Usuario usuario;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Rol rol = usuario.getRol();
        List<Rol> roles = new ArrayList<>();
        roles.add(rol);
        return roles.stream().map(SecurityAuthority::new).toList();
    }

    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Override
    public String getUsername() {
        return usuario.getEmail();
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
