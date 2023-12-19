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
}
