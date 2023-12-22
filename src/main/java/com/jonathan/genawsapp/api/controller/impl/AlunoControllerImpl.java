package com.jonathan.genawsapp.api.controller.impl;
import com.jonathan.genawsapp.api.controller.AlunoController;
import com.jonathan.genawsapp.domain.model.Aluno;
import com.jonathan.genawsapp.repository.*;
//import com.jonathan.genawsapp.repository.AlunoRepository;
import com.jonathan.genawsapp.service.serviceimpl.AlunoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;





import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


import java.util.List;


@RestController
@RequestMapping(path = "/v1/alunos", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
//@Tag(name = "alunos")
public class AlunoControllerImpl implements AlunoController {


    @Autowired
    AlunoServiceImpl alunoService;

    @Autowired
    AlunoRepository alunoRepository;


//    @Operation(summary = "listar todos alunos")
//@Operation(summary = "listar todos alunos", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Upload de arquivo realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar o upload de arquivo"),
    })
    @GetMapping
    public List<Aluno> todos(){
        return alunoService.findAll();
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping(value = "/id/{alunoId}",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public Aluno buscarOuFalhar(@PathVariable("alunoId") Long alunoId){
        return alunoService.buscarOuFalhar(alunoId);
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso!"),
            @ApiResponse(responseCode = "201", description = "Objeto Persistido!"),
            @ApiResponse(responseCode = "400", description = "Erro na Requisição!"),
            @ApiResponse(responseCode = "401", description = "Autenticação é necessária"),
            @ApiResponse(responseCode = "403", description = "Usuário não possui permissão para realizar a ação!"),
    })
    @PostMapping(produces = "application/json;charset=UTF-8")
    public Aluno cadastrar(@Valid @RequestBody Aluno aluno){
        return alunoService.cadastrar(aluno);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso!"),
            @ApiResponse(responseCode = "201", description = "Objeto Persistido!"),
            @ApiResponse(responseCode = "400", description = "Erro na Requisição!"),
            @ApiResponse(responseCode = "401", description = "Autenticação é necessária"),
            @ApiResponse(responseCode = "403", description = "Usuário não possui permissão para realizar a ação!"),
    })
    @PutMapping(produces = "application/json;charset=UTF-8")
    public Aluno atualizar(@Valid @RequestBody Aluno aluno) {
        return alunoService.atualizar(aluno);
    }


//    @Operation(summary = "Ativar um aluno, inverte o delete lógico")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(
            path = "/{id}/ativar"
//            ,consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8"
    )
    public void ativar(@PathVariable("id") Long id) {

        alunoService.ativar(id);
    }

//    @Operation(summary = "Desativar um aluno, delete lógico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso!"),
            @ApiResponse(responseCode = "204", description = "Não há conteúdo!"),
            @ApiResponse(responseCode = "404", description = "Objeto Não Encontrado!")
    })
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(
            path = "/{id}/desativar"
//            ,consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8"
    )
    public void excluir(@PathVariable("id") Long id) {
        alunoService.desativar(id);
    }


}

