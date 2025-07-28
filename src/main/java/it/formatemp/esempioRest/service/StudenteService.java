package it.formatemp.esempioRest.service;

import it.formatemp.esempioRest.model.Studente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudenteService {

    //viene utilizzato per gestire la logica di business. La logica di business viene applicata ai dati
    //che il service recupera, non direttamente, ma attraverso il repository

    private ArrayList<Studente> studenti=new ArrayList<>();

    public Studente salvaStudente(Studente studente){
        studenti.add(studente);

        return studente;
    }

    public Studente getStudenteByMatricola(int matricola){
        for(Studente studente: studenti){
            if(studente.getMatricola()==matricola){
                return studente;
            }

        }
        return null;
    }

    public List<Studente> getAllStudenti(){
        return studenti;
    }

    public Studente updateStudente(int matricola, Studente studente){

        Studente studenteDaAggiornare = getStudenteByMatricola(matricola);

        if(studenteDaAggiornare!=null){
            studenteDaAggiornare.setNome(studente.getNome());
            studenteDaAggiornare.setCognome(studente.getCognome());
            studenteDaAggiornare.setDataNascita(studente.getDataNascita());
        }

        return studenteDaAggiornare;

    }

    public String deleteStudente(int matricola){
        Studente studenteDaCancellare = getStudenteByMatricola(matricola);

        if(studenteDaCancellare!=null){
            studenti.remove(studenteDaCancellare);
            return "Studente con matricola " + matricola + " cancellato";
        }
        else{
            return "Studente con matricola " + matricola + " non trovato";
        }
    }
}
