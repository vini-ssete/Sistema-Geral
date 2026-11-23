/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gm.sistema.service;

import com.gm.sistema.domain.model.Agendamento;
import com.gm.sistema.domain.model.Pet;
import com.gm.sistema.repository.AgendamentoRepository;
import com.gm.sistema.repository.PetRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author digma
 */
@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository agendamentoRepository;
    
    @Autowired
    PetRepository petRepository;
    
    public Agendamento atualizaConsulta(Long idPet, LocalDateTime dataConsulta){
        //PetRepository petRepository = null;
     Pet pet = petRepository.findById(idPet).orElseThrow(()-> new RuntimeException("Pet não encontrado com o id" + idPet));
     Agendamento agendamento = new Agendamento(pet, dataConsulta);
     agendamentoRepository.save(agendamento);
     //pet.atualizaSaldo(dataConsulta);
    return agendamento;
    }
}
