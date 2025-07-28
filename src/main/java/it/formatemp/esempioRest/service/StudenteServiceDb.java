package it.formatemp.esempioRest.service;

import it.formatemp.esempioRest.dto.StudenteDto;
import it.formatemp.esempioRest.model.Aula;
import it.formatemp.esempioRest.model.Studente;
import it.formatemp.esempioRest.repository.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudenteServiceDb {

    @Autowired
    private StudenteRepository studenteRepository;

    @Autowired
    private AulaService aulaService;

    public Studente salvaStudente(StudenteDto studenteDto){

            Aula aulaDaCercare = aulaService.getAulaById(studenteDto.getAulaId());

            Studente studente = new Studente();
            studente.setNome(studenteDto.getNome());
            studente.setCognome(studenteDto.getCognome());
            studente.setDataNascita(studenteDto.getDataNascita());
            studente.setAula(aulaDaCercare);

            return studenteRepository.save(studente);

    }

    public Studente getStudenteByMatricola(int matricola){
        return studenteRepository.findById(matricola).orElseThrow();
    }

    public List<Studente> getAllStudenti(){
        return studenteRepository.findAll();
    }

    public Studente updateStudente(int matricola, StudenteDto studenteDto){
        Studente studenteDaAggiornare = getStudenteByMatricola(matricola);

        if(studenteDto.getAulaId()!=studenteDaAggiornare.getAula().getId()){
            Aula aulaDaAggiornare = aulaService.getAulaById(studenteDto.getAulaId());

            studenteDaAggiornare.setAula(aulaDaAggiornare);
        }

        studenteDaAggiornare.setNome(studenteDto.getNome());
        studenteDaAggiornare.setCognome(studenteDto.getCognome());
        studenteDaAggiornare.setDataNascita(studenteDto.getDataNascita());

        return studenteRepository.save(studenteDaAggiornare);

    }

    public String deleteStudente(int matricola){
        Studente studenteDaCancellare = getStudenteByMatricola(matricola);

        studenteRepository.delete(studenteDaCancellare);

        return "Studente con matricola " + matricola + " cancellato";
    }
}
