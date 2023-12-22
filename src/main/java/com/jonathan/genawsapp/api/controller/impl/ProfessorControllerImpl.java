package com.jonathan.genawsapp.api.controller.impl;

import com.jonathan.genawsapp.api.controller.ProfessorController;
import com.jonathan.genawsapp.domain.model.Professor;
import com.jonathan.genawsapp.repository.*;
import com.jonathan.genawsapp.service.serviceimpl.ProfessorServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/professores", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProfessorControllerImpl implements ProfessorController {

    @Autowired
    ProfessorServiceImpl professorService;

    @Autowired
    ProfessorRepository professorRepository;



//    @GetMapping(value = "/testar")
//    public String teste(String letras){
//        return "funcionouuuuuuu";
//    }

//    @Operation(summary = "listar todos professores")
    @GetMapping
    public List<Professor> todos(){
        return professorService.findAll();
    }

//    @Operation(summary = "buscar por id um professor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso!"),
            @ApiResponse(responseCode = "404", description = "Objeto Não Encontrado!")
    })
    @GetMapping(value = "/id/{professorId}",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public Professor buscarOuFalhar(@PathVariable("professorId") Long professorId){
        return professorService.buscarOuFalhar(professorId);
    }


    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso!"),
        @ApiResponse(responseCode = "201", description = "Objeto Persistido!"),
        @ApiResponse(responseCode = "400", description = "Erro na Requisição!"),
        @ApiResponse(responseCode = "401", description = "Autenticação é necessária"),
        @ApiResponse(responseCode = "403", description = "Usuário não possui permissão para realizar a ação!"),
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public Professor cadastrar(@Valid @RequestBody Professor professor){
        return professorService.cadastrar(professor);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso!"),
            @ApiResponse(responseCode = "201", description = "Objeto Persistido!"),
            @ApiResponse(responseCode = "400", description = "Erro na Requisição!"),
            @ApiResponse(responseCode = "401", description = "Autenticação é necessária"),
            @ApiResponse(responseCode = "403", description = "Usuário não possui permissão para realizar a ação!"),
    })
    @PutMapping(produces = "application/json;charset=UTF-8")
    public Professor atualizar(@Valid @RequestBody Professor professor) {
        return professorService.atualizar(professor);
    }

//    @Operation(summary = "Ativar um professor, inverte o delete lógico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso!"),
        @ApiResponse(responseCode = "204", description = "Não há conteúdo!"),
        @ApiResponse(responseCode = "404", description = "Objeto Não Encontrado!")
    })
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(
            path = "/{id}/ativar"
//            ,consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8"
    )
    public void ativar(@PathVariable("id") Long id) {

        professorService.ativar(id);
    }

//    @Operation(summary = "Desativar um professor, delete lógico")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(
            path = "/{id}/desativar"
//            ,consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8"
    )
    public void excluir(@PathVariable("id") Long id) {
        professorService.desativar(id);
    }


}

