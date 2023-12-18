package com.cens.plataforma.logica_proceso.proceso;

import java.util.HashSet;
import java.util.Set;

import com.cens.plataforma.logica_proceso.nota_proceso.NotaProceso;
import com.cens.plataforma.logica_proceso.tipo_proceso.TipoProceso;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "proceso")
@Table(name = "proceso")
@Data
public class Proceso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proceso")
    private Long idTipoProceso;

    @Column(name = "nom_proceso")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_tipo_proceso")
    private TipoProceso tipoProceso;

    @OneToMany(mappedBy = "proceso")
    private Set<NotaProceso> notaProceso = new HashSet<>();
}
