package com.cens.plataforma.etapa;

import java.util.HashSet;
import java.util.Set;

import com.cens.plataforma.empresa.Empresa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "etapa")
@Table(name = "etapa")
@Data
public class Etapa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etapa")
    private Long idEtapa;

    @Column(name = "nom_etapa")
    private String nombre;

    @OneToMany(mappedBy = "etapa")
    private Set<Empresa> empresas = new HashSet<>();
}
