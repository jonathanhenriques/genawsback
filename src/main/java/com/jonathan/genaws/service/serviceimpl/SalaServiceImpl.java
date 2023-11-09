package com.jonathan.genaws.service.serviceimpl;

import com.jonathan.genaws.domain.exception.SalaNaoEncontradoException;
import com.jonathan.genaws.domain.model.Sala;
import com.jonathan.genaws.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SalaServiceImpl {

    @Autowired
    SalaRepository salaRepository;


    public List<Sala> findAll(){
        return salaRepository.findAll();
    }



    public Sala buscarOuFalhar(Long salaId){
        return salaRepository.findById(salaId)
                .orElseThrow(() -> new SalaNaoEncontradoException(salaId.toString()));
    }

    public Sala cadastrar(Sala sala){
        return salaRepository.save(sala);
    }

    public Sala atualizar(Sala sala){
        return salaRepository.save(sala);
    }


    @Transactional
    public void ativar(Long Id) {
        buscarOuFalhar(Id).ativar();
//        medicoBuscado.ativar();
//        medicoRepository.save(medico);
    }
    @Transactional
    public void desativar(Long Id) {
        buscarOuFalhar(Id).inativar();
//        medicoRepository.save(medico);
    }
}
