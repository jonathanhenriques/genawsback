package com.jonathan.genaws.repository;

import com.jonathan.genaws.domain.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long>{
//        Optional<Sala> findSalaByCodigo(String codigoSala);
//
//        Optional<Sala> findSalaByAluno(String codigoAluno);
//
//        Optional<Sala> findSalaByProfessor(String codigoProfessor);



}
