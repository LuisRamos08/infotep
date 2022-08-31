package com.example.infotep.controller;

import com.example.infotep.model.ParticipantesCursos;
import com.example.infotep.service.ParticipantesCursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/participantesCursos")
public class ParticipantesCursosController {
    @Autowired
    ParticipantesCursosService participantesCursosService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<ParticipantesCursos>> getAllParticipantesCursoss(){
        try{
            List<ParticipantesCursos> participantesCursosList = participantesCursosService.getAllParticipantesCursos();
            return new ResponseEntity<>(participantesCursosList, HttpStatus.OK);
        }catch (HttpClientErrorException.NotFound notFound){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
