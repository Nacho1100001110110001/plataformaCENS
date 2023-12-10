package com.cens.plataforma.usuario;

import java.util.HashSet;
import java.util.Set;

import com.cens.plataforma.empresa.Empresa;
import com.cens.plataforma.rol.Rol;

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

@Entity(name = "usuario")
@Table(name = "usuario")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;
    
    @Column(name = "nom_user")
    private String nombre;
    
    @Column(name = "apell_p")
    private String apellidoP;
    
    @Column(name = "apell_m")
    private String apellidoM;
    
    @Column(name = "email_user")
    private String email;
    
    @Column(name = "pass_user")
    private String password;
    
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @OneToMany(mappedBy = "usuario")
    private Set<Empresa> empresas = new HashSet<>();
    
    public Usuario(Long id, String nombre, String apellidoP, String apellidoM, String email, String password,
            Rol rol) {
        this.idUser = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public Usuario(String nombre, String apellidoP, String apellidoM, String email, String password, Rol rol) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public Usuario() {
    }
}
