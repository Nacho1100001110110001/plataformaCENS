package com.cens.plataforma.etapa;


import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EtapaService {
    private final EtapaRepository etapaRepository;

    public EtapaService(EtapaRepository etapaRepository) {
        this.etapaRepository = etapaRepository;
    }

    public List<Etapa> getEtapa(){
        return etapaRepository.findAll();
    }
}
