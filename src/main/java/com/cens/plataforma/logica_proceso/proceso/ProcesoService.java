package com.cens.plataforma.logica_proceso.proceso;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProcesoService {
    private final ProcesoRepository procesoRepository;

    public ProcesoService(ProcesoRepository procesoRepository) {
        this.procesoRepository = procesoRepository;
    }

    public List<Proceso> getProcesos(){
        return procesoRepository.findAll();
    }
}
