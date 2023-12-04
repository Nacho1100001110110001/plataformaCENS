package com.cens.plataforma.rol;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "rol")
@Table(name = "rol")
@Getter
@Setter
public class Rol {
    @Id
    @SequenceGenerator(
        name = "secuencia_usuario",
        sequenceName = "secuencia_usuario",
        allocationSize = 1,
        initialValue = 5
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "secuencia_usuario"
    )
    @Column(name = "idrol")
    private Long idRol;

    @Column(name = "tiporol")
    private String nomRol;

    public Rol(String nomRol) {
        this.nomRol = nomRol;
    }

    public Rol() {
    }

    @Override
    public String toString() {
        return "Rol [idRol=" + idRol + ", nomRol=" + nomRol + "]";
    }
}
