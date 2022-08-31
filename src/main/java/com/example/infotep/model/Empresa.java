package com.example.infotep.model;

import lombok.Data;
import org.springframework.boot.context.properties.bind.Name;

import javax.persistence.*;

@Data
@Entity
@Table(name = "empresas")
public class Empresa {
    @Id
    @GeneratedValue
    @Column(name = "IDEmpresa")
    private Integer idEmpresa;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Direccion")
    private String direccion;

    @Column(name = "Telefono")
    private String telefono;

    @Column(name = "Encargado")
    private String encargado;
}
