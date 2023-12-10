package com.cens.plataforma.logica_proceso.nota_proceso;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NotaProcesoService {
    private final NotaProcesoRepository notaProcesoRepository;

    public NotaProcesoService(NotaProcesoRepository notaProcesoRepository) {
        this.notaProcesoRepository = notaProcesoRepository;
    }

    public List<NotaProceso> getNotaProceso(){
        return notaProcesoRepository.findAll();
    }
}
