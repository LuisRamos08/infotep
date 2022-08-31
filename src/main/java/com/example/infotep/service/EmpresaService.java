package com.example.infotep.service;

import com.example.infotep.model.Empresa;
import com.example.infotep.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository){this.empresaRepository = empresaRepository;}

    public List<Empresa> getAllEmpresas(){
        return StreamSupport
                .stream(empresaRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }
}
