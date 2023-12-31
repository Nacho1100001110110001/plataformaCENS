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

    public Rol getRolById(Long idRol){
        return rolRepository.findById(idRol).get();
    }

    public List<Rol> getRolesNoAdmin(){
        List<Rol> roles = rolRepository.findAll();
        roles.remove(0);
        return roles;
    }
}
