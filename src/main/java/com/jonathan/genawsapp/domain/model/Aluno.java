package com.jonathan.genawsapp.domain.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "GENAWS_TB_ALUNO")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private String codigo;

    @NotBlank
    @Size(max = 100, min = 3)
    @Column(name = "NOME", nullable = true, length = 100)
    @JsonAlias({"nome", "nomeAluno", "nome_Aluno", "aluno",})
    private String nome;

    @Positive
    @Column(name = "IDADE", nullable = false)
    private Long idade;

    @PositiveOrZero
    @Column(name = "NOTA_PRIMEIRO_SEMESTRE", nullable = true)
    @JsonAlias({"notaPrimeiroSemestre", "nota_Primeiro_Semestre","notaprimeirosemestre",})
    private Long notaPrimeiroSemestre;

    @PositiveOrZero
    @Column(name = "NOTA_SEGUNDO_SEMESTRE", nullable = true)
    @JsonAlias({"notaSegundoSemestre", "nota_Segundo_Semestre","nota_segundo_semestre",})
    private Long notaSegundoSemestre;

    @Column(name = "NOME_PROFESSOR", nullable = true)
    @JsonAlias({"nomeProfessor", "nome_Professor","nomeprofessor",})
    private String nomeProfessor;

    @Size(max = 100, min = 0)
    @Column(name = "NUMERO_SALA", nullable = true)
    private String numeroSala;

    @Column(name = "IS_ATIVO", nullable = false, columnDefinition = "boolean default true")
    private Boolean isAtivo;

    public void ativar(){
        this.setIsAtivo(true);
    }

    public void inativar(){
        this.setIsAtivo(false);
    }


}
