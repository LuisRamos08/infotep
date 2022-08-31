package com.example.infotep.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "participantesCursos")
public class ParticipantesCursos {
    @Id
    @GeneratedValue
    @Column(name = "IDParticipantescursos")
    private Integer idParticipantesCursos;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "IDParticipante")
    private Participante idParticipante;

    /*@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "IDCurso")
    private Curso curso;*/

    @Column(name = "Estado")
    private int estado;
}
