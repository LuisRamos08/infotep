package com.example.infotep.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "asesores")
public class Asesor {
    @Id
    @GeneratedValue
    @Column(name = "IDAsesor")
    private Integer idAsesor;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
}
