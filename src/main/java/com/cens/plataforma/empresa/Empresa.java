package com.cens.plataforma.empresa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name= "empresa")
@Table(name= "empresa")
public class Empresa {
    @Id
    @SequenceGenerator(
        name= "secuencia_empresa",
        sequenceName = "secuencia_empresa",
        allocationSize = 1,
        initialValue = 6
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "secuencia_empresa"
    )
    
    private Long rutEmpresa;
    
    @Column(
        name = "nomEmp"
    )  
    private String nombre; 
    @Column(
        name = "id_User"
    )
    private int iduser;

    @Column(
        name = "emailEmp"
    )
    private String email;

    @Column(
        name = "EcargadoEmp"
    )
    private String encargado;

    @Column(
        name = "EncargadoRun_Emp"
    )
    private String runEcargado;

    @Column(
        name = "RazonSocial"
    )
    private String razonSocial;

    @Column(
        name = "ContactoEmp"
    )
    private String contactoEmp;

    public Empresa(Long rutEmpresa, int iduser, String email, String encargado, String runEncargado, 
            String razonSocial, String contactoEmp){
                
    }

    public Empresa(int id_user, String emailEmp, String Encargado_Emp, String EncargadoRun_Emp, 
            String RazonSocial, String ContactoEmp){
                
    }

}
