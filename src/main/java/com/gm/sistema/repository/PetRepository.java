/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gm.sistema.repository;

import com.gm.sistema.domain.model.Pet;
import com.gm.sistema.domain.model.Sexo;
import com.gm.sistema.domain.model.Tutor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digma
 */
@Repository
public interface PetRepository extends JpaRepository<Pet, Object>{
    List<Pet> findBySexo(Sexo sexo);
    List<Pet> findByTutorId(Long tutor_id);
    List<Pet> findByTutorNomeContainingIgnoreCase(String nome);
}
