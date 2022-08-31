package com.example.infotep.repository;

import com.example.infotep.model.Facilitador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilitadorRepository extends CrudRepository<Facilitador,Integer> {
}
