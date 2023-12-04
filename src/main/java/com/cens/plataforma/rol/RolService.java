package com.cens.plataforma.rol;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RolService {
    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public List<Rol> getRoles(){
        return rolRepository.findAll();
    }

    public List<Rol> getRolesB(){
        List<Rol> roles = rolRepository.findAll();
        roles.remove(0);
        return roles;
    }
}
