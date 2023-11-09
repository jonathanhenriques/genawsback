package com.jonathan.genaws.repository;

import com.jonathan.genaws.domain.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    Optional<Professor> findProfessorByCodigo(String codigoProfessor);

//    List<Professor> findAllBySala(Sala sala);


}

