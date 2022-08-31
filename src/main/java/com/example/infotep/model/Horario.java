package com.example.infotep.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "horarios")
public class Horario {
    @Id
    @GeneratedValue
    @Column(name = "IDHorario")
    private Integer idHorario;

    @Column(name = "IDCurso")
    private int idCurso;

    @Column(name = "Horainicia")
    private String horaInicia;
    @Column(name = "Horatermina")
    private String horaTermina;

    @Column(name = "Incluido")
    private boolean incluido;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "IDDia")
    private Dia dia;
}
