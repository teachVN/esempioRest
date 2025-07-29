package it.formatemp.esempioRest.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudenteDto {
    @NotBlank(message = "il nome non può essere nè nullo nè vuoto nè composto di soli spazi")
    private String nome;
    @NotBlank(message = "il cognome non può essere nè nullo nè vuoto nè composto di soli spazi")
    private String cognome;

    private LocalDate dataNascita;

    private int aulaId;
}
