package com.jonathan.genawsapp.domain.exception;
public class ProfessorNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public ProfessorNaoEncontradoException(String mensagem) {
        super(String.format("Não existe um cadastro de professor com código: %s", mensagem));
//        super(String.format("Não existe um cadastro de prof com código: %s", mensagem));
//        super(String.format(mensagem));
    }





}