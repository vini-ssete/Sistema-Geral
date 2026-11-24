/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gm.sistema.controller;

import com.gm.sistema.domain.model.Pet;
import com.gm.sistema.domain.model.Sexo;
import com.gm.sistema.repository.PetRepository;
import com.gm.sistema.service.PetService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/Pet")
public class PetController {
    @Autowired
    private  PetRepository petRepository;
    
    @Autowired
    private PetService petService;
    
    @GetMapping
    public List<Pet> todos() {
    return petRepository.findAll();
    }
    
    @GetMapping ("/{sexo}")
    public List<Pet> buscarPorSexo(@PathVariable Sexo sexo) {
         return petRepository.findBySexo(sexo);
    }
    
    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Pet adicionar(@Valid @RequestBody Pet pet) {
        return petRepository.save(pet);
    }
    
    @PutMapping ("/{petID}")
    public ResponseEntity<Pet> atualizar (@Valid @PathVariable Long petID,
                                                @RequestBody Pet pet) {
        if (!petRepository.existsById(petID)) {
            return ResponseEntity.notFound().build();
        }
        pet.setId(petID);
        pet = petRepository.save(pet);
        return ResponseEntity.ok(pet);
    }
    
    @DeleteMapping ("/{petID}")
    public ResponseEntity<Void> excluir(@PathVariable Long petID) {
        if (!petRepository.existsById(petID)) {
            return ResponseEntity.notFound().build();
        }
        petRepository.deleteById(petID);
        return ResponseEntity.noContent().build();
    }
    
}
