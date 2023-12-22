package com.jonathan.genawsapp.api.controller;


import com.jonathan.genawsapp.domain.model.Professor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Professor")
public interface ProfessorController {

    @Operation(summary = "listar todos os professores")
    public List<Professor> todos();

    @Operation(summary = "buscar por id um professor")
    public Professor buscarOuFalhar(Long professorId);

    @Operation(summary = "Cadastrar um professor")
    public Professor cadastrar(Professor professor);

    @Operation(summary = "atualizar um professor")
    public Professor atualizar(Professor professor);

    @Operation(summary = "Ativar um professor, inverte o delete lógico")
    public void ativar(Long id);

    @Operation(summary = "Desativar um professor, delete lógico")
    public void excluir(@PathVariable("id") Long id);


}
