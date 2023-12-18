package com.cens.plataforma.logica_proceso.tipo_proceso;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TipoProcesoService {
    private final TipoProcesoRepository tipoProcesoRepository;

    public TipoProcesoService(TipoProcesoRepository tipoProcesoRepository) {
        this.tipoProcesoRepository = tipoProcesoRepository;
    }

    public List<TipoProceso> getTipoProceso(){
        return tipoProcesoRepository.findAll();
    }
}
