package it.formatemp.esempioRest.repository;

import it.formatemp.esempioRest.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudenteRepository extends JpaRepository<Studente, Integer> {
}
