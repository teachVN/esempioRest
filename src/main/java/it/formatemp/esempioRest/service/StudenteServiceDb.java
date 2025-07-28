package it.formatemp.esempioRest.service;

import it.formatemp.esempioRest.model.Studente;
import it.formatemp.esempioRest.repository.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudenteServiceDb {

    @Autowired
    private StudenteRepository studenteRepository;

    public Studente salvaStudente(Studente studente){
        return studenteRepository.save(studente);
    }

    public Studente getStudenteByMatricola(int matricola){
        return studenteRepository.findById(matricola).orElseThrow();
    }

    public List<Studente> getAllStudenti(){
        return studenteRepository.findAll();
    }

    public Studente updateStudente(int matricola, Studente studente){
        Studente studenteDaAggiornare = getStudenteByMatricola(matricola);

        studenteDaAggiornare.setNome(studente.getNome());
        studenteDaAggiornare.setCognome(studente.getCognome());
        studenteDaAggiornare.setDataNascita(studente.getDataNascita());

        return studenteRepository.save(studenteDaAggiornare);

    }

    public String deleteStudente(int matricola){
        Studente studenteDaCancellare = getStudenteByMatricola(matricola);

        studenteRepository.delete(studenteDaCancellare);

        return "Studente con matricola " + matricola + " cancellato";
    }
}
