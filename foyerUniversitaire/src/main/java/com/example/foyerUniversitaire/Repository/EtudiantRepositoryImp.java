package com.example.foyerUniversitaire.Repository;

import com.example.foyerUniversitaire.Entity.Etudiant;

import java.util.Optional;

public class EtudiantRepositoryImp implements EtudiantRepositoryCustom{

    @Override
    public Optional<Etudiant> findByCin(long cin) {
        return Optional.empty();
    }

}
