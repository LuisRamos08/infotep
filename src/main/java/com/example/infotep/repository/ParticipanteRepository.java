package com.example.infotep.repository;

import com.example.infotep.model.Participante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipanteRepository extends CrudRepository<Participante,Integer> {
}
