package com.jonathan.genawsapp.api.controller;


import com.jonathan.genawsapp.domain.model.Aluno;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Aluno")
public interface AlunoController {

    @Operation(summary = "listar todos os alunos", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Upload de arquivo realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar o upload de arquivo"),
    })
    public List<Aluno> todos();


    @Operation(summary = "buscar um aluno por id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    public Aluno buscarOuFalhar(Long alunoId);


    @Operation(summary = "Cadastrar um aluno")
    public Aluno cadastrar(Aluno aluno);

    @Operation(summary = "atualizar um aluno")
    public Aluno atualizar(Aluno aluno);

    @Operation(summary = "Ativar um aluno, inverte o delete lógico")
    public void ativar(Long id);

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluir(Long id);

}
