package com.jonathan.genawsapp.domain.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Entity
@Table(name = "GENAWS_TB_SALA")
public class Sala {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "NUMERO_SALA", nullable = false, length = 100)
    @JsonAlias({"numeroeSala", "numerDaSala", "numero_sala"})
    private Long numeroSala;

//    @ManyToOne
//    @JoinColumn(name = "professor_id")
//    private Professor professor;

//    @ManyToMany
//    @JoinTable(name = "SALA_PROFESSOR",
//            joinColumns = @JoinColumn(name = "sala_id"),
//            inverseJoinColumns = @JoinColumn(name = "professor_id"))
//    private List<Professor> professores;

    @ManyToMany(mappedBy = "salas")
    private Professor professor;

    @ManyToMany(mappedBy = "salas")
    private List<Aluno> alunos;

//    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
//    private List<Aluno> alunos;


    @Column(name = "IS_ATIVO", nullable = false, columnDefinition = "boolean default true")
    private Boolean isAtivo;

    public void ativar(){
        this.setIsAtivo(true);
    }

    public void inativar(){
        this.setIsAtivo(false);
    }


}
