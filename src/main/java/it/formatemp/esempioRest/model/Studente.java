package it.formatemp.esempioRest.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "studenti")
public class Studente {

    @Id
    @GeneratedValue
    private int matricola;
    private String nome;
    private String cognome;

    @Column(name = "data_nascita")
    private LocalDate dataNascita;
}
