package com.cens.plataforma.logica_proceso.nota_proceso;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaProcesoRepository extends JpaRepository<NotaProceso, Long>{
    @Query(value ="SELECT * FROM nota_proceso u WHERE u.id_empresa = :idEmpresa", nativeQuery = true)
    List<NotaProceso> findByIdEmpresa(Long idEmpresa);
}
