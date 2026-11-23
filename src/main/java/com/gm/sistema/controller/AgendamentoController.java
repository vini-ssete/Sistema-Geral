/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gm.sistema.controller;

import com.gm.sistema.domain.dto.AgendamentoDTO;
import com.gm.sistema.domain.model.Agendamento;
import com.gm.sistema.repository.AgendamentoRepository;
import com.gm.sistema.service.AgendamentoService;
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
    
    @GetMapping("/id/{id}")
    public Optional<Agendamento> porId(@PathVariable long id){
    return agendamentoRepository.findById(id); 
    }
    
     @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Agendamento> AtualizaSaldo( //@Valid 
    @RequestBody AgendamentoDTO agendamentoDTO){
        Agendamento newAgendamento = agendamentoService.atualizaConsulta(agendamentoDTO.getIdPet(), agendamentoDTO.getDataConsulta());
        return ResponseEntity.status(HttpStatus.CREATED).body(newAgendamento);
    }
    
    @PutMapping("/id/{agendamentoID}")
    public ResponseEntity<Agendamento> atualizar(//@Valid 
    @PathVariable Long agendamentoID,
                                            @RequestBody Agendamento agendamento){
    //verifica se existe o agendamento
        if(!agendamentoRepository.existsById(agendamentoID)) {
     return ResponseEntity.notFound().build();
        }
        
    agendamento.setId(agendamentoID);
    agendamento = agendamentoRepository.save(agendamento);  //agendamentoService.salvar(agendamento);
    return ResponseEntity.ok(agendamento);
    }
    
    @DeleteMapping("/id/{agendamentoID}")
    public ResponseEntity<Void> excluir(@PathVariable Long agendamentoID){
    //verifica se existe ou nao
    if(!agendamentoRepository.existsById(agendamentoID)){
    return ResponseEntity.notFound().build();
    }
    
    //agendamentoService.excluir(agendamentoID);
    agendamentoRepository.deleteById(agendamentoID);
    return ResponseEntity.noContent().build();
    }
    
}
