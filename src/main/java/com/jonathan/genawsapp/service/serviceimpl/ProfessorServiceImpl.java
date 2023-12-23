package com.jonathan.genawsapp.service.serviceimpl;

import com.jonathan.genawsapp.domain.exception.ProfessorNaoEncontradoException;
import com.jonathan.genawsapp.domain.model.Professor;
import com.jonathan.genawsapp.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfessorServiceImpl {

    @Autowired
    ProfessorRepository professorRepository;


    @Autowired
    AlunoServiceImpl alunoService;


    public List<Professor> findAll(){
        return professorRepository.findAll();
    }

    public Professor buscarOuFalhar(Long Id){
        return professorRepository.findById(Id)
                .orElseThrow(() -> new ProfessorNaoEncontradoException(Id.toString()));
    }

    public Professor cadastrar(Professor professor){
        professor.setIsAtivo(true);
        return professorRepository.save(professor);
    }

    public Professor atualizar(Professor professor){
        buscarOuFalhar(professor.getId());
        return professorRepository.save(professor);
    }

    @Transactional
    public void ativar(Long Id) {
        buscarOuFalhar(Id).ativar();
    }
    @Transactional
    public void desativar(Long Id) {
        buscarOuFalhar(Id).inativar();
    }
}
