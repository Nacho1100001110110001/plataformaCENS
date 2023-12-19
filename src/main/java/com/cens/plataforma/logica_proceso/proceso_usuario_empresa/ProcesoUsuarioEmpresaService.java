package com.cens.plataforma.logica_proceso.proceso_usuario_empresa;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProcesoUsuarioEmpresaService {
    private final ProcesoUsuarioEmpresaRepository procesoUsuarioEmpresaRepository;

    public List<ProcesoUsuarioEmpresa> getPUE(){
        return procesoUsuarioEmpresaRepository.findAll();
    }

    public void addNewPUE(ProcesoUsuarioEmpresa pue){
        procesoUsuarioEmpresaRepository.save(pue);
    }

    public void deleteByIdEmpresa(Long idEmpresa){
        List<ProcesoUsuarioEmpresa> pues = procesoUsuarioEmpresaRepository.findByIdEmpresa(idEmpresa);
        for(ProcesoUsuarioEmpresa pue : pues) procesoUsuarioEmpresaRepository.deleteById(pue.getIdPUE());
    }
}
