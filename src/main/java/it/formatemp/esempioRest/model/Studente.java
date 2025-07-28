package it.formatemp.esempioRest.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Studente {

    private int matricola;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
}
