package com.jonathan.genaws.api.controller;
import com.jonathan.genaws.domain.exception.ProfessorNaoEncontradoException;
import com.jonathan.genaws.domain.model.Aluno;
import com.jonathan.genaws.domain.model.Professor;
import com.jonathan.genaws.repository.AlunoRepository;
import com.jonathan.genaws.service.serviceimpl.AlunoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path = "/v1/alunos", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunoController {


    @Autowired
    AlunoServiceImpl alunoService;

    @Autowired
    AlunoRepository alunoRepository;

//    @Autowired
//    ProfessorService professorService;


//    @GetMapping(value = "/testar")
//    public String teste(String letras){
//        return "funcionouuuuuuu";
//    }

//
//    @Operation(summary = "buscar nome do professor de um aluno")
//    @GetMapping(value = "professor/{nomeProfessor}")
//    public String findByNomeProfessor(@PathVariable("nomeProfessor") String nomeProfessor){
//
//       Professor professorEncontrad = alunoService.findByNomeProfessorAluno(nomeProfessor);
//        if(professorEncontrad != null){
//            return  professorEncontrad.getNomeProfessor();
//        }
////        return throw new
//return "Professor não encontrado";
////        return alunoService.findByNomeProfessor(nomeProfessor);
//    }

//        @Operation(summary = "buscar nome do professor de um aluno")
//    @GetMapping(value = "professor/{nomeProfessor}")
//    public String findByNomeProfessor(@PathVariable("nomeProfessor") String nomeProfessor){
//            Professor professorBuscado = professorService.findByNomeProfessorAluno(nomeProfessor);
//
////        Optional<Professor> professorBuscado = professorService.findByNomeProfessorAluno(nomeProfessor);
//
//            // Verifica se o professor foi encontrado
//            if (professorBuscado != null) {
//                return professorBuscado.getNomeProfessor();
//            }
//
//            return null;
//        }


    @Operation(summary = "listar todos alunos")
    @GetMapping
    public List<Aluno> todos(){
        return alunoService.findAll();
    }

    @Operation(summary = "buscar um aluno por id")
    @GetMapping(value = "/id/{alunoId}",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public Aluno buscarOuFalhar(@PathVariable("alunoId") Long alunoId){
        return alunoService.buscarOuFalhar(alunoId);
    }


    @Operation(summary = "Cadastrar um aluno")
    @PostMapping(produces = "application/json;charset=UTF-8")
    public Aluno cadastrar(@Valid @RequestBody Aluno aluno){
        return alunoService.cadastrar(aluno);
    }

    @Operation(summary = "atualizar um aluno")
    @PutMapping(produces = "application/json;charset=UTF-8")
    public Aluno atualizar(@Valid @RequestBody Aluno aluno) {
        return alunoService.atualizar(aluno);
    }


        @Operation(summary = "Ativar um aluno, inverte o delete lógico")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(
            path = "/{id}/ativar"
//            ,consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8"
    )
    public void ativar(@PathVariable("id") Long id) {

        alunoService.ativar(id);
    }

        @Operation(summary = "Desativar um aluno, delete lógico")
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

