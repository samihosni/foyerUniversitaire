package com.example.foyerUniversitaire.Repository;

import com.example.foyerUniversitaire.Entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    List<Chambre> findAllByNumChambreIn(List<Long> numChambres );
}
