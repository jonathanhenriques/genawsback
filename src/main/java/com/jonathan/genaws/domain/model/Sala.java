package com.jonathan.genaws.domain.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "GENAWS_TB_SALA")
public class Sala {

    //    private UUID codigo;
//    private String codigo;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NUMERO_SALA", nullable = false, length = 100)
    @JsonAlias({"numeroeSala", "numerDaSala", "numero_sala"})
    private Long numeroSala;

//    @ManyToMany
//    @JoinTable(
//            name = "sala_aluno",
//            joinColumns = @JoinColumn(name = "sala_id"),
//            inverseJoinColumns = @JoinColumn(name = "aluno_id")
//    )
//    private Set<Aluno> alunos;
//
//    @ManyToMany
//    @JoinTable(
//            name = "sala_professor",
//            joinColumns = @JoinColumn(name = "sala_id"),
//            inverseJoinColumns = @JoinColumn(name = "professor_id")
//    )
//    private Set<Professor> professores;

    ///////////////////////////////////////////////////

//    @ManyToOne
//    @JoinColumn(name = "professor_id", referencedColumnName = "id", nullable = true)
//    private Professor professor;
//
//
//    @ManyToOne
//    @JoinColumn(name = "aluno_id", referencedColumnName = "id", nullable = true)
//    private Aluno aluno;


    //////////////////////////////////////////////////


//   @Positive
//   @Column(name = "NUMERO_SALA", nullable = true)
//    private Long numeroSala;

//    @OneToMany
//    private Set<Professor> professores;

//    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
//    private Set<Sala> salas;



//
//    @JsonIgnoreProperties(value = {"salasDeAula"}, allowSetters = true)
//    @OneToMany(mappedBy = "sala")
//   private List<Professor> professores;

//    @ManyToMany(mappedBy = "sala")
//    private Set<Aluno> alunos;

//    @ManyToMany(mappedBy = "sala")
//    private Set<Professor> professores;

//    @OneToMany(mappedBy = "sala")
//    private List<Aluno> alunos;



    @Column(name = "IS_ATIVO", nullable = false, columnDefinition = "boolean default true")
    private Boolean isAtivo;

    public void ativar(){
        this.setIsAtivo(true);
    }

    public void inativar(){
        this.setIsAtivo(false);
    }


//    @PrePersist /*antes de criar o registro este metodo e executado*/
//    private void gerarUUID(){
//        setCodigo(UUID.randomUUID().toString());
//    }

}
