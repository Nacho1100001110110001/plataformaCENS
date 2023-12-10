package com.cens.plataforma.logica_proceso.tipo_proceso;

import java.util.HashSet;
import java.util.Set;

import com.cens.plataforma.logica_proceso.proceso.Proceso;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "tipo_proceso")
@Table(name = "tipo_proceso")
@Data
public class TipoProceso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_proceso")
    private Long idTipoProceso;

    @Column(name = "nom_tipo_proceso")
    private String nombre;

    @OneToMany(mappedBy = "tipo_proceso")
    private Set<Proceso> procesos = new HashSet<>();
}
