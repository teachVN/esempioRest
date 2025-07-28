package it.formatemp.esempioRest.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudenteDto {

    private String nome;
    private String cognome;
    private LocalDate dataNascita;

    private int aulaId;
}
