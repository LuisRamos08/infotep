package com.example.infotep.controller;

import com.example.infotep.model.Dia;
import com.example.infotep.service.DiaService;
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
@RequestMapping("/dias")
public class DiaController {
    @Autowired
    DiaService diaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Dia>> getAllDias(){
        try{
            List<Dia> diaList = diaService.getAllDias();
            return new ResponseEntity<>(diaList, HttpStatus.OK);
        }catch (HttpClientErrorException.NotFound notFound){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
