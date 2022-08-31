package com.example.infotep.repository;

import com.example.infotep.model.Horario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends CrudRepository<Horario,Integer> {
}
