package com.cens.plataforma.empresa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, String>{
    Optional<Empresa> findEmpresaByEmail(String email);
    List<Empresa> findAll();
}