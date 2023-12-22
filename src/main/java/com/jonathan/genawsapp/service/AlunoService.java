package com.jonathan.genawsapp.service;

import com.jonathan.genawsapp.domain.model.Aluno;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface AlunoService {



    public List<Aluno> findAll();

    public Aluno buscarOuFalhar(Long alunoId);

    public Aluno cadastrar(Aluno aluno);

    public Aluno atualizar(Aluno aluno);

    @Transactional
    public void ativar(Long alunoId);
    @Transactional
    public void desativar(Long alunoId);


}
