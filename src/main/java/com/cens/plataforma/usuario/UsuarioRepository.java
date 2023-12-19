package com.cens.plataforma.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cens.plataforma.rol.Rol;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {
    Optional<Usuario> findUsuarioByEmail(String email);
    Optional<Usuario> findUsuarioByNombre(String nombre);
    List<Usuario> findAll();
    List<Usuario> findByRol(Rol rol);
}