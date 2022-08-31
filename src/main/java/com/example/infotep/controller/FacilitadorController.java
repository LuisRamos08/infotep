package com.example.infotep.controller;

import com.example.infotep.model.Facilitador;
import com.example.infotep.service.FacilitadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping(value = "/facilitadores")
public class FacilitadorController {
    @Autowired
    FacilitadorService facilitadorService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Facilitador>> getAllFacilitadors(){
        try{
            List<Facilitador> facilitadorList = facilitadorService.getAllFacilitadores();
            return new ResponseEntity<>(facilitadorList, HttpStatus.OK);
        }catch (HttpClientErrorException.NotFound notFound){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/getFacilitadorById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity getFacilitadorById(@PathVariable("id") Integer id){
        try{
            return new ResponseEntity<>(facilitadorService.getFacilitadorById(id),HttpStatus.OK);
        }catch (HttpClientErrorException.NotFound notFound){
            return new ResponseEntity<>("Facilitador with id: " + id + " not found",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/saveFacilitador",produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Facilitador> saveFacilitador(@RequestBody Facilitador facilitador){
        try{
            facilitadorService.saveFacilitador(facilitador);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(facilitador, HttpStatus.CREATED);
    }

    @PutMapping(value = "/modifyFacilitador/{id}")
    public ResponseEntity<Facilitador> modifyFacilitador(@PathVariable Integer id, @RequestBody Facilitador facilitador){
        try{
            Facilitador facilitadorModified = facilitadorService.modifyFacilitador(id,facilitador);
            return new ResponseEntity<>(facilitadorModified, HttpStatus.OK);
        }catch (HttpClientErrorException.NotFound notFound){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/deleteFacilitador/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Facilitador> deleteById(@PathVariable("id") Integer id) {
        Facilitador facilitadorToDelete;
        try {
            facilitadorToDelete = facilitadorService.deleteFacilitador(id);
            return new ResponseEntity<>(facilitadorToDelete, HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
