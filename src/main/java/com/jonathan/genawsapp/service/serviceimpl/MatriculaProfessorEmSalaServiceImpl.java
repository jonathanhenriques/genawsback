package com.jonathan.genawsapp.service.serviceimpl;


import com.jonathan.genawsapp.domain.model.Aluno;
import com.jonathan.genawsapp.domain.model.Professor;
import com.jonathan.genawsapp.domain.model.Sala;
import com.jonathan.genawsapp.repository.MatriculaProfessorEmSalaRepository;
import com.jonathan.genawsapp.service.MatriculaProfessorEmSalaService;
import com.jonathan.genawsapp.service.ProfessorService;
import com.jonathan.genawsapp.service.SalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MatriculaProfessorEmSalaServiceImpl implements MatriculaProfessorEmSalaService {




    private final MatriculaProfessorEmSalaRepository matriculaProfessorEmSalaRepository;

    private final SalaService salaService;

    private final ProfessorService professorService;


    @Override
    public Professor matriculaProfessorEmSalaService(Long professorId, Long salaId) {

        Professor professor = professorService.buscarOuFalhar(professorId);
        Sala sala = salaService.buscarOuFalhar(salaId);

//        Set<Sala> salasProfessor =  professor.getSalas();
        professor.getSalas().add(sala);

        sala.getProfessores().add(professor);

        return professor;
    }
}
