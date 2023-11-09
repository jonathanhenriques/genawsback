package com.jonathan.genaws.service.serviceimpl;

import com.jonathan.genaws.domain.exception.AlunoNaoEncontradoException;
import com.jonathan.genaws.domain.exception.ProfessorNaoEncontradoException;
import com.jonathan.genaws.domain.model.Aluno;
import com.jonathan.genaws.domain.model.Professor;
import com.jonathan.genaws.domain.model.Sala;
import com.jonathan.genaws.repository.AlunoRepository;
import com.jonathan.genaws.service.SalaService;
import com.jonathan.genaws.service.serviceimpl.ProfessorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl {

    @Autowired
    AlunoRepository alunoRepository;




    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }

//    public Aluno buscarOuFalhar(String alunoCodigo){
//        return alunoRepository.findAlunoByCodigo(alunoCodigo).
//                orElseThrow(() -> new AlunoNaoEncontradoException(alunoCodigo));
//    }

//    public List<Aluno> findAllBySala(Sala sala){
//        return alunoRepository.findAllBySala(sala);
//    }



//    public Professor findByNomeProfessorAluno(String nomeProfessor){
//
//        Professor professorBuscado = professorService.findByNomeProfessorAluno(nomeProfessor);
//
////        Optional<Professor> professorBuscado = professorService.findByNomeProfessorAluno(nomeProfessor);
//
//        // Verifica se o professor foi encontrado
//        if (professorBuscado != null) {
//            return professorBuscado;
//        }
//
//        return null;
//    }


    public Aluno buscarOuFalhar(Long alunoId){
        return alunoRepository.findById(alunoId)
                .orElseThrow(() -> new AlunoNaoEncontradoException(alunoId.toString()));
    }

    public Aluno cadastrar(Aluno aluno){




        return alunoRepository.save(aluno);
    }

    public Aluno atualizar(Aluno aluno){
        buscarOuFalhar(aluno.getId());
        return alunoRepository.save(aluno);
    }




    @Transactional
    public void ativar(Long alunoId) {
        buscarOuFalhar(alunoId).ativar();
//        medicoBuscado.ativar();
//        medicoRepository.save(medico);
    }
    @Transactional
    public void desativar(Long alunoId) {
        buscarOuFalhar(alunoId).inativar();
//        medicoRepository.save(medico);
    }

//    public Professor procurarProfessorPorId(List<Professor> lista, Long idProcurado) {
//        for (Professor professor : lista) {
//            if (professor.getId() == idProcurado) {
//                return professor;
//            }
//        }
//        return null; // Retorna null se o objeto não for encontrado
//    }

}
