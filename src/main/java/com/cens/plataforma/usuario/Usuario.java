package com.cens.plataforma.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "usuario")
@Table(name = "usuario")
@Getter
@Setter
public class Usuario {
    @Id
    @SequenceGenerator(
        name = "secuencia_usuario",
        sequenceName = "secuencia_usuario",
        allocationSize = 1,
        initialValue = 6
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "secuencia_usuario"
    )
    
    private Long iduser;
    
    @Column(
        name = "nomuser"
    )
    private String nombre;
    
    @Column(
        name = "apellP"
    )
    private String apellidoP;
    
    @Column(
        name = "apellM"
    )
    private String apellidoM;
    
    @Column(
        name = "emailuser"
    )
    private String email;
    
    @Column(
        name = "passuser"
    )
    private String password;
    
    @Column(
        name = "id_Rol"
    )
    private Long idRol;
    
    public Usuario(Long id, String nombre, String apellidoP, String apellidoM, String email, String password,
            Long idRol) {
        this.iduser = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.email = email;
        this.password = password;
        this.idRol = idRol;
    }

    public Usuario(String nombre, String apellidoP, String apellidoM, String email, String password, Long idRol) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.email = email;
        this.password = password;
        this.idRol = idRol;
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario [iduser=" + iduser + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM="
                + apellidoM + ", email=" + email + ", password=" + password + ", idRol=" + idRol + "]";
    }
}
