package com.cens.plataforma.security;

import org.springframework.security.core.GrantedAuthority;

import com.cens.plataforma.rol.Rol;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority{
    private final Rol rol;

    @Override
    public String getAuthority() {
        return rol.getNomRol();
    }
    
}
