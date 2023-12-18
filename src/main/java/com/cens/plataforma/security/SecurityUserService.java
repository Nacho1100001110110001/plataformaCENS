package com.cens.plataforma.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cens.plataforma.usuario.UsuarioRepository;

@Service
public class SecurityUserService implements UserDetailsService{
    private final UsuarioRepository usuarioRepository;

    public SecurityUserService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var usuario = usuarioRepository.findUsuarioByEmail(email);
        if(usuario.isPresent()) return new SecurityUser(usuario.get());
        throw new UsernameNotFoundException("Usuario no encontrado.");
    }


}
