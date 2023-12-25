package com.jonathan.genawsapp.api.controller;


import com.jonathan.genawsapp.domain.model.Professor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Matricular Professor")
public interface MatriculaProfessorEmSala {


    @Operation(summary = "Matricular um professor em uma sala")
    Professor matricularProfessorEmSala(Long professorId, Long salaId);
}
