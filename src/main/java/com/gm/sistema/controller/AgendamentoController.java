/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gm.sistema.controller;

import com.gm.sistema.domain.model.Agendamento;
import com.gm.sistema.repository.AgendamentoRepository;
import com.gm.sistema.service.AgendamentoService;
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
@RequestMapping("/Agendamento")
public class AgendamentoController {
    @Autowired
    private  AgendamentoRepository agendamentoRepository;
    
    @Autowired
    private AgendamentoService agendamentoService;
    
    @GetMapping
    public List<Agendamento> todos() {
    return agendamentoRepository.findAll();
    }
    
}
