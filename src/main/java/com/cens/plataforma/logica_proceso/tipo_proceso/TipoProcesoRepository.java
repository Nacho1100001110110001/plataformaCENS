package com.cens.plataforma.logica_proceso.tipo_proceso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProcesoRepository extends JpaRepository<TipoProceso, Long>{
    
}
