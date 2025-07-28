package it.formatemp.esempioRest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BenvenutoController {

    //endpoint
    @GetMapping("")
    public String benvenuto(){
        return "BENVENUTO";
    }
    //{nome} significa path variable, cioè la parte variabile del path
    @GetMapping("/{nome}")
    public String benvenutoPersonalizzato(@PathVariable String nome){
        return "Benvenuto " + nome;
    }

    @GetMapping("/benvenuto")
    public String benvenutoPersonalizzatoCompleto(@RequestParam String nome, @RequestParam String cognome){
        return "Benvenuto " + nome + " " + cognome;
    }
}
