package com.example.foyerUniversitaire.Repository;

import com.example.foyerUniversitaire.Entity.Etudiant;

import java.util.Optional;

public interface EtudiantRepositoryCustom {

    Optional<Etudiant> findByCin(long cin);

}
