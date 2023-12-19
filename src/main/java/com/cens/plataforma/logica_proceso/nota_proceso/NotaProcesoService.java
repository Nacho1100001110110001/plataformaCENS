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

    public void addNewNotaProceso(NotaProceso notaProceso){
        notaProcesoRepository.save(notaProceso);
    }

    public void deleteByIdEmpresa(Long idEmpresa) {
        List<NotaProceso> notas = notaProcesoRepository.findByIdEmpresa(idEmpresa);
        for(NotaProceso n: notas) notaProcesoRepository.deleteById(n.getIdNotaProceso());
    }
}
