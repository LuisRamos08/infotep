package com.example.infotep.service;

import com.example.infotep.model.Horario;
import com.example.infotep.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HorarioService {
    private final HorarioRepository horarioRepository;

    @Autowired
    public HorarioService(HorarioRepository horarioRepository){this.horarioRepository = horarioRepository;}

    public List<Horario> getAllHorarios(){
        return StreamSupport
                .stream(horarioRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }
}
