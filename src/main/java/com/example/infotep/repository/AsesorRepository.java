package com.example.infotep.repository;

import com.example.infotep.model.Asesor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsesorRepository extends CrudRepository<Asesor,Integer> {
}
