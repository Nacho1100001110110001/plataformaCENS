package com.cens.plataforma.logica_proceso.proceso_usuario_empresa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProcesoUsuarioEmpresaRepository extends JpaRepository<ProcesoUsuarioEmpresa, Long>{
    @Query(value = "SELECT * FROM proceso_usuario_empresa u WHERE u.id_empresa = :idEmpresa", nativeQuery = true)
    List<ProcesoUsuarioEmpresa> findByIdEmpresa(Long idEmpresa);
}
