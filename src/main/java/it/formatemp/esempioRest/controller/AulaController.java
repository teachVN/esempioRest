package it.formatemp.esempioRest.controller;

import it.formatemp.esempioRest.model.Aula;
import it.formatemp.esempioRest.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @PostMapping("/aule")
    public Aula salvaAula(@RequestBody Aula aula){
        return aulaService.salvaAula(aula);
    }

    @GetMapping("/aule/{id}")
    public Aula getAulaById(@PathVariable int id){
        return aulaService.getAulaById(id);
    }


    @GetMapping("/aule")
    public List<Aula> getAllAule(){
        return aulaService.getAllAule();
    }

    @PutMapping("/aule/{id}")
    public Aula updateAula(@PathVariable int id, @RequestBody Aula aula){
        return aulaService.updateAula(id, aula);
    }

    @DeleteMapping("/aule/{id}")
    public String deleteAula(@PathVariable int id){
        return aulaService.deleteAula(id);
    }
}
