package com.cens.plataforma.logica_proceso.nota_proceso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaProcesoRepository extends JpaRepository<NotaProceso, Long>{
    
}
