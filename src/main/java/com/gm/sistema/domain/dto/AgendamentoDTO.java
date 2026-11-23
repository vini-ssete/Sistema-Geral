/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gm.sistema.domain.dto;

import java.time.LocalDateTime;
import org.antlr.v4.runtime.misc.NotNull;

/**
 *
 * @author digma
 */
public class AgendamentoDTO {
    @NotNull            
    Long idPet;
    @NotNull
    LocalDateTime dataConsulta;

    public Long getIdPet() {
        return idPet;
    }

    public void setIdPet(Long idPet) {
        this.idPet = idPet;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public AgendamentoDTO() {
    }

    public AgendamentoDTO(Long idPet, LocalDateTime dataConsulta) {
        this.idPet = idPet;
        this.dataConsulta = dataConsulta;
    }
    
    
}
