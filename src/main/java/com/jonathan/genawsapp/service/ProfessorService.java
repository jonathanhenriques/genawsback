package com.jonathan.genawsapp.service;

import com.jonathan.genawsapp.domain.model.Professor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProfessorService {



    List<Professor> findAll();

    Professor buscarOuFalhar(Long professorId);

    Professor cadastrar(Professor professor);

    Professor atualizar(Professor professor);

    @Transactional
    void ativar(Long professorId);
    @Transactional
    void desativar(Long professorId);

    Professor matriculaProfessorEmSala(Long professorId, Long salaId);

}
