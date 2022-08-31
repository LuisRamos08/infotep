package com.example.infotep.controller;

import com.example.infotep.Utils.UUID;
import com.example.infotep.model.Curso;
import com.example.infotep.model.Firma;
import com.example.infotep.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    CursoService cursoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Curso>> getAllCursos(){
        try{
            List<Curso> cursoList = cursoService.getAllCursos();
            return new ResponseEntity<>(cursoList,HttpStatus.OK);
        }catch (HttpClientErrorException.NotFound notFound){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity getCursoById(@PathVariable("id") Integer id){
        try{
            return new ResponseEntity<>(cursoService.getCursoById(id),HttpStatus.OK);
        }catch (HttpClientErrorException.NotFound notFound){
            return new ResponseEntity<>("Curso with id: " + id + " not found",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/saveCurso",produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Curso> saveCurso(@RequestBody Curso curso){
        try{
            cursoService.saveCurso(curso);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(curso, HttpStatus.CREATED);
    }

    @PutMapping(value = "/modifyCurso/{id}")
    public ResponseEntity<Curso> modifyCurso(@PathVariable Integer id, @RequestBody Curso curso){
        try{
            Curso cursoModified = cursoService.modifyCurso(id,curso);
            return new ResponseEntity<>(cursoModified, HttpStatus.OK);
        }catch (HttpClientErrorException.NotFound notFound){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/deleteCurso/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Curso> deleteById(@PathVariable("id") Integer id) {
        Curso cursoToDelete;
        try {
            cursoToDelete = cursoService.deleteCurso(id);
            return new ResponseEntity<>(cursoToDelete, HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getuuid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Curso> getUuid(@PathVariable("id") Integer id){
        Curso c = cursoService.getCursoById(id);
        if(c != null){
            c.setUuid(UUID.generate());
            cursoService.saveCurso(c);
            return ResponseEntity.ok(c);
        }else return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/firmar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity firmar(@RequestBody Firma firma){
        /**
         * 1. Buscar el curso con el uuid
         * 2. si no se encuentra el curso returnar un nofond
         * 3. buscar si la cedula esta incluida en el curso
         * 4. si cedula no esta en el curso retornar un no found
         * 5. grabar en la tabla lista el registro correspondiente
         *
         */


        return ResponseEntity.noContent().build();
    }
}
