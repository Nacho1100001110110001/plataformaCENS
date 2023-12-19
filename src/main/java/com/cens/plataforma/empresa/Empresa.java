package com.cens.plataforma.empresa;

import java.util.HashSet;
import java.util.Set;

import com.cens.plataforma.etapa.Etapa;
import com.cens.plataforma.logica_proceso.nota_proceso.NotaProceso;
import com.cens.plataforma.logica_proceso.proceso_usuario_empresa.ProcesoUsuarioEmpresa;
import com.cens.plataforma.usuario.Usuario;

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

@Entity(name = "empresa")
@Table(name = "empresa")
@Data
public class Empresa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Long idEmpresa;
    
    @Column(name = "rut_empresa")
    private String rutEmpresa;

    @Column(name = "nom_emp")
    private String nombre;
    
    @Column(name = "email_emp")
    private String email;

    @Column(name = "encargado_emp")
    private String encargado;

    @Column(name = "encargado_run_emp")
    private String encargadoRun;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "contacto_emp")
    private String contacto;

    @OneToMany(mappedBy = "empresa")
    private Set<ProcesoUsuarioEmpresa> pUE = new HashSet<>();

    @OneToMany(mappedBy = "empresa")
    private Set<NotaProceso> notaProceso = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_etapa")
    private Etapa etapa;

    public Empresa(Long idEmpresa, String rutEmpresa, String nombre, String email, String encargado,
            String encargadoRun, String razonSocial, String contacto) {
        this.idEmpresa = idEmpresa;
        this.rutEmpresa = rutEmpresa;
        this.nombre = nombre;
        this.email = email;
        this.encargado = encargado;
        this.encargadoRun = encargadoRun;
        this.razonSocial = razonSocial;
        this.contacto = contacto;
    }

    public Empresa() {
    }

    public Empresa(String rutEmpresa, String nombre, String email, String encargado, String encargadoRun,
            String razonSocial, String contacto) {
        this.rutEmpresa = rutEmpresa;
        this.nombre = nombre;
        this.email = email;
        this.encargado = encargado;
        this.encargadoRun = encargadoRun;
        this.razonSocial = razonSocial;
        this.contacto = contacto;
    }
}
