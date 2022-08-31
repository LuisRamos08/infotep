package com.example.infotep.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "facilitadores")
public class Facilitador {
    @Id
    @GeneratedValue
    @Column(name = "IDFacilitador")
    private Integer idFacilitador;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "Usuario")
    private String usuario;

    @Column(name = "Clave")
    private String clave;
}
