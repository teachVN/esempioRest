package it.formatemp.esempioRest.service;

import it.formatemp.esempioRest.model.Aula;
import it.formatemp.esempioRest.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaService {
    @Autowired
    private AulaRepository aulaRepository;

    public Aula salvaAula(Aula aula){
        return aulaRepository.save(aula);
    }

    public Aula getAulaById(int id){
        return aulaRepository.findById(id).orElseThrow();
    }

    public List<Aula> getAllAule(){
        return aulaRepository.findAll();
    }

    public Aula updateAula(int id, Aula aula){
        Aula aulaDaAggiornare = getAulaById(id);

        aulaDaAggiornare.setNome(aula.getNome());

        return aulaRepository.save(aulaDaAggiornare);
    }

    public String deleteAula(int id){
        Aula aulaDaCancellare = getAulaById(id);

        aulaRepository.delete(aulaDaCancellare);

        return "L'aula con id " + id + " cancellata";
    }
}
