/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gm.sistema.controller;

import com.gm.sistema.domain.model.Tutor;
import com.gm.sistema.repository.TutorRepository;
import com.gm.sistema.service.TutorService;
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
    
}
