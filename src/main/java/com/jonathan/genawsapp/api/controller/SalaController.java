package com.jonathan.genawsapp.api.controller;
import com.jonathan.genawsapp.domain.model.Sala;
import com.jonathan.genawsapp.service.*;
import com.jonathan.genawsapp.service.serviceimpl.SalaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/v1/salas", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SalaController {
    @Autowired
    private SalaServiceImpl salaService;


//    @Operation(summary = "listar todas Salas")
    @GetMapping
    public List<Sala> todos(){
        return salaService.findAll();
    }

//    @Operation(summary = "buscar por id uma Sala")
    @GetMapping(value = "/id/{salaId}",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public Sala buscarOuFalhar(@PathVariable("salaId") Long salaId){
        return salaService.buscarOuFalhar(salaId);
    }


//    @Operation(summary = "Cadastrar uma Sala")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public Sala cadastrar(@Valid @RequestBody Sala sala){
        return salaService.cadastrar(sala);
    }


//    @Operation(summary = "atualizar uma sala")
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

//    @Operation(summary = "Desativar uma Sala, delete lógico")
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

