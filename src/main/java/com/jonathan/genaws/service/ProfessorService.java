package com.jonathan.genaws.service;

import com.jonathan.genaws.domain.model.Professor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProfessorService {


//    Professor findByNomeProfessorAluno(String nomeProfessor);
//    Professor findByNomeProfessor(Professor nomeProfessor);

     List<Professor> findAll();

//     List<Professor> findAllBySala(Sala sala);

     Professor buscarOuFalhar(Long professorId);

     Professor cadastrar(Professor professor);

     Professor atualizar(Professor professor);

    @Transactional
     void ativar(Long professorId);
    @Transactional
     void desativar(Long professorId);

}
