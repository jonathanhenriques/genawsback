package com.jonathan.genawsapp.domain.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


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

//    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
//    private List<Sala> salas;

//    @OneToMany(mappedBy = "professor")
//    private List<Sala> salas;

    /**
     * Muitos professores associados a muitas salas diferentes
     * em uma nova tabela, somente para esses relacionamentos
     */
    @ManyToMany
    @JoinTable(name = "PROFESSOR_SALA",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "sala_id"))
    private List<Sala> salas;

    @Column(name = "IS_ATIVO", nullable = false, columnDefinition = "boolean default true")
    private Boolean isAtivo;

    public void ativar(){
        this.setIsAtivo(true);
    }

    public void inativar(){
        this.setIsAtivo(false);
    }


}
