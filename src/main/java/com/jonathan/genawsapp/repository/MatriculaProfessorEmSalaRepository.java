package com.jonathan.genawsapp.repository;


import com.jonathan.genawsapp.domain.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaProfessorEmSalaRepository extends JpaRepository<Professor, Long> {
}
