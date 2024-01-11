package com.example.foyerUniversitaire.Repository;

import com.example.foyerUniversitaire.Entity.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoyerRepository extends JpaRepository<Foyer, Long> {
    Foyer findByNomFoyer(String nomFoyer);
}
