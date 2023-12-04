package com.cens.plataforma.empresa;

import com.cens.plataforma.usuario.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "empresa")
@Table(name = "empresa")
@Getter
@Setter
public class Empresa {
    
    @Id
    @Column(name = "rutempresa")
    private String rutEmpresa;

    @Column(name = "nomemp")
    private String nombre;
    
    @Column(name = "emailemp")
    private String email;

    @Column(name = "encargadoemp")
    private String encargado;

    @Column(name = "encargadorun_emp")
    private String encargadoRun;

    @Column(name = "razonsocial")
    private String razonSocial;

    @Column(name = "contactoemp")
    private String contacto;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private Usuario usuario;

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

    @Override
    public String toString() {
        return "Empresa [rutEmpresa=" + rutEmpresa + ", nombre=" + nombre + ", email=" + email
                + ", encargado=" + encargado + ", encaargadoRun=" + encargadoRun + ", razonSocial=" + razonSocial
                + ", contacto=" + contacto + "]";
    }
}
