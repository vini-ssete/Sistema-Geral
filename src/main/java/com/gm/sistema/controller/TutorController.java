/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gm.sistema.controller;

import com.gm.sistema.domain.model.Pet;
import com.gm.sistema.domain.model.Sexo;
import com.gm.sistema.domain.model.Tutor;
import com.gm.sistema.domain.model.Tutor;
import com.gm.sistema.repository.TutorRepository;
import com.gm.sistema.service.TutorService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digma
 */
@RestController
@RequestMapping("/Tutor")
public class TutorController {
    @Autowired
    private  TutorRepository tutorRepository;
    
    @Autowired
    private TutorService tutorService;
    
    @GetMapping
    public List<Tutor> todos() {
    return tutorRepository.findAll();
    }
    
    @GetMapping ("/{tutorID}")
    public ResponseEntity<Tutor> buscar(@PathVariable Long tutorID) {
        
        Optional<Tutor> tutor = tutorRepository.findById(tutorID);
        
        if (tutor.isPresent()) {
            return ResponseEntity.ok(tutor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Tutor adicionar(@Valid @RequestBody Tutor tutor) {
        return tutorRepository.save(tutor);
    }
    
    @PutMapping ("/{tutorID}")
    public ResponseEntity<Tutor> atualizar (@Valid @PathVariable Long tutorID,
                                                @RequestBody Tutor tutor) {
        if (!tutorRepository.existsById(tutorID)) {
            return ResponseEntity.notFound().build();
        }
        tutor.setId(tutorID);
        tutor = tutorRepository.save(tutor);
        return ResponseEntity.ok(tutor);
    }
    
    @DeleteMapping ("/{tutorID}")
    public ResponseEntity<Void> excluir(@PathVariable Long tutorID) {
        if (!tutorRepository.existsById(tutorID)) {
            return ResponseEntity.notFound().build();
        }
        tutorRepository.deleteById(tutorID);
        return ResponseEntity.noContent().build();
    }
    
}

