package it.formatemp.esempioRest.controller;

import it.formatemp.esempioRest.model.Studente;
import it.formatemp.esempioRest.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudenteController {

    @Autowired
    private StudenteService studenteService;

    //solitamente il path del PostMapping è una collection uri. Lo studente da salvare si troverà dentro al corpo
    //della richiesta e @RequestBody serve proprio per recuperarlo nel body
    @PostMapping("/studenti")
    public Studente salvaStudente(@RequestBody Studente studente){
        return studenteService.salvaStudente(studente);
    }

    @GetMapping("/studenti/{matricola}")
    public Studente getStudenteByMatricola(@PathVariable int matricola){
        return studenteService.getStudenteByMatricola(matricola);
    }

    @GetMapping("/studenti")
    public List<Studente> getAllStudenti(){
        return studenteService.getAllStudenti();
    }

    @PutMapping("/studenti")
    public Studente updateStudente(int matricola, Studente studente){
        return studenteService.updateStudente(matricola, studente);
    }
}
