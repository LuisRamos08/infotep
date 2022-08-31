package com.example.infotep.service;

import com.example.infotep.model.Dia;
import com.example.infotep.repository.DiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DiaService {
    private final DiaRepository diaRepository;

    @Autowired
    public DiaService(DiaRepository diaRepository){this.diaRepository = diaRepository;}

    public List<Dia> getAllDias(){
        return StreamSupport
                .stream(diaRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }
}
