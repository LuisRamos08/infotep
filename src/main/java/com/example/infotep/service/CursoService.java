package com.example.infotep.service;

import com.example.infotep.model.Curso;
import com.example.infotep.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CursoService {
    private final CursoRepository cursosRepository;

    @Autowired
    public CursoService(CursoRepository cursosRepository){
        this.cursosRepository = cursosRepository;
    }

    public Curso saveCurso(Curso curso){return cursosRepository.save(curso);}

    public List<Curso> getAllCursos(){
        return StreamSupport
                .stream(cursosRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    public Curso getCursoById(Integer id){
        return cursosRepository.findById(id).orElseThrow(() ->
                new RuntimeException(id.toString()));
    }

    public Curso deleteCurso(Integer id){
        Curso curso = this.getCursoById(id);
        cursosRepository.delete(curso);
        return curso;
    }

    @Transactional
    public Curso modifyCurso(Integer id, Curso curso){
        Curso cursoToEdit = this.getCursoById(id);
        setCurso(cursoToEdit,curso);
        return cursoToEdit;
    }

    private void setCurso(Curso cursoToEdit, Curso curso) {
        cursoToEdit.setCodigo(curso.getCodigo());
        cursoToEdit.setNombre(curso.getNombre());
        cursoToEdit.setHorarios(curso.getHorarios());
        cursoToEdit.setFechaInicio(curso.getFechaInicio());
        cursoToEdit.setFechaTermino(curso.getFechaTermino());
        cursoToEdit.setHoras(curso.getHoras());
    }
}
