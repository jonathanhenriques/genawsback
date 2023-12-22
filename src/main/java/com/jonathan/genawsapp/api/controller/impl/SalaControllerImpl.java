package com.jonathan.genawsapp.api.controller.impl;
import com.jonathan.genawsapp.api.controller.SalaController;
import com.jonathan.genawsapp.domain.model.Sala;
import com.jonathan.genawsapp.service.serviceimpl.SalaServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/v1/salas", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SalaControllerImpl implements SalaController {
    @Autowired
    private SalaServiceImpl salaService;


//    @Operation(summary = "listar todas Salas")
    @ApiResponses(value = @ApiResponse(responseCode = "200",description = "Sucesso!"))
    @GetMapping
    public List<Sala> todos(){
        return salaService.findAll();
    }

//    @Operation(summary = "buscar por id uma Sala")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso!"),
            @ApiResponse(responseCode = "404", description = "Objeto Não Encontrado!")
    })
    @GetMapping(value = "/id/{salaId}",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public Sala buscarOuFalhar(@PathVariable("salaId") Long salaId){
        return salaService.buscarOuFalhar(salaId);
    }


//    @Operation(summary = "Cadastrar uma Sala")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso!"),
            @ApiResponse(responseCode = "201", description = "Objeto Persistido!"),
            @ApiResponse(responseCode = "400", description = "Erro na Requisição!"),
            @ApiResponse(responseCode = "401", description = "Autenticação é necessária"),
            @ApiResponse(responseCode = "403", description = "Usuário não possui permissão para realizar a ação!"),
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public Sala cadastrar(@Valid @RequestBody Sala sala){
        return salaService.cadastrar(sala);
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso!"),
            @ApiResponse(responseCode = "201", description = "Objeto Persistido!"),
            @ApiResponse(responseCode = "400", description = "Erro na Requisição!"),
            @ApiResponse(responseCode = "401", description = "Autenticação é necessária"),
            @ApiResponse(responseCode = "403", description = "Usuário não possui permissão para realizar a ação!"),
    })
    @PutMapping(produces = "application/json;charset=UTF-8")
    public Sala atualizar(@Valid @RequestBody Sala sala) {
        return salaService.atualizar(sala);
    }

//    @Operation(summary = "Ativar uma Sala, inverte o delete lógico")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(
            path = "/{id}/ativar"
//            ,consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8"
    )
    public void ativar(@PathVariable("id") Long id) {

        salaService.ativar(id);
    }

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
        salaService.desativar(id);
    }


}

