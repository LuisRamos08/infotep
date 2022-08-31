package com.example.infotep.controller;

import com.example.infotep.model.Participante;
import com.example.infotep.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping(value = "/participantes")
public class ParticipanteController {
    @Autowired
    ParticipanteService participanteService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Participante>> getAllParticipantes(){
        try{
            List<Participante> participanteList = participanteService.getAllParticipantes();
            return new ResponseEntity<>(participanteList, HttpStatus.OK);
        }catch (HttpClientErrorException.NotFound notFound){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/getParticipanteById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity getParticipanteById(@PathVariable("id") Integer id){
        try{
            return new ResponseEntity<>(participanteService.getParticipanteById(id),HttpStatus.OK);
        }catch (HttpClientErrorException.NotFound notFound){
            return new ResponseEntity<>("Participante with id: " + id + " not found",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/saveParticipante",produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Participante> saveParticipante(@RequestBody Participante participante){
        try{
            participanteService.saveParticipante(participante);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(participante, HttpStatus.CREATED);
    }

    @PutMapping(value = "/modifyParticipante/{id}")
    public ResponseEntity<Participante> modifyParticipante(@PathVariable Integer id, @RequestBody Participante participante){
        try{
            Participante participanteModified = participanteService.modifyParticipante(id,participante);
            return new ResponseEntity<>(participanteModified, HttpStatus.OK);
        }catch (HttpClientErrorException.NotFound notFound){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/deleteParticipante/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Participante> deleteById(@PathVariable("id") Integer id) {
        Participante participanteToDelete;
        try {
            participanteToDelete = participanteService.deleteParticipante(id);
            return new ResponseEntity<>(participanteToDelete, HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
