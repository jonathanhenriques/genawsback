package com.jonathan.genawsapp.service.serviceimpl;

import com.jonathan.genawsapp.domain.exception.ProfessorNaoEncontradoException;
import com.jonathan.genawsapp.domain.model.Professor;
import com.jonathan.genawsapp.repository.ProfessorRepository;
import com.jonathan.genawsapp.service.MatriculaProfessorEmSalaService;
import com.jonathan.genawsapp.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;


    private final AlunoServiceImpl alunoService;

    private final MatriculaProfessorEmSalaService matriculaProfessorEmSala;


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


    public Professor matriculaProfessorEmSala(Long professorId, Long salaId){
        return matriculaProfessorEmSala.matriculaProfessorEmSalaService(professorId, salaId);
    }




}
