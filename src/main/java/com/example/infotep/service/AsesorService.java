package com.example.infotep.service;

import com.example.infotep.model.Asesor;
import com.example.infotep.repository.AsesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AsesorService {
    private final AsesorRepository asesorRepository;

    @Autowired
    public AsesorService(AsesorRepository asesorRepository){this.asesorRepository = asesorRepository;}

    public List<Asesor> getAllAsesores(){
        return StreamSupport
                .stream(asesorRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }
}
