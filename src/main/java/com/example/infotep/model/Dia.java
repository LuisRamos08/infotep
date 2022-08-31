package com.example.infotep.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "dias")
public class Dia {
    @Id
    @GeneratedValue
    @Column(name = "IDDia")
    private Integer idDia;

    @Column(name = "Nombre")
    private String nombre;
}
