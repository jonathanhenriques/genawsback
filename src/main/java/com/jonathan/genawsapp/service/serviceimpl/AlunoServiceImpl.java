package com.jonathan.genawsapp.service.serviceimpl;

import com.jonathan.genawsapp.domain.exception.AlunoNaoEncontradoException;
import com.jonathan.genawsapp.domain.model.Aluno;
import com.jonathan.genawsapp.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class AlunoServiceImpl {

    @Autowired
    AlunoRepository alunoRepository;




    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }


    public Aluno buscarOuFalhar(Long alunoId){
        return alunoRepository.findById(alunoId)
                .orElseThrow(() -> new AlunoNaoEncontradoException(alunoId.toString()));
    }

    public Aluno cadastrar(Aluno aluno){


        aluno.setIsAtivo(true);

        return alunoRepository.save(aluno);
    }

    public Aluno atualizar(Aluno aluno){
        buscarOuFalhar(aluno.getId());
        return alunoRepository.save(aluno);
    }




    @Transactional
    public void ativar(Long alunoId) {
        buscarOuFalhar(alunoId).ativar();
    }
    @Transactional
    public void desativar(Long alunoId) {
        buscarOuFalhar(alunoId).inativar();
    }


}
