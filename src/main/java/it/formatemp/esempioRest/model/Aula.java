package it.formatemp.esempioRest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "aule")
public class Aula {
    @Id
    @GeneratedValue
    private int id;
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "aula", cascade = CascadeType.REMOVE)
    private List<Studente> studenti;
}
