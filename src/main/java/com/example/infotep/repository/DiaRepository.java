package com.example.infotep.repository;

import com.example.infotep.model.Dia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaRepository extends CrudRepository<Dia,Integer> {
}
