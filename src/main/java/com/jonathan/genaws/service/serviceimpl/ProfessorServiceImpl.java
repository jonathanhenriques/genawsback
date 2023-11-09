package com.jonathan.genaws.service.serviceimpl;

import com.jonathan.genaws.domain.exception.ProfessorNaoEncontradoException;
import com.jonathan.genaws.domain.model.Aluno;
import com.jonathan.genaws.domain.model.Professor;
import com.jonathan.genaws.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl {

    @Autowired
    ProfessorRepository professorRepository;


    @Autowired
    AlunoServiceImpl alunoService;


    public List<Professor> findAll(){
        return professorRepository.findAll();
    }

//    public Aluno buscarOuFalhar(String alunoCodigo){
//        return alunoRepository.findAlunoByCodigo(alunoCodigo).
//                orElseThrow(() -> new AlunoNaoEncontradoException(alunoCodigo));
//    }

//    public List<Professor> findAllBySala(Sala sala){
//        return professorRepository.findAllBySala(sala);
//    }

    public Professor buscarOuFalhar(Long Id){
        return professorRepository.findById(Id)
                .orElseThrow(() -> new ProfessorNaoEncontradoException(Id.toString()));
    }

    public Professor cadastrar(Professor professor){
        return professorRepository.save(professor);
    }

    public Professor atualizar(Professor professor){
        buscarOuFalhar(professor.getId());
        return professorRepository.save(professor);
    }


//    public Optional<Professor> encontrarProfessorPorNome(String nomeProfessor) {
//        return professorRepository.findByNomeProfessorAluno(nomeProfessor);
//    }
//    public Professor findByNomeProfessorAluno(String nomeProfessor){
//        professorRepository.findByNomeProfessor((nomeProfessor))
//                .orElseThrow(() -> new ProfessorNaoEncontradoException(nomeProfessor.toString()));
//        return null;
//    }

//    public Professor findByNomeProfessor(Professor nomeProfessor){
//        professorRepository.findByNomeProfessor((nomeProfessor))
//                .orElseThrow(() -> new ProfessorNaoEncontradoException(nomeProfessor.toString()));
//        return null;
//    }


//    public Professor adicionarAlunoAoProfessor(Long professorId, Long alunoId){
//
//        Professor professorExistente = buscarOuFalhar(professorId);
//        Aluno alunoAdicionar = alunoService.buscarOuFalhar(alunoId);
//
//        if (alunoAdicionar != null) {
//            professorExistente.setAluno(alunoAdicionar);
//
//            alunoAdicionar.getProfessores().add(professorExistente);
//
//            alunoService.atualizar(alunoAdicionar);
//        }
//
//        return professorRepository.save(professorExistente);
//    }


    @Transactional
    public void ativar(Long Id) {
        buscarOuFalhar(Id).ativar();
//        medicoBuscado.ativar();
//        medicoRepository.save(medico);
    }
    @Transactional
    public void desativar(Long Id) {
        buscarOuFalhar(Id).inativar();
//        medicoRepository.save(medico);
    }
}
