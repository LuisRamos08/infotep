package com.example.infotep.service;

import com.example.infotep.model.Participante;
import com.example.infotep.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ParticipanteService {
    private final ParticipanteRepository participanteRepository;

    @Autowired
    public ParticipanteService(ParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }

    public Participante saveParticipante(Participante participante){return  participanteRepository.save(participante);}

    public List<Participante> getAllParticipantes(){
        return StreamSupport
                .stream(participanteRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    public Participante getParticipanteById(Integer id){
        return participanteRepository.findById(id).orElseThrow(() ->
                new RuntimeException(id.toString()));
    }

    public Participante deleteParticipante(Integer id){
        Participante participante = this.getParticipanteById(id);
        participanteRepository.delete(participante);
        return participante;
    }

    @Transactional
    public Participante modifyParticipante(Integer id, Participante participante){
        Participante participanteToEdit = this.getParticipanteById(id);
        setParticipante(participanteToEdit,participante);
        return participanteToEdit;
    }

    private void setParticipante(Participante participanteToEdit, Participante participante) {
        participanteToEdit.setCedula(participante.getCedula());
        participanteToEdit.setNombre(participante.getApellido());
        participanteToEdit.setApellido(participante.getApellido());
        participanteToEdit.setTelefono(participante.getTelefono());
    }
}
