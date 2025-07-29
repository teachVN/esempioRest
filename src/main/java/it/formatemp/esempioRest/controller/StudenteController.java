package it.formatemp.esempioRest.controller;

import it.formatemp.esempioRest.dto.StudenteDto;
import it.formatemp.esempioRest.exception.ValidationException;
import it.formatemp.esempioRest.model.Studente;
import it.formatemp.esempioRest.service.StudenteService;
import it.formatemp.esempioRest.service.StudenteServiceDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudenteController {

    @Autowired
    private StudenteServiceDb studenteService;

    //solitamente il path del PostMapping è una collection uri. Lo studente da salvare si troverà dentro al corpo
    //della richiesta e @RequestBody serve proprio per recuperarlo nel body
    @PostMapping("/studenti")
    public Studente salvaStudente(@RequestBody @Validated StudenteDto studenteDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String message = "";

            for(ObjectError error:bindingResult.getAllErrors()){
                message+=error.getDefaultMessage() + ", ";
            }

            throw new ValidationException(message);
        }

        return studenteService.salvaStudente(studenteDto);
    }

    @GetMapping("/studenti/{matricola}")
    public Studente getStudenteByMatricola(@PathVariable int matricola){
        return studenteService.getStudenteByMatricola(matricola);
    }

    @GetMapping("/studenti")
    public List<Studente> getAllStudenti(){
        return studenteService.getAllStudenti();
    }

    @PutMapping("/studenti/{matricola}")
    public Studente updateStudente(@PathVariable int matricola, @RequestBody @Validated StudenteDto studenteDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String message = "";

            for(ObjectError error:bindingResult.getAllErrors()){
                message+=error.getDefaultMessage() + ", ";
            }

            throw new ValidationException(message);
        }

        return studenteService.updateStudente(matricola, studenteDto);
    }

    @DeleteMapping("/studenti/{matricola}")
    public String deleteStudente(@PathVariable int matricola){
        return studenteService.deleteStudente(matricola);
    }
}
