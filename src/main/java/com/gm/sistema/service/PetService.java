/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gm.sistema.service;

import com.gm.sistema.domain.exception.DomainException;
import com.gm.sistema.domain.model.Pet;
import com.gm.sistema.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.gm.sistema.domain.model.Sexo;
import java.util.Optional;

/**
 *
 * @author digma
 */
@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;
    
    
    @Component
    public class StringToSexoPetConverter implements Converter<String, Sexo> {
    
    @Override
    public Sexo convert(String sexo) {
        return Sexo.valueOf(sexo.trim().toUpperCase());
        }
    }
    
    
}
