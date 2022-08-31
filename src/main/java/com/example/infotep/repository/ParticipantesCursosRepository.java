package com.example.infotep.repository;

import com.example.infotep.model.ParticipantesCursos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantesCursosRepository extends CrudRepository<ParticipantesCursos,Integer> {
}
