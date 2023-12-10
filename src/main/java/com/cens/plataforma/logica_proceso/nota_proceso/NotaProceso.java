package com.cens.plataforma.logica_proceso.nota_proceso;

import com.cens.plataforma.empresa.Empresa;
import com.cens.plataforma.logica_proceso.proceso.Proceso;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "nota_proceso")
@Table(name = "nota_proceso")
@Data
@NoArgsConstructor
public class NotaProceso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota_proceso")
    private Long idNotaProceso;

    @Column(name = "puntaje")
    private int puntaje;

    @Column(name = "comentario")
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "id_proceso")
    private Proceso proceso;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;
}
