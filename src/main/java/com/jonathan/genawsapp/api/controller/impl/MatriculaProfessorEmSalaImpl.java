package com.jonathan.genawsapp.api.controller.impl;

import com.jonathan.genawsapp.api.controller.MatriculaProfessorEmSala;
import com.jonathan.genawsapp.domain.model.Professor;
import com.jonathan.genawsapp.service.MatriculaProfessorEmSalaService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/v1/matricularprofessorsala", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class MatriculaProfessorEmSalaImpl implements MatriculaProfessorEmSala {


    private final MatriculaProfessorEmSalaService matriculaProfessorSala;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso!"),
            @ApiResponse(responseCode = "201", description = "Objeto Persistido!"),
            @ApiResponse(responseCode = "400", description = "Erro na Requisição!"),
            @ApiResponse(responseCode = "401", description = "Autenticação é necessária"),
            @ApiResponse(responseCode = "403", description = "Usuário não possui permissão para realizar a ação!"),
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public Professor matricularProfessorEmSala(Long professorId, Long salaId){
    return null;
    }
}
