/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gm.sistema.controller;

import com.gm.sistema.domain.model.Pet;
import com.gm.sistema.repository.PetRepository;
import com.gm.sistema.service.PetService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
}
