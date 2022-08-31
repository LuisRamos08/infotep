package com.example.infotep.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue

    @Column(name = "IDCurso")
    private Integer idCurso;

    @Column(name = "Codigo")
    private long codigo;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Fechainicio")
    private Date fechaInicio;
    @Column(name = "Fechatermino")
    private Date fechaTermino;
    @Column(name = "Horas")
    private int horas;
    @Column(name = "Uuid")
    private String uuid;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "IDHorario")
    private List<Horario> horarios;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "IDEmpresa")
    private Empresa empresa;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "IDAsesor")
    private Asesor asesor;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "IDFacilitador")
    private Facilitador facilitador;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDCurso")
    private List<ParticipantesCursos> participantes;
}
