package com.example.infotep.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class Lista {
    @Id
    @GeneratedValue
    @Column(name = "IDLista")
    private Integer idLista;

    @Column(name = "IDParticipantesCursos")
    private int idParticipantesCursos;

    @Column(name = "Fecha")
    private Date fecha;

    @Column(name = "Hora")
    private String hora;

    @Column(name = "Comentario")
    private String comentario;
}
