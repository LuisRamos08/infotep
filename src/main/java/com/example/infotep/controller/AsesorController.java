package com.example.infotep.controller;

import com.example.infotep.model.Asesor;
import com.example.infotep.service.AsesorService;
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
@RequestMapping("/asesores")
public class AsesorController {
    @Autowired
    AsesorService asesorService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Asesor>> getAllAsesores(){
        try{
            List<Asesor> asesorList = asesorService.getAllAsesores();
            return new ResponseEntity<>(asesorList, HttpStatus.OK);
        }catch (HttpClientErrorException.NotFound notFound){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
