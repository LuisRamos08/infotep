package com.example.infotep.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "participantes")
public class Participante {
    @Id
    @GeneratedValue
    @Column(name = "IDParticipante")
    private Integer idParticipante;

    @Column(name = "Cedula")
    private String cedula;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "Telefono")
    private String telefono;

    @Column(name = "Sexo")
    private char sexo;
}
