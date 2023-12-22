package com.jonathan.genawsapp.domain.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "GENAWS_TB_PROFESSOR")
public class Professor {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    //    private UUID codigo;
//    private String codigo;


    //@Column(name = "nome_professor")
    @NotBlank
//@Size(max = 100, min = 3)
    @Column(name = "NOME_PROFESSOR", nullable = false, length = 100)
    @JsonAlias({"nomeProfessor", "nomeDoProfessor", "nome_Professor"})
    private String nomeProfessor;

    @Column(name = "IS_ATIVO", nullable = false, columnDefinition = "boolean default true")
    private Boolean isAtivo;

    public void ativar(){
        this.setIsAtivo(true);
    }

    public void inativar(){
        this.setIsAtivo(false);
    }


}
