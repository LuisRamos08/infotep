package com.example.infotep.service;

import com.example.infotep.model.ParticipantesCursos;
import com.example.infotep.repository.ParticipantesCursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ParticipantesCursosService {
    private final ParticipantesCursosRepository participantesCursosRepository;

    @Autowired
    public ParticipantesCursosService(ParticipantesCursosRepository participantesCursosRepository){this.participantesCursosRepository = participantesCursosRepository;}

    public List<ParticipantesCursos> getAllParticipantesCursos(){
        return StreamSupport
                .stream(participantesCursosRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }
}
