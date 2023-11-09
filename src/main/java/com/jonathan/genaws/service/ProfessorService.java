package com.jonathan.genaws.service;

import com.jonathan.genaws.domain.model.Professor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProfessorService {


    public List<Professor> findAll();

//    public List<Professor> findAllBySala(Sala sala);

    public Professor buscarOuFalhar(Long professorId);

    public Professor cadastrar(Professor professor);

    public Professor atualizar(Professor professor);

    @Transactional
    public void ativar(Long professorId);
    @Transactional
    public void desativar(Long professorId);

}
