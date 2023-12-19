package com.cens.plataforma.logica_proceso.proceso_usuario_empresa;

import com.cens.plataforma.empresa.Empresa;
import com.cens.plataforma.logica_proceso.proceso.Proceso;
import com.cens.plataforma.usuario.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "proceso_usuario_empresa")
@Table(name = "proceso_usuario_empresa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcesoUsuarioEmpresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proceso_usuario_etapa")
    Long idPUE;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = true)
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = true)
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "id_proceso", nullable = true)
    private Proceso proceso;
}
