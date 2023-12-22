package com.jonathan.genawsapp.api.controller;

import com.jonathan.genawsapp.domain.model.Sala;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

//tag que vincula o nome "sala" a tag de nome "sala" noa classe SpringDocConfig
/*
new Tag().name("sala").description("salas de aula"),
 */

@Tag(name = "Sala")
public interface SalaController {



    @Operation(summary = "listar todas Salas")
    List<Sala> todos();

    @Operation(summary = "buscar por id uma Sala")
    Sala buscarOuFalhar(Long idSala);

    @Operation(summary = "Cadastrar uma Sala")
    Sala cadastrar(Sala sala);
    @Operation(summary = "atualizar uma sala")
    Sala atualizar(Sala sala);

    @Operation(summary = "Ativar uma Sala, inverte o delete lógico")
    void ativar(Long id);

    @Operation(summary = "Desativar uma Sala, delete lógico")
    void excluir(Long id);




}
