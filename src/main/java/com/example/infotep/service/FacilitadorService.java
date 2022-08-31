package com.example.infotep.service;

import com.example.infotep.model.Facilitador;
import com.example.infotep.repository.FacilitadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FacilitadorService {
    private final FacilitadorRepository facilitadorRepository;

    @Autowired
    public FacilitadorService(FacilitadorRepository facilitadorRepository){this.facilitadorRepository = facilitadorRepository;}

    public Facilitador saveFacilitador(Facilitador facilitador){return facilitadorRepository.save(facilitador);}

    public List<Facilitador> getAllFacilitadores(){
        return StreamSupport
                .stream(facilitadorRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    public Facilitador getFacilitadorById(Integer id){
        return facilitadorRepository.findById(id).orElseThrow(() ->
                new RuntimeException(id.toString()));
    }

    public Facilitador deleteFacilitador(Integer id){
        Facilitador facilitador = this.getFacilitadorById(id);
        facilitadorRepository.delete(facilitador);
        return facilitador;
    }

    @Transactional
    public Facilitador modifyFacilitador(Integer id, Facilitador facilitador){
        Facilitador facilitadorToEdit = this.getFacilitadorById(id);
        setFacilitador(facilitadorToEdit,facilitador);
        return facilitadorToEdit;
    }

    private void setFacilitador(Facilitador facilitadorToEdit, Facilitador facilitador) {
        facilitadorToEdit.setNombre(facilitador.getNombre());
        facilitadorToEdit.setApellido(facilitador.getApellido());
        facilitadorToEdit.setUsuario(facilitador.getUsuario());
        facilitadorToEdit.setClave(facilitador.getClave());
    }
}
